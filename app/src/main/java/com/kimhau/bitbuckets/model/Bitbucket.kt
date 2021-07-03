package com.kimhau.bitbuckets.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class Bitbucket(
    @Json(name = "created_on")
    val createdOn: String?,
    @Json(name = "description")
    val description: String?,
    @Json(name = "fork_policy")
    val forkPolicy: String?,
    @Json(name = "full_name")
    val fullName: String?,
    @Json(name = "has_issues")
    val hasIssues: Boolean?,
    @Json(name = "has_wiki")
    val hasWiki: Boolean?,
    @Json(name = "is_private")
    val isPrivate: Boolean?,
    @Json(name = "language")
    val language: String?,
    @Json(name = "links")
    val links: Links?,
    @Json(name = "mainbranch")
    val mainbranch: Mainbranch?,
    @Json(name = "name")
    val name: String?,
    @Json(name = "owner")
    val owner: Owner?,
    @Json(name = "project")
    val project: Project?,
    @Json(name = "scm")
    val scm: String?,
    @Json(name = "size")
    val size: Int?,
    @Json(name = "slug")
    val slug: String?,
    @Json(name = "type")
    val type: String?,
    @Json(name = "updated_on")
    val updatedOn: String?,
    @Json(name = "uuid")
    val uuid: String?,
    @Json(name = "website")
    val website: String?,
    @Json(name = "workspace")
    val workspace: Workspace?
) : Parcelable

@JsonClass(generateAdapter = true)
@Parcelize
data class Links(
    @Json(name = "avatar")
    val avatar: Avatar?,
    @Json(name = "branches")
    val branches: Branches?,
    @Json(name = "clone")
    val clone: List<Clone>?,
    @Json(name = "commits")
    val commits: Commits?,
    @Json(name = "downloads")
    val downloads: Downloads?,
    @Json(name = "forks")
    val forks: Forks?,
    @Json(name = "hooks")
    val hooks: Hooks?,
    @Json(name = "html")
    val html: Html?,
    @Json(name = "issues")
    val issues: Issues?,
    @Json(name = "pullrequests")
    val pullrequests: Pullrequests?,
    @Json(name = "self")
    val self: Self?,
    @Json(name = "source")
    val source: Source?,
    @Json(name = "tags")
    val tags: Tags?,
    @Json(name = "watchers")
    val watchers: Watchers?
) : Parcelable

@JsonClass(generateAdapter = true)
@Parcelize
data class Mainbranch(
    @Json(name = "name")
    val name: String?,
    @Json(name = "type")
    val type: String?
) : Parcelable

@JsonClass(generateAdapter = true)
@Parcelize
data class Owner(
    @Json(name = "account_id")
    val accountId: String?,
    @Json(name = "display_name")
    val displayName: String?,
    @Json(name = "links")
    val links: LinksX?,
    @Json(name = "nickname")
    val nickname: String?,
    @Json(name = "type")
    val type: String?,
    @Json(name = "username")
    val username: String?,
    @Json(name = "uuid")
    val uuid: String?
) : Parcelable

@JsonClass(generateAdapter = true)
@Parcelize
data class Project(
    @Json(name = "key")
    val key: String?,
    @Json(name = "links")
    val links: LinksXX?,
    @Json(name = "name")
    val name: String?,
    @Json(name = "type")
    val type: String?,
    @Json(name = "uuid")
    val uuid: String?
) : Parcelable

@JsonClass(generateAdapter = true)
@Parcelize
data class Workspace(
    @Json(name = "links")
    val links: LinksXXX?,
    @Json(name = "name")
    val name: String?,
    @Json(name = "slug")
    val slug: String?,
    @Json(name = "type")
    val type: String?,
    @Json(name = "uuid")
    val uuid: String?
) : Parcelable

@JsonClass(generateAdapter = true)
@Parcelize
data class Avatar(
    @Json(name = "href")
    val href: String?
) : Parcelable

@JsonClass(generateAdapter = true)
@Parcelize
data class Branches(
    @Json(name = "href")
    val href: String?
) : Parcelable

@JsonClass(generateAdapter = true)
@Parcelize
data class Clone(
    @Json(name = "href")
    val href: String?,
    @Json(name = "name")
    val name: String?
) : Parcelable

@JsonClass(generateAdapter = true)
@Parcelize
data class Commits(
    @Json(name = "href")
    val href: String?
) : Parcelable

@JsonClass(generateAdapter = true)
@Parcelize
data class Downloads(
    @Json(name = "href")
    val href: String?
) : Parcelable

@JsonClass(generateAdapter = true)
@Parcelize
data class Forks(
    @Json(name = "href")
    val href: String?
) : Parcelable

@JsonClass(generateAdapter = true)
@Parcelize
data class Hooks(
    @Json(name = "href")
    val href: String?
) : Parcelable

@JsonClass(generateAdapter = true)
@Parcelize
data class Html(
    @Json(name = "href")
    val href: String?
) : Parcelable

@JsonClass(generateAdapter = true)
@Parcelize
data class Issues(
    @Json(name = "href")
    val href: String?
) : Parcelable

@JsonClass(generateAdapter = true)
@Parcelize
data class Pullrequests(
    @Json(name = "href")
    val href: String?
) : Parcelable

@JsonClass(generateAdapter = true)
@Parcelize
data class Self(
    @Json(name = "href")
    val href: String?
) : Parcelable

@JsonClass(generateAdapter = true)
@Parcelize
data class Source(
    @Json(name = "href")
    val href: String?
) : Parcelable

@JsonClass(generateAdapter = true)
@Parcelize
data class Tags(
    @Json(name = "href")
    val href: String?
) : Parcelable

@JsonClass(generateAdapter = true)
@Parcelize
data class Watchers(
    @Json(name = "href")
    val href: String?
) : Parcelable

@JsonClass(generateAdapter = true)
@Parcelize
data class LinksX(
    @Json(name = "avatar")
    val avatar: AvatarX?,
    @Json(name = "html")
    val html: HtmlX?,
    @Json(name = "self")
    val self: SelfX?
) : Parcelable

@JsonClass(generateAdapter = true)
@Parcelize
data class AvatarX(
    @Json(name = "href")
    val href: String?
) : Parcelable

@JsonClass(generateAdapter = true)
@Parcelize
data class HtmlX(
    @Json(name = "href")
    val href: String?
) : Parcelable

@JsonClass(generateAdapter = true)
@Parcelize
data class SelfX(
    @Json(name = "href")
    val href: String?
) : Parcelable

@JsonClass(generateAdapter = true)
@Parcelize
data class LinksXX(
    @Json(name = "avatar")
    val avatar: AvatarXX?,
    @Json(name = "html")
    val html: HtmlXX?,
    @Json(name = "self")
    val self: SelfXX?
) : Parcelable

@JsonClass(generateAdapter = true)
@Parcelize
data class AvatarXX(
    @Json(name = "href")
    val href: String?
) : Parcelable

@JsonClass(generateAdapter = true)
@Parcelize
data class HtmlXX(
    @Json(name = "href")
    val href: String?
) : Parcelable

@JsonClass(generateAdapter = true)
@Parcelize
data class SelfXX(
    @Json(name = "href")
    val href: String?
) : Parcelable

@JsonClass(generateAdapter = true)
@Parcelize
data class LinksXXX(
    @Json(name = "avatar")
    val avatar: AvatarXXX?,
    @Json(name = "html")
    val html: HtmlXXX?,
    @Json(name = "self")
    val self: SelfXXX?
) : Parcelable

@JsonClass(generateAdapter = true)
@Parcelize
data class AvatarXXX(
    @Json(name = "href")
    val href: String?
) : Parcelable

@JsonClass(generateAdapter = true)
@Parcelize
data class HtmlXXX(
    @Json(name = "href")
    val href: String?
) : Parcelable

@JsonClass(generateAdapter = true)
@Parcelize
data class SelfXXX(
    @Json(name = "href")
    val href: String?
) : Parcelable