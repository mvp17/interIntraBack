package com.interapp.externa.modules.searchByEntity.domain

data class FilterJSONGodfatherDTO(
    var godfatherId: String?,
    var godfatherName: String?,
    var godfatherLastName1: String?,
    var godfatherLastName2: String?,
    var godfatherGender: String?,
    var godfatherBirthdayFromDate: String?,
    var godfatherBirthdayToDate: String?,
    var godfatherDistrict: String?,
    var godfatherNeigh: String?
) {
    fun hasGodfatherId(): Boolean {
        return !godfatherId.isNullOrEmpty()
    }
    fun hasGodfatherName(): Boolean {
        return !godfatherName.isNullOrEmpty()
    }
    fun hasGodfatherLastName1(): Boolean {
        return !godfatherLastName1.isNullOrEmpty()
    }
    fun hasGodfatherLastName2(): Boolean {
        return !godfatherLastName2.isNullOrEmpty()
    }
    fun hasGodfatherGender(): Boolean {
        return !godfatherGender.isNullOrEmpty()
    }
    fun hasGodfatherBirthdayFromDate(): Boolean {
        return !godfatherBirthdayFromDate.isNullOrEmpty()
    }
    fun hasGodfatherBirthdayToDate(): Boolean {
        return !godfatherBirthdayToDate.isNullOrEmpty()
    }
    fun hasGodfatherDistrict(): Boolean {
        return !godfatherDistrict.isNullOrEmpty()
    }
    fun hasGodfatherNeigh(): Boolean {
        return !godfatherNeigh.isNullOrEmpty()
    }
}
