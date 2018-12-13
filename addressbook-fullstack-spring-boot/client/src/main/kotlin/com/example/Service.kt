package com.example

import pl.treksoft.kvision.remote.Profile
import pl.treksoft.kvision.remote.SpringRemoteAgent

object AddressAgent : SpringRemoteAgent<AddressService>(AddressServiceManager)

object ProfileAgent : SpringRemoteAgent<ProfileService>(ProfileServiceManager)

object RegisterProfileAgent : SpringRemoteAgent<RegisterProfileService>(RegisterProfileServiceManager)

actual class AddressService : IAddressService {
    override suspend fun getAddressList(search: String?, types: String, sort: Sort) =
        AddressAgent.call(IAddressService::getAddressList, search, types, sort)

    override suspend fun addAddress(address: Address) = AddressAgent.call(IAddressService::addAddress, address)

    override suspend fun updateAddress(address: Address) = AddressAgent.call(IAddressService::updateAddress, address)

    override suspend fun deleteAddress(id: Int) = AddressAgent.call(IAddressService::deleteAddress, id)
}

actual class ProfileService : IProfileService {
    override suspend fun getProfile() = ProfileAgent.call(IProfileService::getProfile)
}

actual class RegisterProfileService : IRegisterProfileService {
    override suspend fun registerProfile(profile: Profile, password: String) =
        RegisterProfileAgent.call(IRegisterProfileService::registerProfile, profile, password)
}
