package com.app.koreq.commlistview.net.bean;

import com.app.koreq.commlistview.net.frame.bean.BaseHttpResponse;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * project : CommListView
 * author : YanBin on 4/12/17
 * version : v3.0
 * description : retrofit 使用  - reponse 反序列化
 */
public class TreeResult extends BaseHttpResponse{

    /**
     * statuses : [{"range":"","bucket":"hyww201407","domain":"bbtree.com/","video_name":"","id":480242372,"mongo_timeline_id":"5902a36d05a5f69a092c6ffd","timeline_school_id":202032240,"date":"2017-04-28 10:05:33","keyword":"","content":"","issecret":0,"is_shield":0,"is_essence":0,"source":"","type":3,"from_user":{"user_id":212766969,"username":"13833333967","name":"朱百旭","call":"园长","avatar":"","school_app_type":0,"birthday":"","sex":0,"type":3,"class_id":0,"class_name":"","class_pic":"","school_id":202032240,"school_name":"北京迪士尼幼儿园","status":2,"is_vip":true,"is_active":true,"is_invite":true,"invite_code":"","child_id":0,"attendance_type":"1","invit_number":0,"is_graduation":0,"subtype":"13","style":1,"user_wall":"","crown_pic":"","signature":"","nickname":"","stages":0,"provinceid":0,"cityid":0,"areaid":0,"longitude":"","latitude":"","parent_sex":1,"enabled":"1","origin":"0","is_member":0,"is_class_star":0},"pics_string":"2017/04/28/3925e1ec3d444c23f8db65282919fddb/And/1493345129274-1244746321.jpg|2017/04/28/3925e1ec3d444c23f8db65282919fddb/And/1493345129274-1244746321.jpg@200h_200w|2017/04/28/3925e1ec3d444c23f8db65282919fddb/And/1493345129274-1244746321.jpg@1920h_1080w","pics":[{"orig_pic":"http://filesystem1.bbtree.com/2017/04/28/3925e1ec3d444c23f8db65282919fddb/And/1493345129274-1244746321.jpg@1920h_1080w_1e_1c","thumb_pic":"http://filesystem1.bbtree.com/2017/04/28/3925e1ec3d444c23f8db65282919fddb/And/1493345129274-1244746321.jpg@200h_200w_1e_1c","original_pic":"http://filesystem1.bbtree.com/2017/04/28/3925e1ec3d444c23f8db65282919fddb/And/1493345129274-1244746321.jpg"}],"file_domain":"","comment_count":0,"comment_list":[],"praise_count":0,"praise_user":[]},{"range":"","bucket":"hyww201407","domain":"bbtree.com/","video_name":"","id":480242235,"mongo_timeline_id":"59026ab425a5f63e54ee148f","timeline_school_id":202032240,"date":"2017-04-28 06:03:32","keyword":"","content":"","issecret":0,"is_shield":0,"is_essence":0,"source":"","type":3,"from_user":{"user_id":206904720,"username":"13833332818","name":"熊冬梅","call":"园长","avatar":"","school_app_type":0,"birthday":"","sex":0,"type":3,"class_id":0,"class_name":"","class_pic":"","school_id":202032240,"school_name":"北京迪士尼幼儿园","status":2,"is_vip":true,"is_active":true,"is_invite":true,"invite_code":"","child_id":0,"attendance_type":"1","invit_number":0,"is_graduation":0,"subtype":"13","style":1,"user_wall":"","crown_pic":"","signature":"","nickname":"","stages":0,"provinceid":0,"cityid":0,"areaid":0,"longitude":"","latitude":"","parent_sex":1,"enabled":"1","origin":"0","is_member":0,"is_class_star":0},"pics_string":"2017/04/28/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493330584331-1244746321.jpg|2017/04/28/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493330584331-1244746321.jpg@200h_200w|2017/04/28/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493330584331-1244746321.jpg@1488h_1984w,2017/04/28/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493330586279-1244746321.jpg|2017/04/28/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493330586279-1244746321.jpg@200h_200w|2017/04/28/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493330586279-1244746321.jpg@1984h_1488w,2017/04/28/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493330587846-1244746321.jpg|2017/04/28/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493330587846-1244746321.jpg@200h_200w|2017/04/28/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493330587846-1244746321.jpg@1984h_1488w,2017/04/28/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493330588771-1244746321.jpg|2017/04/28/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493330588771-1244746321.jpg@200h_200w|2017/04/28/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493330588771-1244746321.jpg@1984h_1488w,2017/04/28/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493330590748-1244746321.jpg|2017/04/28/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493330590748-1244746321.jpg@200h_200w|2017/04/28/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493330590748-1244746321.jpg@1488h_1984w,2017/04/28/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493330591640-1244746321.jpg|2017/04/28/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493330591640-1244746321.jpg@200h_200w|2017/04/28/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493330591640-1244746321.jpg@1984h_1488w,2017/04/28/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493330592908-1244746321.jpg|2017/04/28/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493330592908-1244746321.jpg@200h_200w|2017/04/28/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493330592908-1244746321.jpg@1984h_1488w,2017/04/28/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493330594141-1244746321.jpg|2017/04/28/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493330594141-1244746321.jpg@200h_200w|2017/04/28/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493330594141-1244746321.jpg@1984h_1488w,2017/04/28/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493330595158-1244746321.jpg|2017/04/28/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493330595158-1244746321.jpg@200h_200w|2017/04/28/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493330595158-1244746321.jpg@1488h_1984w,2017/04/28/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493330596310-1244746321.jpg|2017/04/28/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493330596310-1244746321.jpg@200h_200w|2017/04/28/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493330596310-1244746321.jpg@1488h_1984w","pics":[{"orig_pic":"http://filesystem1.bbtree.com/2017/04/28/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493330584331-1244746321.jpg@1488h_1984w_1e_1c","thumb_pic":"http://filesystem1.bbtree.com/2017/04/28/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493330584331-1244746321.jpg@200h_200w_1e_1c","original_pic":"http://filesystem1.bbtree.com/2017/04/28/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493330584331-1244746321.jpg"},{"orig_pic":"http://filesystem1.bbtree.com/2017/04/28/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493330586279-1244746321.jpg@1984h_1488w_1e_1c","thumb_pic":"http://filesystem1.bbtree.com/2017/04/28/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493330586279-1244746321.jpg@200h_200w_1e_1c","original_pic":"http://filesystem1.bbtree.com/2017/04/28/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493330586279-1244746321.jpg"},{"orig_pic":"http://filesystem1.bbtree.com/2017/04/28/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493330587846-1244746321.jpg@1984h_1488w_1e_1c","thumb_pic":"http://filesystem1.bbtree.com/2017/04/28/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493330587846-1244746321.jpg@200h_200w_1e_1c","original_pic":"http://filesystem1.bbtree.com/2017/04/28/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493330587846-1244746321.jpg"},{"orig_pic":"http://filesystem1.bbtree.com/2017/04/28/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493330588771-1244746321.jpg@1984h_1488w_1e_1c","thumb_pic":"http://filesystem1.bbtree.com/2017/04/28/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493330588771-1244746321.jpg@200h_200w_1e_1c","original_pic":"http://filesystem1.bbtree.com/2017/04/28/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493330588771-1244746321.jpg"},{"orig_pic":"http://filesystem1.bbtree.com/2017/04/28/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493330590748-1244746321.jpg@1488h_1984w_1e_1c","thumb_pic":"http://filesystem1.bbtree.com/2017/04/28/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493330590748-1244746321.jpg@200h_200w_1e_1c","original_pic":"http://filesystem1.bbtree.com/2017/04/28/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493330590748-1244746321.jpg"},{"orig_pic":"http://filesystem1.bbtree.com/2017/04/28/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493330591640-1244746321.jpg@1984h_1488w_1e_1c","thumb_pic":"http://filesystem1.bbtree.com/2017/04/28/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493330591640-1244746321.jpg@200h_200w_1e_1c","original_pic":"http://filesystem1.bbtree.com/2017/04/28/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493330591640-1244746321.jpg"},{"orig_pic":"http://filesystem1.bbtree.com/2017/04/28/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493330592908-1244746321.jpg@1984h_1488w_1e_1c","thumb_pic":"http://filesystem1.bbtree.com/2017/04/28/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493330592908-1244746321.jpg@200h_200w_1e_1c","original_pic":"http://filesystem1.bbtree.com/2017/04/28/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493330592908-1244746321.jpg"},{"orig_pic":"http://filesystem1.bbtree.com/2017/04/28/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493330594141-1244746321.jpg@1984h_1488w_1e_1c","thumb_pic":"http://filesystem1.bbtree.com/2017/04/28/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493330594141-1244746321.jpg@200h_200w_1e_1c","original_pic":"http://filesystem1.bbtree.com/2017/04/28/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493330594141-1244746321.jpg"},{"orig_pic":"http://filesystem1.bbtree.com/2017/04/28/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493330595158-1244746321.jpg@1488h_1984w_1e_1c","thumb_pic":"http://filesystem1.bbtree.com/2017/04/28/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493330595158-1244746321.jpg@200h_200w_1e_1c","original_pic":"http://filesystem1.bbtree.com/2017/04/28/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493330595158-1244746321.jpg"},{"orig_pic":"http://filesystem1.bbtree.com/2017/04/28/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493330596310-1244746321.jpg@1488h_1984w_1e_1c","thumb_pic":"http://filesystem1.bbtree.com/2017/04/28/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493330596310-1244746321.jpg@200h_200w_1e_1c","original_pic":"http://filesystem1.bbtree.com/2017/04/28/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493330596310-1244746321.jpg"}],"file_domain":"","comment_count":0,"comment_list":[],"praise_count":0,"praise_user":[]},{"range":"","bucket":"hyww201407","domain":"bbtree.com/","video_name":"","id":480240249,"mongo_timeline_id":"58fe569ce6a4f6efd728c798","timeline_school_id":202032240,"date":"2017-04-25 03:48:44","keyword":"","content":"八大关风景区","issecret":0,"is_shield":0,"is_essence":0,"source":"","type":3,"from_user":{"user_id":206904720,"username":"13833332818","name":"熊冬梅","call":"园长","avatar":"","school_app_type":0,"birthday":"","sex":0,"type":3,"class_id":0,"class_name":"","class_pic":"","school_id":202032240,"school_name":"北京迪士尼幼儿园","status":2,"is_vip":true,"is_active":true,"is_invite":true,"invite_code":"","child_id":0,"attendance_type":"1","invit_number":0,"is_graduation":0,"subtype":"13","style":1,"user_wall":"","crown_pic":"","signature":"","nickname":"","stages":0,"provinceid":0,"cityid":0,"areaid":0,"longitude":"","latitude":"","parent_sex":1,"enabled":"1","origin":"0","is_member":0,"is_class_star":0},"pics_string":"2017/04/25/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493063303666-1244746321.jpg|2017/04/25/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493063303666-1244746321.jpg@200h_200w|2017/04/25/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493063303666-1244746321.jpg@1984h_1488w,2017/04/25/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493063304320-1244746321.jpg|2017/04/25/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493063304320-1244746321.jpg@200h_200w|2017/04/25/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493063304320-1244746321.jpg@1984h_1488w,2017/04/25/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493063304938-1244746321.jpg|2017/04/25/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493063304938-1244746321.jpg@200h_200w|2017/04/25/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493063304938-1244746321.jpg@1984h_1488w,2017/04/25/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493063305428-1244746321.jpg|2017/04/25/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493063305428-1244746321.jpg@200h_200w|2017/04/25/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493063305428-1244746321.jpg@1488h_1984w,2017/04/25/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493063306277-1244746321.jpg|2017/04/25/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493063306277-1244746321.jpg@200h_200w|2017/04/25/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493063306277-1244746321.jpg@1984h_1488w,2017/04/25/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493063306905-1244746321.jpg|2017/04/25/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493063306905-1244746321.jpg@200h_200w|2017/04/25/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493063306905-1244746321.jpg@1984h_1488w,2017/04/25/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493063307421-1244746321.jpg|2017/04/25/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493063307421-1244746321.jpg@200h_200w|2017/04/25/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493063307421-1244746321.jpg@1984h_1488w,2017/04/25/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493063307880-1244746321.jpg|2017/04/25/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493063307880-1244746321.jpg@200h_200w|2017/04/25/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493063307880-1244746321.jpg@1984h_1488w,2017/04/25/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493063308614-1244746321.jpg|2017/04/25/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493063308614-1244746321.jpg@200h_200w|2017/04/25/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493063308614-1244746321.jpg@1984h_1488w,2017/04/25/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493063309146-1244746321.jpg|2017/04/25/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493063309146-1244746321.jpg@200h_200w|2017/04/25/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493063309146-1244746321.jpg@1984h_1488w,2017/04/25/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493063309497-1244746321.jpg|2017/04/25/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493063309497-1244746321.jpg@200h_200w|2017/04/25/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493063309497-1244746321.jpg@1984h_1488w","pics":[{"orig_pic":"http://filesystem1.bbtree.com/2017/04/25/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493063303666-1244746321.jpg@1984h_1488w_1e_1c","thumb_pic":"http://filesystem1.bbtree.com/2017/04/25/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493063303666-1244746321.jpg@200h_200w_1e_1c","original_pic":"http://filesystem1.bbtree.com/2017/04/25/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493063303666-1244746321.jpg"},{"orig_pic":"http://filesystem1.bbtree.com/2017/04/25/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493063304320-1244746321.jpg@1984h_1488w_1e_1c","thumb_pic":"http://filesystem1.bbtree.com/2017/04/25/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493063304320-1244746321.jpg@200h_200w_1e_1c","original_pic":"http://filesystem1.bbtree.com/2017/04/25/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493063304320-1244746321.jpg"},{"orig_pic":"http://filesystem1.bbtree.com/2017/04/25/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493063304938-1244746321.jpg@1984h_1488w_1e_1c","thumb_pic":"http://filesystem1.bbtree.com/2017/04/25/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493063304938-1244746321.jpg@200h_200w_1e_1c","original_pic":"http://filesystem1.bbtree.com/2017/04/25/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493063304938-1244746321.jpg"},{"orig_pic":"http://filesystem1.bbtree.com/2017/04/25/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493063305428-1244746321.jpg@1488h_1984w_1e_1c","thumb_pic":"http://filesystem1.bbtree.com/2017/04/25/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493063305428-1244746321.jpg@200h_200w_1e_1c","original_pic":"http://filesystem1.bbtree.com/2017/04/25/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493063305428-1244746321.jpg"},{"orig_pic":"http://filesystem1.bbtree.com/2017/04/25/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493063306277-1244746321.jpg@1984h_1488w_1e_1c","thumb_pic":"http://filesystem1.bbtree.com/2017/04/25/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493063306277-1244746321.jpg@200h_200w_1e_1c","original_pic":"http://filesystem1.bbtree.com/2017/04/25/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493063306277-1244746321.jpg"},{"orig_pic":"http://filesystem1.bbtree.com/2017/04/25/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493063306905-1244746321.jpg@1984h_1488w_1e_1c","thumb_pic":"http://filesystem1.bbtree.com/2017/04/25/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493063306905-1244746321.jpg@200h_200w_1e_1c","original_pic":"http://filesystem1.bbtree.com/2017/04/25/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493063306905-1244746321.jpg"},{"orig_pic":"http://filesystem1.bbtree.com/2017/04/25/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493063307421-1244746321.jpg@1984h_1488w_1e_1c","thumb_pic":"http://filesystem1.bbtree.com/2017/04/25/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493063307421-1244746321.jpg@200h_200w_1e_1c","original_pic":"http://filesystem1.bbtree.com/2017/04/25/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493063307421-1244746321.jpg"},{"orig_pic":"http://filesystem1.bbtree.com/2017/04/25/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493063307880-1244746321.jpg@1984h_1488w_1e_1c","thumb_pic":"http://filesystem1.bbtree.com/2017/04/25/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493063307880-1244746321.jpg@200h_200w_1e_1c","original_pic":"http://filesystem1.bbtree.com/2017/04/25/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493063307880-1244746321.jpg"},{"orig_pic":"http://filesystem1.bbtree.com/2017/04/25/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493063308614-1244746321.jpg@1984h_1488w_1e_1c","thumb_pic":"http://filesystem1.bbtree.com/2017/04/25/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493063308614-1244746321.jpg@200h_200w_1e_1c","original_pic":"http://filesystem1.bbtree.com/2017/04/25/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493063308614-1244746321.jpg"},{"orig_pic":"http://filesystem1.bbtree.com/2017/04/25/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493063309146-1244746321.jpg@1984h_1488w_1e_1c","thumb_pic":"http://filesystem1.bbtree.com/2017/04/25/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493063309146-1244746321.jpg@200h_200w_1e_1c","original_pic":"http://filesystem1.bbtree.com/2017/04/25/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493063309146-1244746321.jpg"},{"orig_pic":"http://filesystem1.bbtree.com/2017/04/25/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493063309497-1244746321.jpg@1984h_1488w_1e_1c","thumb_pic":"http://filesystem1.bbtree.com/2017/04/25/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493063309497-1244746321.jpg@200h_200w_1e_1c","original_pic":"http://filesystem1.bbtree.com/2017/04/25/2bc7a2a03b12d1dce64fb64a7f371a05/And/1493063309497-1244746321.jpg"}],"file_domain":"","comment_count":0,"comment_list":[],"praise_count":1,"praise_user":[{"praise_id":480947787,"mongo_praise_id":"58fea2ede5a4f6e0838b4585","timeline_school_id":202032240,"user_id":206904720,"child_id":0,"class_id":0,"school_id":202032240,"user_name":"熊冬梅园长","nickname":"","name":"熊冬梅","call":"园长","datetime":"2017-04-25 09:14:21","type":3,"from_user":{}}]},{"adType":1,"ads":[{"click_callback":{"0":["https://javaport.bbtree.com/ad/v1/click?os=1&platform=1&posId=37&adId=1095&token=1493365186776&reqTs=1493365186776&userId=212616083&uuid=b80c1f46c3893a47&extra=110000_110100&ip=222.128.110.149&user=&osType=2&connt=WIFI&appv=P_PRE_6.1.0&brand=google&model=google%2Fangler%2Fangler%3A7.0%2FNBD91K%2F3318877%3Auser%2Frelease-keys"]},"countType":1,"exposure":{"0":["http://l.fastapi.net/imp?e=0zenVsnYvTUtiq_32d8Wdwu3z-rTneNbMiFqJlyeq8YST8KUSLZxscAv5L3wbwKnZT1A4AZYoVKEer6becLMqzpTPly92YbVpUj8RzoMCuGhtX9h2MGSnTgb0t8sknG1OiZlDZ2OJutRWAUFMtgFEbnGzg.4.f3ad7fd0&pid=1025962.145-81.1pqi9hx.3vpi3.2.op3zya.02c7&sid=1025962","https://javaport.bbtree.com/ad/v1/pv?os=1&platform=1&posId=37&adId=1095&token=1493365186776&reqTs=1493365186776&userId=212616083&uuid=b80c1f46c3893a47&extra=110000_110100&ip=222.128.110.149&user=&osType=2&connt=WIFI&appv=P_PRE_6.1.0&brand=google&model=google%2Fangler%2Fangler%3A7.0%2FNBD91K%2F3318877%3Auser%2Frelease-keys"]},"id":"1095","is_exposure":1,"keyWord":"1493365186776","link":"http://r.fastapi.net/j?e=1yu6M4eTjWFhzaXQmrIfcQei8-PSnuJRPD1NMCjcop1THZrFX_om15xuyOHUbwKzaE9dpEUchBZJw2FZgngNVeGTlOW4ezhyetd7l4GlLsf_9EYan8DEiUUYlqZdgALkeQU8Ecf2Z7FQHANUZtxYQ7LAz-pyaz3VlYRunPwm0YRzsbvfgRsSIkJMSYQa2uTnQJGWbRArk3s2k8A.4.6e5db5c9&pvid=1025962.145-81.1pqi9hx.3vpi3.2.op3zya.02c7&cpt_cp=__AZCX__%2C__AZCY__&cpt_fmp=__AZMX__%2C__AZMY__&url=http%3A%2F%2Fjumei.com%2F","ownerCode":"adexchange2","picRatio":"4x3","picture":"http://v.pic.fastapi.net/upload/2017/04/ca7b3b368e869005fa33fc260ee020dd.jpg","point":"JZ_AD_Classnative","videoFlag":false}],"avatar":"https://ad5.bbtree.com/ad-test/xuJ8jsVjvcR_1489144532535.png","classfication":"2","deepLink":"","duration":0,"freq":0,"http_method":"GET","is_essence":3,"is_exposure":1,"jumpType":1,"order":4,"ownerCode":"","tag_pic":"","title":"聚美优品 狂欢节","type":3,"videoFlag":false},{"range":"","bucket":"hyww201407","domain":"bbtree.com/","video_name":"video_a1492994393823.mp4","id":480239631,"mongo_timeline_id":"58fd4985e7a4f608ff375735","timeline_school_id":202032240,"date":"2017-04-24 08:40:37","keyword":"","content":"","issecret":0,"is_shield":0,"is_essence":0,"source":"","type":5,"from_user":{"user_id":206904720,"username":"13833332818","name":"熊冬梅","call":"园长","avatar":"","school_app_type":0,"birthday":"","sex":0,"type":3,"class_id":0,"class_name":"","class_pic":"","school_id":202032240,"school_name":"北京迪士尼幼儿园","status":2,"is_vip":true,"is_active":true,"is_invite":true,"invite_code":"","child_id":0,"attendance_type":"1","invit_number":0,"is_graduation":0,"subtype":"13","style":1,"user_wall":"","crown_pic":"","signature":"","nickname":"","stages":0,"provinceid":0,"cityid":0,"areaid":0,"longitude":"","latitude":"","parent_sex":1,"enabled":"1","origin":"0","is_member":0,"is_class_star":0},"file_domain":"","comment_count":1,"comment_list":[{"comment_id":480269329,"mongo_comment_id":"58fd6cf525a5f65e451d6947","timeline_school_id":202032240,"user_id":205689311,"child_id":205012384,"class_id":202155794,"school_id":202032240,"user_name":"张晓红亲属","nickname":"不忘初心","name":"张晓红","call":"亲属","to_user_id":0,"to_user_name":"","comment_content":"[鼓掌][鼓掌][鼓掌]","datetime":"2017-04-24 11:11:49","type":1,"from_user":{},"to_user":{}}],"praise_count":1,"praise_user":[{"praise_id":480944185,"mongo_praise_id":"58fd4998e4a4f6550d1f490b","timeline_school_id":202032240,"user_id":211445956,"child_id":206021908,"class_id":202152040,"school_id":202032240,"user_name":"熊冬梅姑妈","nickname":"","name":"熊冬梅","call":"姑妈","datetime":"2017-04-24 08:40:56","type":1,"from_user":{}}]},{"range":"","bucket":"hyww201407","domain":"bbtree.com/","video_name":"video_a1492993893440.mp4","id":480239627,"mongo_timeline_id":"58fd47c502a5f6df8e302d6a","timeline_school_id":202032240,"date":"2017-04-24 08:33:09","keyword":"","content":"国学礼仪","issecret":0,"is_shield":0,"is_essence":0,"source":"","type":5,"from_user":{"user_id":206904720,"username":"13833332818","name":"熊冬梅","call":"园长","avatar":"","school_app_type":0,"birthday":"","sex":0,"type":3,"class_id":0,"class_name":"","class_pic":"","school_id":202032240,"school_name":"北京迪士尼幼儿园","status":2,"is_vip":true,"is_active":true,"is_invite":true,"invite_code":"","child_id":0,"attendance_type":"1","invit_number":0,"is_graduation":0,"subtype":"13","style":1,"user_wall":"","crown_pic":"","signature":"","nickname":"","stages":0,"provinceid":0,"cityid":0,"areaid":0,"longitude":"","latitude":"","parent_sex":1,"enabled":"1","origin":"0","is_member":0,"is_class_star":0},"file_domain":"","comment_count":0,"comment_list":[],"praise_count":1,"praise_user":[{"praise_id":480944186,"mongo_praise_id":"58fd499a25a5f6b6251d6941","timeline_school_id":202032240,"user_id":211445956,"child_id":206021908,"class_id":202152040,"school_id":202032240,"user_name":"熊冬梅姑妈","nickname":"","name":"熊冬梅","call":"姑妈","datetime":"2017-04-24 08:40:58","type":1,"from_user":{}}]},{"range":"","bucket":"hyww201407","domain":"bbtree.com/","video_name":"","id":480238314,"mongo_timeline_id":"58f8d284e5a4f643948b4576","timeline_school_id":202032240,"date":"2017-04-20 23:23:48","keyword":"","content":"好有爱","issecret":0,"is_shield":0,"is_essence":0,"source":"","type":3,"from_user":{"user_id":206904720,"username":"13833332818","name":"熊冬梅","call":"园长","avatar":"","school_app_type":0,"birthday":"","sex":0,"type":3,"class_id":0,"class_name":"","class_pic":"","school_id":202032240,"school_name":"北京迪士尼幼儿园","status":2,"is_vip":true,"is_active":true,"is_invite":true,"invite_code":"","child_id":0,"attendance_type":"1","invit_number":0,"is_graduation":0,"subtype":"13","style":1,"user_wall":"","crown_pic":"","signature":"","nickname":"","stages":0,"provinceid":0,"cityid":0,"areaid":0,"longitude":"","latitude":"","parent_sex":1,"enabled":"1","origin":"0","is_member":0,"is_class_star":0},"pics_string":"2017/04/20/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492701824732-1244746321.jpg|2017/04/20/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492701824732-1244746321.jpg@200h_200w|2017/04/20/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492701824732-1244746321.jpg@1322h_992w,2017/04/20/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492701825399-1244746321.jpg|2017/04/20/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492701825399-1244746321.jpg@200h_200w|2017/04/20/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492701825399-1244746321.jpg@1322h_992w,2017/04/20/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492701825934-1244746321.jpg|2017/04/20/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492701825934-1244746321.jpg@200h_200w|2017/04/20/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492701825934-1244746321.jpg@1322h_992w","pics":[{"orig_pic":"http://filesystem1.bbtree.com/2017/04/20/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492701824732-1244746321.jpg@1322h_992w_1e_1c","thumb_pic":"http://filesystem1.bbtree.com/2017/04/20/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492701824732-1244746321.jpg@200h_200w_1e_1c","original_pic":"http://filesystem1.bbtree.com/2017/04/20/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492701824732-1244746321.jpg"},{"orig_pic":"http://filesystem1.bbtree.com/2017/04/20/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492701825399-1244746321.jpg@1322h_992w_1e_1c","thumb_pic":"http://filesystem1.bbtree.com/2017/04/20/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492701825399-1244746321.jpg@200h_200w_1e_1c","original_pic":"http://filesystem1.bbtree.com/2017/04/20/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492701825399-1244746321.jpg"},{"orig_pic":"http://filesystem1.bbtree.com/2017/04/20/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492701825934-1244746321.jpg@1322h_992w_1e_1c","thumb_pic":"http://filesystem1.bbtree.com/2017/04/20/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492701825934-1244746321.jpg@200h_200w_1e_1c","original_pic":"http://filesystem1.bbtree.com/2017/04/20/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492701825934-1244746321.jpg"}],"file_domain":"","comment_count":0,"comment_list":[],"praise_count":0,"praise_user":[]},{"range":"","bucket":"hyww201407","domain":"bbtree.com/","video_name":"","id":480237995,"mongo_timeline_id":"58f87e1906a5f6835835dded","timeline_school_id":202032240,"date":"2017-04-20 17:23:37","keyword":"","content":"http://parkadmin.bbtree.com/activity/201704201722/d_0420yeywsbjxts/index.html","issecret":0,"is_shield":0,"is_essence":0,"source":"","type":1,"from_user":{"user_id":210875835,"username":"13833333398","name":"马建霞","call":"园长","avatar":"","school_app_type":0,"birthday":"","sex":0,"type":3,"class_id":0,"class_name":"","class_pic":"","school_id":202032240,"school_name":"北京迪士尼幼儿园","status":2,"is_vip":true,"is_active":true,"is_invite":true,"invite_code":"","child_id":0,"attendance_type":"1","invit_number":0,"is_graduation":0,"subtype":"13","style":1,"user_wall":"","crown_pic":"","signature":"","nickname":"","stages":0,"provinceid":0,"cityid":0,"areaid":0,"longitude":"","latitude":"","parent_sex":1,"enabled":"1","origin":"0","is_member":0,"is_class_star":0},"file_domain":"","comment_count":0,"comment_list":[],"praise_count":0,"praise_user":[]},{"range":"","bucket":"hyww201407","domain":"bbtree.com/","video_name":"","id":480237772,"mongo_timeline_id":"58f8235207a5f69847c7ade4","timeline_school_id":202032240,"date":"2017-04-20 10:56:18","keyword":"","content":"《群芳譜》：\u201c谷雨，谷得雨而生也。\u201d","issecret":0,"is_shield":0,"is_essence":0,"source":"","type":3,"from_user":{"user_id":206904720,"username":"13833332818","name":"熊冬梅","call":"园长","avatar":"","school_app_type":0,"birthday":"","sex":0,"type":3,"class_id":0,"class_name":"","class_pic":"","school_id":202032240,"school_name":"北京迪士尼幼儿园","status":2,"is_vip":true,"is_active":true,"is_invite":true,"invite_code":"","child_id":0,"attendance_type":"1","invit_number":0,"is_graduation":0,"subtype":"13","style":1,"user_wall":"","crown_pic":"","signature":"","nickname":"","stages":0,"provinceid":0,"cityid":0,"areaid":0,"longitude":"","latitude":"","parent_sex":1,"enabled":"1","origin":"0","is_member":0,"is_class_star":0},"pics_string":"2017/04/20/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492656975956-1244746321.jpg|2017/04/20/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492656975956-1244746321.jpg@200h_200w|2017/04/20/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492656975956-1244746321.jpg@946h_640w","pics":[{"orig_pic":"http://filesystem1.bbtree.com/2017/04/20/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492656975956-1244746321.jpg@946h_640w_1e_1c","thumb_pic":"http://filesystem1.bbtree.com/2017/04/20/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492656975956-1244746321.jpg@200h_200w_1e_1c","original_pic":"http://filesystem1.bbtree.com/2017/04/20/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492656975956-1244746321.jpg"}],"file_domain":"","comment_count":0,"comment_list":[],"praise_count":0,"praise_user":[]},{"range":"","bucket":"hyww201407","domain":"bbtree.com/","video_name":"","id":480236764,"mongo_timeline_id":"58f5e0f82aa5f69d59c78f05","timeline_school_id":202032240,"date":"2017-04-18 17:48:40","keyword":"","content":"","issecret":0,"is_shield":0,"is_essence":0,"source":"","type":3,"from_user":{"user_id":210875874,"username":"13833333400","name":"张继红","call":"园长","avatar":"http://filesystem1.bbtree.com/2016/11/08/6b04d70322aa9fee850c69c522136571/And/1478593991855-1244746321.jpg@200h_200w_1e_1c","school_app_type":0,"birthday":"","sex":0,"type":3,"class_id":0,"class_name":"","class_pic":"","school_id":202032240,"school_name":"北京迪士尼幼儿园","status":2,"is_vip":true,"is_active":true,"is_invite":true,"invite_code":"","child_id":0,"attendance_type":"1","invit_number":0,"is_graduation":0,"subtype":"13","style":1,"user_wall":"","crown_pic":"","signature":"","nickname":"","stages":0,"provinceid":0,"cityid":0,"areaid":0,"longitude":"","latitude":"","parent_sex":1,"enabled":"1","origin":"0","is_member":0,"is_class_star":0},"pics_string":"2017/04/18/6b04d70322aa9fee850c69c522136571/And/1492508915069-1244746321.jpg|2017/04/18/6b04d70322aa9fee850c69c522136571/And/1492508915069-1244746321.jpg@200h_200w|2017/04/18/6b04d70322aa9fee850c69c522136571/And/1492508915069-1244746321.jpg@1488h_1984w","pics":[{"orig_pic":"http://filesystem1.bbtree.com/2017/04/18/6b04d70322aa9fee850c69c522136571/And/1492508915069-1244746321.jpg@1488h_1984w_1e_1c","thumb_pic":"http://filesystem1.bbtree.com/2017/04/18/6b04d70322aa9fee850c69c522136571/And/1492508915069-1244746321.jpg@200h_200w_1e_1c","original_pic":"http://filesystem1.bbtree.com/2017/04/18/6b04d70322aa9fee850c69c522136571/And/1492508915069-1244746321.jpg"}],"file_domain":"","comment_count":0,"comment_list":[],"praise_count":0,"praise_user":[]},{"range":"","bucket":"hyww201407","domain":"bbtree.com/","video_name":"","id":0,"mongo_timeline_id":"58f56bd724a5f61233ad72b5","timeline_school_id":202032240,"date":"2017-04-18 09:28:55","keyword":"","content":"04月18日 周二\n【早餐】  花卷，燕麦粥\n【午餐】  宫保鸡丁(100g)、香菇油菜(50g)、蛋花汤(50g)\n【午点】  小笼包(100g)\n【晚餐】  馒头(1个)、儿童榨菜(30g)、甜玉米粥(50g)","issecret":0,"is_shield":0,"is_essence":0,"source":"","type":8,"from_user":{"user_id":213040937,"username":"13833333972","name":"房茂岭","call":"园长","avatar":"","school_app_type":0,"birthday":"","sex":0,"type":3,"class_id":0,"class_name":"","class_pic":"","school_id":202032240,"school_name":"北京迪士尼幼儿园","status":2,"is_vip":true,"is_active":true,"is_invite":true,"invite_code":"","child_id":0,"attendance_type":"1","invit_number":0,"is_graduation":0,"subtype":"13","style":1,"user_wall":"","crown_pic":"","signature":"","nickname":"","stages":0,"provinceid":0,"cityid":0,"areaid":0,"longitude":"","latitude":"","parent_sex":1,"enabled":"1","origin":"0","is_member":0,"is_class_star":0},"pics_string":"2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487661624514-1244746321.jpg|2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487661624514-1244746321.jpg@200h_200w,2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487661444603-1244746321.jpg|2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487661444603-1244746321.jpg@200h_200w,2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487661494289-1244746321.jpg|2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487661494289-1244746321.jpg@200h_200w,2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487662294489-1244746321.jpg|2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487662294489-1244746321.jpg@200h_200w,2017/02/14/dce67f3ac4c64a2aa3fcc1d4f0fc793a/ios/1487043138368985.jpg|2017/02/14/dce67f3ac4c64a2aa3fcc1d4f0fc793a/ios/1487043138368985.jpg@200h_200w,2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487660627444-1244746321.jpg|2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487660627444-1244746321.jpg@200h_200w,2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487660391115-1244746321.jpg|2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487660391115-1244746321.jpg@200h_200w","pics":[{"thumb_pic":"http://filesystem1.bbtree.com/2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487661624514-1244746321.jpg@200h_200w_1e_1c","original_pic":"http://filesystem1.bbtree.com/2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487661624514-1244746321.jpg"},{"thumb_pic":"http://filesystem1.bbtree.com/2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487661444603-1244746321.jpg@200h_200w_1e_1c","original_pic":"http://filesystem1.bbtree.com/2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487661444603-1244746321.jpg"},{"thumb_pic":"http://filesystem1.bbtree.com/2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487661494289-1244746321.jpg@200h_200w_1e_1c","original_pic":"http://filesystem1.bbtree.com/2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487661494289-1244746321.jpg"},{"thumb_pic":"http://filesystem1.bbtree.com/2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487662294489-1244746321.jpg@200h_200w_1e_1c","original_pic":"http://filesystem1.bbtree.com/2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487662294489-1244746321.jpg"},{"thumb_pic":"http://filesystem1.bbtree.com/2017/02/14/dce67f3ac4c64a2aa3fcc1d4f0fc793a/ios/1487043138368985.jpg@200h_200w_1e_1c","original_pic":"http://filesystem1.bbtree.com/2017/02/14/dce67f3ac4c64a2aa3fcc1d4f0fc793a/ios/1487043138368985.jpg"},{"thumb_pic":"http://filesystem1.bbtree.com/2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487660627444-1244746321.jpg@200h_200w_1e_1c","original_pic":"http://filesystem1.bbtree.com/2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487660627444-1244746321.jpg"},{"thumb_pic":"http://filesystem1.bbtree.com/2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487660391115-1244746321.jpg@200h_200w_1e_1c","original_pic":"http://filesystem1.bbtree.com/2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487660391115-1244746321.jpg"}],"file_domain":"","recipe":[{"dishs":[{"name":"花卷，燕麦粥","pics":[],"pics_string":"","quantity":""}],"meal":"早餐"},{"dishs":[{"name":"宫保鸡丁","pics":[{"degrees":0,"islocal":false,"original_pic":"http://filesystem1.bbtree.com/2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487661624514-1244746321.jpg","thumb_pic":"http://filesystem1.bbtree.com/2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487661624514-1244746321.jpg@200h_200w_1e_1c"}],"pics_string":"2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487661624514-1244746321.jpg|2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487661624514-1244746321.jpg@200h_200w","quantity":"100g"},{"name":"香菇油菜","pics":[{"degrees":0,"islocal":false,"original_pic":"http://filesystem1.bbtree.com/2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487661444603-1244746321.jpg","thumb_pic":"http://filesystem1.bbtree.com/2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487661444603-1244746321.jpg@200h_200w_1e_1c"}],"pics_string":"2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487661444603-1244746321.jpg|2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487661444603-1244746321.jpg@200h_200w","quantity":"50g"},{"name":"蛋花汤","pics":[{"degrees":0,"islocal":false,"original_pic":"http://filesystem1.bbtree.com/2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487661494289-1244746321.jpg","thumb_pic":"http://filesystem1.bbtree.com/2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487661494289-1244746321.jpg@200h_200w_1e_1c"}],"pics_string":"2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487661494289-1244746321.jpg|2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487661494289-1244746321.jpg@200h_200w","quantity":"50g"}],"meal":"午餐"},{"dishs":[{"name":"小笼包","pics":[{"degrees":0,"islocal":false,"original_pic":"http://filesystem1.bbtree.com/2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487662294489-1244746321.jpg","thumb_pic":"http://filesystem1.bbtree.com/2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487662294489-1244746321.jpg@200h_200w_1e_1c"}],"pics_string":"2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487662294489-1244746321.jpg|2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487662294489-1244746321.jpg@200h_200w","quantity":"100g"}],"meal":"午点"},{"dishs":[{"name":"馒头","pics":[{"degrees":0,"islocal":false,"original_pic":"http://filesystem1.bbtree.com/2017/02/14/dce67f3ac4c64a2aa3fcc1d4f0fc793a/ios/1487043138368985.jpg","thumb_pic":"http://filesystem1.bbtree.com/2017/02/14/dce67f3ac4c64a2aa3fcc1d4f0fc793a/ios/1487043138368985.jpg@200h_200w_1e_1c"}],"pics_string":"2017/02/14/dce67f3ac4c64a2aa3fcc1d4f0fc793a/ios/1487043138368985.jpg|2017/02/14/dce67f3ac4c64a2aa3fcc1d4f0fc793a/ios/1487043138368985.jpg@200h_200w","quantity":"1个"},{"name":"儿童榨菜","pics":[{"degrees":0,"islocal":false,"original_pic":"http://filesystem1.bbtree.com/2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487660627444-1244746321.jpg","thumb_pic":"http://filesystem1.bbtree.com/2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487660627444-1244746321.jpg@200h_200w_1e_1c"}],"pics_string":"2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487660627444-1244746321.jpg|2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487660627444-1244746321.jpg@200h_200w","quantity":"30g"},{"name":"甜玉米粥","pics":[{"degrees":0,"islocal":false,"original_pic":"http://filesystem1.bbtree.com/2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487660391115-1244746321.jpg","thumb_pic":"http://filesystem1.bbtree.com/2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487660391115-1244746321.jpg@200h_200w_1e_1c"}],"pics_string":"2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487660391115-1244746321.jpg|2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487660391115-1244746321.jpg@200h_200w","quantity":"50g"}],"meal":"晚餐"},{"meal":"夜宵"}],"recipe_time":"2017-04-18","recipe_week":201716,"recipe_view_times":0,"recipes_view_times":0,"sync":1,"comment_count":0,"comment_list":[],"praise_count":3,"praise_user":[{"praise_id":0,"mongo_praise_id":"58f57818e8a4f6a3d12a5725","timeline_school_id":202032240,"user_id":213040921,"child_id":210860697,"class_id":202506413,"school_id":202032240,"user_name":"房茂岭爸爸","nickname":"聪明的长春菊是不是傻","name":"房茂岭","call":"爸爸","datetime":"2017-04-18 10:21:12","type":1,"from_user":{}},{"praise_id":0,"mongo_praise_id":"58f57b1424a5f6cd72ad72ab","timeline_school_id":202032240,"user_id":213040961,"child_id":0,"class_id":202506413,"school_id":202032240,"user_name":"魏春玲老师","nickname":"","name":"魏春玲","call":"老师","datetime":"2017-04-18 10:33:56","type":2,"from_user":{}},{"praise_id":0,"mongo_praise_id":"5902a3e8e6a4f631cf6d6785","timeline_school_id":202032240,"user_id":206564256,"child_id":0,"class_id":202155794,"school_id":202032240,"user_name":"刘宁老师","nickname":"","name":"刘宁","call":"老师","datetime":"2017-04-28 10:07:36","type":2,"from_user":{}}]},{"range":"","bucket":"hyww201407","domain":"bbtree.com/","video_name":"","id":480236415,"mongo_timeline_id":"58f541e008a5f69536b8e8d5","timeline_school_id":202032240,"date":"2017-04-18 06:29:52","keyword":"","content":"幼儿园国学特色课","issecret":0,"is_shield":0,"is_essence":0,"source":"","type":3,"from_user":{"user_id":206904720,"username":"13833332818","name":"熊冬梅","call":"园长","avatar":"","school_app_type":0,"birthday":"","sex":0,"type":3,"class_id":0,"class_name":"","class_pic":"","school_id":202032240,"school_name":"北京迪士尼幼儿园","status":2,"is_vip":true,"is_active":true,"is_invite":true,"invite_code":"","child_id":0,"attendance_type":"1","invit_number":0,"is_graduation":0,"subtype":"13","style":1,"user_wall":"","crown_pic":"","signature":"","nickname":"","stages":0,"provinceid":0,"cityid":0,"areaid":0,"longitude":"","latitude":"","parent_sex":1,"enabled":"1","origin":"0","is_member":0,"is_class_star":0},"pics_string":"2017/04/18/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492468184686-1244746321.jpg|2017/04/18/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492468184686-1244746321.jpg@200h_200w|2017/04/18/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492468184686-1244746321.jpg@1488h_1984w,2017/04/18/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492468185118-1244746321.jpg|2017/04/18/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492468185118-1244746321.jpg@200h_200w|2017/04/18/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492468185118-1244746321.jpg@1488h_1984w,2017/04/18/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492468185516-1244746321.jpg|2017/04/18/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492468185516-1244746321.jpg@200h_200w|2017/04/18/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492468185516-1244746321.jpg@1488h_1984w,2017/04/18/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492468186428-1244746321.jpg|2017/04/18/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492468186428-1244746321.jpg@200h_200w|2017/04/18/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492468186428-1244746321.jpg@1488h_1984w,2017/04/18/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492468187645-1244746321.jpg|2017/04/18/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492468187645-1244746321.jpg@200h_200w|2017/04/18/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492468187645-1244746321.jpg@1488h_1984w,2017/04/18/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492468188355-1244746321.jpg|2017/04/18/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492468188355-1244746321.jpg@200h_200w|2017/04/18/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492468188355-1244746321.jpg@1984h_1488w,2017/04/18/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492468188962-1244746321.jpg|2017/04/18/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492468188962-1244746321.jpg@200h_200w|2017/04/18/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492468188962-1244746321.jpg@1488h_1984w,2017/04/18/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492468189921-1244746321.jpg|2017/04/18/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492468189921-1244746321.jpg@200h_200w|2017/04/18/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492468189921-1244746321.jpg@1488h_1984w","pics":[{"orig_pic":"http://filesystem1.bbtree.com/2017/04/18/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492468184686-1244746321.jpg@1488h_1984w_1e_1c","thumb_pic":"http://filesystem1.bbtree.com/2017/04/18/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492468184686-1244746321.jpg@200h_200w_1e_1c","original_pic":"http://filesystem1.bbtree.com/2017/04/18/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492468184686-1244746321.jpg"},{"orig_pic":"http://filesystem1.bbtree.com/2017/04/18/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492468185118-1244746321.jpg@1488h_1984w_1e_1c","thumb_pic":"http://filesystem1.bbtree.com/2017/04/18/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492468185118-1244746321.jpg@200h_200w_1e_1c","original_pic":"http://filesystem1.bbtree.com/2017/04/18/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492468185118-1244746321.jpg"},{"orig_pic":"http://filesystem1.bbtree.com/2017/04/18/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492468185516-1244746321.jpg@1488h_1984w_1e_1c","thumb_pic":"http://filesystem1.bbtree.com/2017/04/18/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492468185516-1244746321.jpg@200h_200w_1e_1c","original_pic":"http://filesystem1.bbtree.com/2017/04/18/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492468185516-1244746321.jpg"},{"orig_pic":"http://filesystem1.bbtree.com/2017/04/18/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492468186428-1244746321.jpg@1488h_1984w_1e_1c","thumb_pic":"http://filesystem1.bbtree.com/2017/04/18/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492468186428-1244746321.jpg@200h_200w_1e_1c","original_pic":"http://filesystem1.bbtree.com/2017/04/18/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492468186428-1244746321.jpg"},{"orig_pic":"http://filesystem1.bbtree.com/2017/04/18/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492468187645-1244746321.jpg@1488h_1984w_1e_1c","thumb_pic":"http://filesystem1.bbtree.com/2017/04/18/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492468187645-1244746321.jpg@200h_200w_1e_1c","original_pic":"http://filesystem1.bbtree.com/2017/04/18/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492468187645-1244746321.jpg"},{"orig_pic":"http://filesystem1.bbtree.com/2017/04/18/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492468188355-1244746321.jpg@1984h_1488w_1e_1c","thumb_pic":"http://filesystem1.bbtree.com/2017/04/18/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492468188355-1244746321.jpg@200h_200w_1e_1c","original_pic":"http://filesystem1.bbtree.com/2017/04/18/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492468188355-1244746321.jpg"},{"orig_pic":"http://filesystem1.bbtree.com/2017/04/18/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492468188962-1244746321.jpg@1488h_1984w_1e_1c","thumb_pic":"http://filesystem1.bbtree.com/2017/04/18/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492468188962-1244746321.jpg@200h_200w_1e_1c","original_pic":"http://filesystem1.bbtree.com/2017/04/18/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492468188962-1244746321.jpg"},{"orig_pic":"http://filesystem1.bbtree.com/2017/04/18/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492468189921-1244746321.jpg@1488h_1984w_1e_1c","thumb_pic":"http://filesystem1.bbtree.com/2017/04/18/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492468189921-1244746321.jpg@200h_200w_1e_1c","original_pic":"http://filesystem1.bbtree.com/2017/04/18/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492468189921-1244746321.jpg"}],"file_domain":"","comment_count":0,"comment_list":[],"praise_count":0,"praise_user":[]},{"range":"","bucket":"hyww201407","domain":"bbtree.com/","video_name":"","id":480235844,"mongo_timeline_id":"58f4264407a5f60a52c7ad46","timeline_school_id":202032240,"date":"2017-04-17 10:19:48","keyword":"","content":"自己来一发","issecret":0,"is_shield":0,"is_essence":0,"source":"","type":1,"from_user":{"user_id":211240017,"username":"13711112222","realname":"","name":"朱百旭","call":"爸爸","avatar":"","birthday":"2017-01-01","sex":"1","type":1,"class_id":"202449672","class_name":"迪士尼9","class_pic":"/public/setup/icon_circle_portrait1@3x.png","school_id":"202032240","school_name":"北京迪士尼幼儿园","school_app_type":"0","status":2,"is_vip":"0","is_member":"0","member_end_date":"1970-01-01","is_active":true,"is_invite":false,"invite_code":"","child_id":"210823982","attendance_type":"1","subtype":"4","style":"1","user_wall":"","crown_pic":"","invit_number":0,"is_graduation":"0","signature":"","nickname":"","stages":0,"provinceid":0,"cityid":0,"areaid":0,"longitude":"","latitude":"","parent_sex":1,"enabled":"1","origin":"0","user_type":"1","is_class_star":0},"pics_string":"2017/04/17/d7c5e9b3e47fa29249d4bdca1ccbf6ab/And/1492395587521-1244746321.jpg|2017/04/17/d7c5e9b3e47fa29249d4bdca1ccbf6ab/And/1492395587521-1244746321.jpg@200h_200w|2017/04/17/d7c5e9b3e47fa29249d4bdca1ccbf6ab/And/1492395587521-1244746321.jpg@185h_480w","pics":[{"orig_pic":"http://filesystem1.bbtree.com/2017/04/17/d7c5e9b3e47fa29249d4bdca1ccbf6ab/And/1492395587521-1244746321.jpg@185h_480w_1e_1c","thumb_pic":"http://filesystem1.bbtree.com/2017/04/17/d7c5e9b3e47fa29249d4bdca1ccbf6ab/And/1492395587521-1244746321.jpg@200h_200w_1e_1c","original_pic":"http://filesystem1.bbtree.com/2017/04/17/d7c5e9b3e47fa29249d4bdca1ccbf6ab/And/1492395587521-1244746321.jpg"}],"file_domain":"","comment_count":0,"comment_list":[],"praise_count":0,"praise_user":[]},{"range":"","bucket":"hyww201407","domain":"bbtree.com/","video_name":"","id":0,"mongo_timeline_id":"58f02d9a27a5f6147c3f2066","timeline_school_id":202032240,"date":"2017-04-14 10:02:02","keyword":"","content":"04月14日 周五\n【早餐】  馒头，牛奶、红烧排骨(50g)\n【午餐】  小笼包(100g)、炒饭\n【午点】  怀念陪嫁都吐唾沫OK了、奶香包  小米粥、红烧排骨(50g)","issecret":0,"is_shield":0,"is_essence":0,"source":"","type":8,"from_user":{"user_id":212766969,"username":"13833333967","name":"朱百旭","call":"园长","avatar":"","school_app_type":0,"birthday":"","sex":0,"type":3,"class_id":0,"class_name":"","class_pic":"","school_id":202032240,"school_name":"北京迪士尼幼儿园","status":2,"is_vip":true,"is_active":true,"is_invite":true,"invite_code":"","child_id":0,"attendance_type":"1","invit_number":0,"is_graduation":0,"subtype":"13","style":1,"user_wall":"","crown_pic":"","signature":"","nickname":"","stages":0,"provinceid":0,"cityid":0,"areaid":0,"longitude":"","latitude":"","parent_sex":1,"enabled":"1","origin":"0","is_member":0,"is_class_star":0},"pics_string":"2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487662396247-1244746321.jpg|2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487662396247-1244746321.jpg@200h_200w,2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487662294489-1244746321.jpg|2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487662294489-1244746321.jpg@200h_200w","pics":[{"thumb_pic":"http://filesystem1.bbtree.com/2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487662396247-1244746321.jpg@200h_200w_1e_1c","original_pic":"http://filesystem1.bbtree.com/2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487662396247-1244746321.jpg"},{"thumb_pic":"http://filesystem1.bbtree.com/2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487662294489-1244746321.jpg@200h_200w_1e_1c","original_pic":"http://filesystem1.bbtree.com/2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487662294489-1244746321.jpg"}],"file_domain":"","recipe":[{"meal":"早餐","dishs":[{"name":"馒头，牛奶","pics_string":""},{"name":"红烧排骨","quantity":"50g","pics_string":"2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487662396247-1244746321.jpg|2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487662396247-1244746321.jpg@200h_200w"}]},{"meal":"午餐","dishs":[{"name":"小笼包","quantity":"100g","pics_string":"2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487662294489-1244746321.jpg|2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487662294489-1244746321.jpg@200h_200w"},{"name":"炒饭","pics_string":""}]},{"meal":"午点","dishs":[{"name":"怀念陪嫁都吐唾沫OK了","pics_string":""},{"name":"奶香包  小米粥","pics_string":""},{"name":"红烧排骨","quantity":"50g","pics_string":"2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487662396247-1244746321.jpg|2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487662396247-1244746321.jpg@200h_200w"}]},{"meal":"晚餐"},{"meal":"夜宵"}],"recipe_time":"2017-04-14","recipe_week":201715,"recipe_view_times":0,"recipes_view_times":0,"sync":1,"comment_count":0,"comment_list":[],"praise_count":4,"praise_user":[{"praise_id":0,"mongo_praise_id":"58f02e5400a5f65ec3e844c6","timeline_school_id":202032240,"user_id":212766963,"child_id":0,"class_id":202449672,"school_id":202032240,"user_name":"朱百旭老师","nickname":"","name":"朱百旭","call":"老师","datetime":"2017-04-14 10:05:08","type":2,"from_user":{}},{"praise_id":0,"mongo_praise_id":"58f077e121a5f60f4967a729","timeline_school_id":202032240,"user_id":212756609,"child_id":210668951,"class_id":202449672,"school_id":202032240,"user_name":"姚文雯妈妈","nickname":"单身的菠菜","name":"姚文雯","call":"妈妈","datetime":"2017-04-14 15:18:57","type":1,"from_user":{}},{"praise_id":0,"mongo_praise_id":"58f0983821a5f6c96667a72c","timeline_school_id":202032240,"user_id":212706873,"child_id":0,"class_id":0,"school_id":202032240,"user_name":"张老师园长","nickname":"","name":"张老师","call":"园长","datetime":"2017-04-14 17:36:56","type":3,"from_user":{}},{"praise_id":0,"mongo_praise_id":"58f4911e07a5f67203c7ad48","timeline_school_id":202032240,"user_id":213040937,"child_id":0,"class_id":0,"school_id":202032240,"user_name":"房茂岭园长","nickname":"","name":"房茂岭","call":"园长","datetime":"2017-04-17 17:55:42","type":3,"from_user":{}}]},{"range":"","bucket":"hyww201407","domain":"bbtree.com/","video_name":"","id":480233946,"mongo_timeline_id":"58ef28fb08a5f63f6bb8e8bf","timeline_school_id":202032240,"date":"2017-04-13 15:30:03","keyword":"","content":"白洋新工业园区，吸引眼球的建筑！","issecret":0,"is_shield":0,"is_essence":0,"source":"","type":3,"from_user":{"user_id":206904720,"username":"13833332818","name":"熊冬梅","call":"园长","avatar":"","school_app_type":0,"birthday":"","sex":0,"type":3,"class_id":0,"class_name":"","class_pic":"","school_id":202032240,"school_name":"北京迪士尼幼儿园","status":2,"is_vip":true,"is_active":true,"is_invite":true,"invite_code":"","child_id":0,"attendance_type":"1","invit_number":0,"is_graduation":0,"subtype":"13","style":1,"user_wall":"","crown_pic":"","signature":"","nickname":"","stages":0,"provinceid":0,"cityid":0,"areaid":0,"longitude":"","latitude":"","parent_sex":1,"enabled":"1","origin":"0","is_member":0,"is_class_star":0},"pics_string":"2017/04/13/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492068618534-1244746321.jpg|2017/04/13/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492068618534-1244746321.jpg@200h_200w|2017/04/13/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492068618534-1244746321.jpg@992h_1322w,2017/04/13/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492068618966-1244746321.jpg|2017/04/13/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492068618966-1244746321.jpg@200h_200w|2017/04/13/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492068618966-1244746321.jpg@992h_1322w,2017/04/13/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492068619290-1244746321.jpg|2017/04/13/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492068619290-1244746321.jpg@200h_200w|2017/04/13/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492068619290-1244746321.jpg@992h_1322w,2017/04/13/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492068619479-1244746321.jpg|2017/04/13/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492068619479-1244746321.jpg@200h_200w|2017/04/13/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492068619479-1244746321.jpg@992h_1322w","pics":[{"orig_pic":"http://filesystem1.bbtree.com/2017/04/13/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492068618534-1244746321.jpg@992h_1322w_1e_1c","thumb_pic":"http://filesystem1.bbtree.com/2017/04/13/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492068618534-1244746321.jpg@200h_200w_1e_1c","original_pic":"http://filesystem1.bbtree.com/2017/04/13/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492068618534-1244746321.jpg"},{"orig_pic":"http://filesystem1.bbtree.com/2017/04/13/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492068618966-1244746321.jpg@992h_1322w_1e_1c","thumb_pic":"http://filesystem1.bbtree.com/2017/04/13/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492068618966-1244746321.jpg@200h_200w_1e_1c","original_pic":"http://filesystem1.bbtree.com/2017/04/13/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492068618966-1244746321.jpg"},{"orig_pic":"http://filesystem1.bbtree.com/2017/04/13/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492068619290-1244746321.jpg@992h_1322w_1e_1c","thumb_pic":"http://filesystem1.bbtree.com/2017/04/13/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492068619290-1244746321.jpg@200h_200w_1e_1c","original_pic":"http://filesystem1.bbtree.com/2017/04/13/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492068619290-1244746321.jpg"},{"orig_pic":"http://filesystem1.bbtree.com/2017/04/13/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492068619479-1244746321.jpg@992h_1322w_1e_1c","thumb_pic":"http://filesystem1.bbtree.com/2017/04/13/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492068619479-1244746321.jpg@200h_200w_1e_1c","original_pic":"http://filesystem1.bbtree.com/2017/04/13/2bc7a2a03b12d1dce64fb64a7f371a05/And/1492068619479-1244746321.jpg"}],"file_domain":"","comment_count":0,"comment_list":[],"praise_count":0,"praise_user":[]},{"adType":1,"ads":[{"click_callback":{"0":["http://stat.adx.yumimobi.com/api/s?r=37ed234e0c3b3c02&t=1&bid_id=0btcay1D40vg0QgKkk3HTX1i4aoyOi&ad_id=3017&type=3&dsp_id=1073&plmn=46001&ssp_id=460&app_id=1008139&app_bundle_id=com.hyww.wisdomtree&price_enc=wvECWVehppfx4YRD4fbrow&cur=CNY&u=http%3A%2F%2Fclk.api.f2time.com%2Fapp%2Fad%2Fclick%3FappId%3D63Anie%26p%3DeyJhZGVySWQiOiJKSnJhRXoiLCJhZHgiOiI2M0FuaWUiLCJhZHhfcGF5X2Rpc2NvdW50IjoxLCJhZ2VudCI6IlZyUUZyaSIsImFnZW50Q29zdCI6MCwiYWdlbnRUeXBlIjoxLCJhZ2VudF9wYXlfZGlzY291bnQiOjEsImFpZCI6InpoYW5neW91XzEwMDgxMzkiLCJhbmFtZSI6IiIsImFwcElkIjoiNjNBbmllIiwiYmlkX3ByaWNlIjo1MDAsImNpZCI6MzAxNywiY29zdCI6MCwiZGV2aWNlSWQiOiI4Njc5ODEwMjE3NzY5NCIsImR0IjoyLCJpZCI6IjBidGNheTFENDB2ZzBRZ0trazNIVFgxaTRhb3lPaSIsImlwIjoiMjIyLjEyOC4xMTAuMTQ5IiwiaXNMaW1pdCI6ZmFsc2UsImxwZXJpb2QiOjEsIm1hYyI6IiIsIm9zIjoyLCJvc3YiOiI3LjAiLCJwbGFuSWQiOjEzNTMsInBvc2lkIjoiemFwN2RmOTBkZTUzNTI0ODg0YzNmM2MxYTAxOGI5ZjU1NTE3MzQ5YmRlNCIsInNoYXJpbmciOjAsInRzIjoiMjAxNy0wNC0yOCAxNTozOTo0NiIsInVhIjoib2todHRwLzMuNi4wIiwidW5pdElkIjoyNDIwLCJ1cmwiOiJodHRwczovL2VuZ2luZS50dWlhLmNuL2luZGV4L2FjdGl2aXR5P2FwcEtleT1uMTJEeGsxOUdpWUFtR3RtdlBha1N3UzhHWmImYWRzbG90SWQ9OTQ5In0%3D&adid_sha1=&aid_sha1=531a61644c4aa163fc2592eb5f8c0f15eae8dd62&pid=zap7df90de53524884c3f3c1a018b9f55517349bde4","https://javaport.bbtree.com/ad/v1/click?os=1&platform=1&posId=38&adId=1110&token=1493365186894&reqTs=1493365186894&userId=212616083&uuid=b80c1f46c3893a47&extra=110000_110100&ip=222.128.110.149&user=&osType=2&connt=WIFI&appv=P_PRE_6.1.0&brand=google&model=google%2Fangler%2Fangler%3A7.0%2FNBD91K%2F3318877%3Auser%2Frelease-keys"]},"countType":1,"exposure":{"0":["http://stat.adx.yumimobi.com/api/s?r=68df62150ad597ca&t=0&bid_id=0btcay1D40vg0QgKkk3HTX1i4aoyOi&ad_id=3017&type=3&dsp_id=1073&plmn=46001&ssp_id=460&app_id=1008139&app_bundle_id=com.hyww.wisdomtree&price_enc=wvECWVehppfx4YRD4fbrow&cur=CNY&u=http%3A%2F%2Fexp.api.f2time.com%2Fsdk%2Frpt%3FappId%3D63Anie%26prc%3DwvECWVehppfx4YRD4fbrow%26p%3DeyJhZGVySWQiOiJKSnJhRXoiLCJhZHgiOiI2M0FuaWUiLCJhZHhfcGF5X2Rpc2NvdW50IjoxLCJhZ2VudCI6IlZyUUZyaSIsImFnZW50Q29zdCI6MCwiYWdlbnRUeXBlIjoxLCJhZ2VudF9wYXlfZGlzY291bnQiOjEsImFpZCI6InpoYW5neW91XzEwMDgxMzkiLCJhbmFtZSI6IiIsImFwcElkIjoiNjNBbmllIiwiYmlkX3ByaWNlIjo1MDAsImNpZCI6MzAxNywiY29zdCI6NTAxLCJkZXZpY2VJZCI6Ijg2Nzk4MTAyMTc3Njk0IiwiZHQiOjIsImlkIjoiMGJ0Y2F5MUQ0MHZnMFFnS2trM0hUWDFpNGFveU9pIiwiaXAiOiIyMjIuMTI4LjExMC4xNDkiLCJpc0xpbWl0IjpmYWxzZSwibHBlcmlvZCI6MSwibWFjIjoiIiwib3MiOjIsIm9zdiI6IjcuMCIsInBsYW5JZCI6MTM1MywicG9zaWQiOiJ6YXA3ZGY5MGRlNTM1MjQ4ODRjM2YzYzFhMDE4YjlmNTU1MTczNDliZGU0Iiwic2hhcmluZyI6MCwidHMiOiIyMDE3LTA0LTI4IDE1OjM5OjQ2IiwidWEiOiJva2h0dHAvMy42LjAiLCJ1bml0SWQiOjI0MjB9&adid_sha1=&aid_sha1=531a61644c4aa163fc2592eb5f8c0f15eae8dd62&pid=zap7df90de53524884c3f3c1a018b9f55517349bde4","https://javaport.bbtree.com/ad/v1/pv?os=1&platform=1&posId=38&adId=1110&token=1493365186894&reqTs=1493365186894&userId=212616083&uuid=b80c1f46c3893a47&extra=110000_110100&ip=222.128.110.149&user=&osType=2&connt=WIFI&appv=P_PRE_6.1.0&brand=google&model=google%2Fangler%2Fangler%3A7.0%2FNBD91K%2F3318877%3Auser%2Frelease-keys"]},"id":"1110","is_exposure":1,"keyWord":"1493365186894","link":"https://engine.tuia.cn/index/activity?appKey=n12Dxk19GiYAmGtmvPakSwS8GZb&adslotId=949","ownerCode":"zplay","picRatio":"1x1","picture":"http://cdn.f2time.com/image/20170419/0e77bbc57f014101955f8a803cee44b7_tmp.png","point":"JZ_AD_Classnative","videoFlag":false}],"avatar":"https://ad5.bbtree.com/ad-test/tslZgLL6E8w_1489144578503.png","classfication":"2","deepLink":"","duration":0,"freq":0,"http_method":"GET","instructions":"","is_essence":3,"is_exposure":1,"jumpType":1,"order":15,"ownerCode":"","tag_pic":"","title":"点击领取奖励，测好运！","type":3,"videoFlag":false},{"range":"","bucket":"hyww201407","domain":"bbtree.com/","video_name":"","id":480233253,"mongo_timeline_id":"58ede04f03a5f653c6a832ae","timeline_school_id":202032240,"date":"2017-04-12 16:07:43","keyword":"","content":"阿胶喝酒","issecret":0,"is_shield":0,"is_essence":0,"source":"","type":3,"from_user":{"user_id":212766969,"username":"13833333967","name":"朱百旭","call":"园长","avatar":"","school_app_type":0,"birthday":"","sex":0,"type":3,"class_id":0,"class_name":"","class_pic":"","school_id":202032240,"school_name":"北京迪士尼幼儿园","status":2,"is_vip":true,"is_active":true,"is_invite":true,"invite_code":"","child_id":0,"attendance_type":"1","invit_number":0,"is_graduation":0,"subtype":"13","style":1,"user_wall":"","crown_pic":"","signature":"","nickname":"","stages":0,"provinceid":0,"cityid":0,"areaid":0,"longitude":"","latitude":"","parent_sex":1,"enabled":"1","origin":"0","is_member":0,"is_class_star":0},"pics_string":"2017/04/12/c996f7a0b2d63687da604b30807a2181/ios/1491984462862946.jpg|2017/04/12/c996f7a0b2d63687da604b30807a2181/ios/1491984462862946.jpg@200h_200w,","pics":[{"thumb_pic":"http://filesystem1.bbtree.com/2017/04/12/c996f7a0b2d63687da604b30807a2181/ios/1491984462862946.jpg@200h_200w_1e_1c","original_pic":"http://filesystem1.bbtree.com/2017/04/12/c996f7a0b2d63687da604b30807a2181/ios/1491984462862946.jpg"}],"file_domain":"","comment_count":0,"comment_list":[],"praise_count":1,"praise_user":[{"praise_id":480916257,"mongo_praise_id":"58ef111905a5f680b640bab4","timeline_school_id":202032240,"user_id":210872289,"child_id":0,"class_id":202155794,"school_id":202032240,"user_name":"陈毅军老师","nickname":"","name":"陈毅军","call":"老师","datetime":"2017-04-13 13:48:09","type":2,"from_user":{}}]}]
     * total_number : 17
     * total_used_time : 0.20118880271912
     * mongo_used_time : 0.0093429088592529
     * isCache : 0
     */

    private int total_number;
    private double total_used_time;
    private double mongo_used_time;
    private int isCache;
    private List<StatusesBean> statuses;

    public int getTotal_number() {
        return total_number;
    }

    public void setTotal_number(int total_number) {
        this.total_number = total_number;
    }

    public double getTotal_used_time() {
        return total_used_time;
    }

    public void setTotal_used_time(double total_used_time) {
        this.total_used_time = total_used_time;
    }

    public double getMongo_used_time() {
        return mongo_used_time;
    }

    public void setMongo_used_time(double mongo_used_time) {
        this.mongo_used_time = mongo_used_time;
    }

    public int getIsCache() {
        return isCache;
    }

    public void setIsCache(int isCache) {
        this.isCache = isCache;
    }

    public List<StatusesBean> getStatuses() {
        return statuses;
    }

    public void setStatuses(List<StatusesBean> statuses) {
        this.statuses = statuses;
    }

    public static class StatusesBean {
        /**
         * range :
         * bucket : hyww201407
         * domain : bbtree.com/
         * video_name :
         * id : 480242372
         * mongo_timeline_id : 5902a36d05a5f69a092c6ffd
         * timeline_school_id : 202032240
         * date : 2017-04-28 10:05:33
         * keyword :
         * content :
         * issecret : 0
         * is_shield : 0
         * is_essence : 0
         * source :
         * type : 3
         * from_user : {"user_id":212766969,"username":"13833333967","name":"朱百旭","call":"园长","avatar":"","school_app_type":0,"birthday":"","sex":0,"type":3,"class_id":0,"class_name":"","class_pic":"","school_id":202032240,"school_name":"北京迪士尼幼儿园","status":2,"is_vip":true,"is_active":true,"is_invite":true,"invite_code":"","child_id":0,"attendance_type":"1","invit_number":0,"is_graduation":0,"subtype":"13","style":1,"user_wall":"","crown_pic":"","signature":"","nickname":"","stages":0,"provinceid":0,"cityid":0,"areaid":0,"longitude":"","latitude":"","parent_sex":1,"enabled":"1","origin":"0","is_member":0,"is_class_star":0}
         * pics_string : 2017/04/28/3925e1ec3d444c23f8db65282919fddb/And/1493345129274-1244746321.jpg|2017/04/28/3925e1ec3d444c23f8db65282919fddb/And/1493345129274-1244746321.jpg@200h_200w|2017/04/28/3925e1ec3d444c23f8db65282919fddb/And/1493345129274-1244746321.jpg@1920h_1080w
         * pics : [{"orig_pic":"http://filesystem1.bbtree.com/2017/04/28/3925e1ec3d444c23f8db65282919fddb/And/1493345129274-1244746321.jpg@1920h_1080w_1e_1c","thumb_pic":"http://filesystem1.bbtree.com/2017/04/28/3925e1ec3d444c23f8db65282919fddb/And/1493345129274-1244746321.jpg@200h_200w_1e_1c","original_pic":"http://filesystem1.bbtree.com/2017/04/28/3925e1ec3d444c23f8db65282919fddb/And/1493345129274-1244746321.jpg"}]
         * file_domain :
         * comment_count : 0
         * comment_list : []
         * praise_count : 0
         * praise_user : []
         * adType : 1
         * ads : [{"click_callback":{"0":["https://javaport.bbtree.com/ad/v1/click?os=1&platform=1&posId=37&adId=1095&token=1493365186776&reqTs=1493365186776&userId=212616083&uuid=b80c1f46c3893a47&extra=110000_110100&ip=222.128.110.149&user=&osType=2&connt=WIFI&appv=P_PRE_6.1.0&brand=google&model=google%2Fangler%2Fangler%3A7.0%2FNBD91K%2F3318877%3Auser%2Frelease-keys"]},"countType":1,"exposure":{"0":["http://l.fastapi.net/imp?e=0zenVsnYvTUtiq_32d8Wdwu3z-rTneNbMiFqJlyeq8YST8KUSLZxscAv5L3wbwKnZT1A4AZYoVKEer6becLMqzpTPly92YbVpUj8RzoMCuGhtX9h2MGSnTgb0t8sknG1OiZlDZ2OJutRWAUFMtgFEbnGzg.4.f3ad7fd0&pid=1025962.145-81.1pqi9hx.3vpi3.2.op3zya.02c7&sid=1025962","https://javaport.bbtree.com/ad/v1/pv?os=1&platform=1&posId=37&adId=1095&token=1493365186776&reqTs=1493365186776&userId=212616083&uuid=b80c1f46c3893a47&extra=110000_110100&ip=222.128.110.149&user=&osType=2&connt=WIFI&appv=P_PRE_6.1.0&brand=google&model=google%2Fangler%2Fangler%3A7.0%2FNBD91K%2F3318877%3Auser%2Frelease-keys"]},"id":"1095","is_exposure":1,"keyWord":"1493365186776","link":"http://r.fastapi.net/j?e=1yu6M4eTjWFhzaXQmrIfcQei8-PSnuJRPD1NMCjcop1THZrFX_om15xuyOHUbwKzaE9dpEUchBZJw2FZgngNVeGTlOW4ezhyetd7l4GlLsf_9EYan8DEiUUYlqZdgALkeQU8Ecf2Z7FQHANUZtxYQ7LAz-pyaz3VlYRunPwm0YRzsbvfgRsSIkJMSYQa2uTnQJGWbRArk3s2k8A.4.6e5db5c9&pvid=1025962.145-81.1pqi9hx.3vpi3.2.op3zya.02c7&cpt_cp=__AZCX__%2C__AZCY__&cpt_fmp=__AZMX__%2C__AZMY__&url=http%3A%2F%2Fjumei.com%2F","ownerCode":"adexchange2","picRatio":"4x3","picture":"http://v.pic.fastapi.net/upload/2017/04/ca7b3b368e869005fa33fc260ee020dd.jpg","point":"JZ_AD_Classnative","videoFlag":false}]
         * avatar : https://ad5.bbtree.com/ad-test/xuJ8jsVjvcR_1489144532535.png
         * classfication : 2
         * deepLink :
         * duration : 0
         * freq : 0
         * http_method : GET
         * is_exposure : 1
         * jumpType : 1
         * order : 4
         * ownerCode :
         * tag_pic :
         * title : 聚美优品 狂欢节
         * videoFlag : false
         * recipe : [{"dishs":[{"name":"花卷，燕麦粥","pics":[],"pics_string":"","quantity":""}],"meal":"早餐"},{"dishs":[{"name":"宫保鸡丁","pics":[{"degrees":0,"islocal":false,"original_pic":"http://filesystem1.bbtree.com/2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487661624514-1244746321.jpg","thumb_pic":"http://filesystem1.bbtree.com/2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487661624514-1244746321.jpg@200h_200w_1e_1c"}],"pics_string":"2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487661624514-1244746321.jpg|2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487661624514-1244746321.jpg@200h_200w","quantity":"100g"},{"name":"香菇油菜","pics":[{"degrees":0,"islocal":false,"original_pic":"http://filesystem1.bbtree.com/2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487661444603-1244746321.jpg","thumb_pic":"http://filesystem1.bbtree.com/2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487661444603-1244746321.jpg@200h_200w_1e_1c"}],"pics_string":"2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487661444603-1244746321.jpg|2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487661444603-1244746321.jpg@200h_200w","quantity":"50g"},{"name":"蛋花汤","pics":[{"degrees":0,"islocal":false,"original_pic":"http://filesystem1.bbtree.com/2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487661494289-1244746321.jpg","thumb_pic":"http://filesystem1.bbtree.com/2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487661494289-1244746321.jpg@200h_200w_1e_1c"}],"pics_string":"2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487661494289-1244746321.jpg|2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487661494289-1244746321.jpg@200h_200w","quantity":"50g"}],"meal":"午餐"},{"dishs":[{"name":"小笼包","pics":[{"degrees":0,"islocal":false,"original_pic":"http://filesystem1.bbtree.com/2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487662294489-1244746321.jpg","thumb_pic":"http://filesystem1.bbtree.com/2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487662294489-1244746321.jpg@200h_200w_1e_1c"}],"pics_string":"2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487662294489-1244746321.jpg|2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487662294489-1244746321.jpg@200h_200w","quantity":"100g"}],"meal":"午点"},{"dishs":[{"name":"馒头","pics":[{"degrees":0,"islocal":false,"original_pic":"http://filesystem1.bbtree.com/2017/02/14/dce67f3ac4c64a2aa3fcc1d4f0fc793a/ios/1487043138368985.jpg","thumb_pic":"http://filesystem1.bbtree.com/2017/02/14/dce67f3ac4c64a2aa3fcc1d4f0fc793a/ios/1487043138368985.jpg@200h_200w_1e_1c"}],"pics_string":"2017/02/14/dce67f3ac4c64a2aa3fcc1d4f0fc793a/ios/1487043138368985.jpg|2017/02/14/dce67f3ac4c64a2aa3fcc1d4f0fc793a/ios/1487043138368985.jpg@200h_200w","quantity":"1个"},{"name":"儿童榨菜","pics":[{"degrees":0,"islocal":false,"original_pic":"http://filesystem1.bbtree.com/2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487660627444-1244746321.jpg","thumb_pic":"http://filesystem1.bbtree.com/2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487660627444-1244746321.jpg@200h_200w_1e_1c"}],"pics_string":"2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487660627444-1244746321.jpg|2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487660627444-1244746321.jpg@200h_200w","quantity":"30g"},{"name":"甜玉米粥","pics":[{"degrees":0,"islocal":false,"original_pic":"http://filesystem1.bbtree.com/2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487660391115-1244746321.jpg","thumb_pic":"http://filesystem1.bbtree.com/2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487660391115-1244746321.jpg@200h_200w_1e_1c"}],"pics_string":"2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487660391115-1244746321.jpg|2017/02/21/ebc3ff253475337261992f2df2f62ac2/And/1487660391115-1244746321.jpg@200h_200w","quantity":"50g"}],"meal":"晚餐"},{"meal":"夜宵"}]
         * recipe_time : 2017-04-18
         * recipe_week : 201716
         * recipe_view_times : 0
         * recipes_view_times : 0
         * sync : 1
         * instructions :
         */

        private String range;
        private String bucket;
        private String domain;
        private String video_name;
        private int id;
        private String mongo_timeline_id;
        private int timeline_school_id;
        private String date;
        private String keyword;
        private String content;
        private int issecret;
        private int is_shield;
        private int is_essence;
        private String source;
        private int type;
        private FromUserBean from_user;
        private String pics_string;
        private String file_domain;
        private int comment_count;
        private int praise_count;
        private int adType;
        private String avatar;
        private String classfication;
        private String deepLink;
        private int duration;
        private int freq;
        private String http_method;
        private int is_exposure;
        private int jumpType;
        private int order;
        private String ownerCode;
        private String tag_pic;
        private String title;
        private boolean videoFlag;
        private String recipe_time;
        private int recipe_week;
        private int recipe_view_times;
        private int recipes_view_times;
        private int sync;
        private String instructions;
        private List<PicsBean> pics;
        private List<?> comment_list;
        private List<?> praise_user;
        private List<AdsBean> ads;
        private List<RecipeBean> recipe;

        public String getRange() {
            return range;
        }

        public void setRange(String range) {
            this.range = range;
        }

        public String getBucket() {
            return bucket;
        }

        public void setBucket(String bucket) {
            this.bucket = bucket;
        }

        public String getDomain() {
            return domain;
        }

        public void setDomain(String domain) {
            this.domain = domain;
        }

        public String getVideo_name() {
            return video_name;
        }

        public void setVideo_name(String video_name) {
            this.video_name = video_name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getMongo_timeline_id() {
            return mongo_timeline_id;
        }

        public void setMongo_timeline_id(String mongo_timeline_id) {
            this.mongo_timeline_id = mongo_timeline_id;
        }

        public int getTimeline_school_id() {
            return timeline_school_id;
        }

        public void setTimeline_school_id(int timeline_school_id) {
            this.timeline_school_id = timeline_school_id;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getKeyword() {
            return keyword;
        }

        public void setKeyword(String keyword) {
            this.keyword = keyword;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getIssecret() {
            return issecret;
        }

        public void setIssecret(int issecret) {
            this.issecret = issecret;
        }

        public int getIs_shield() {
            return is_shield;
        }

        public void setIs_shield(int is_shield) {
            this.is_shield = is_shield;
        }

        public int getIs_essence() {
            return is_essence;
        }

        public void setIs_essence(int is_essence) {
            this.is_essence = is_essence;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public FromUserBean getFrom_user() {
            return from_user;
        }

        public void setFrom_user(FromUserBean from_user) {
            this.from_user = from_user;
        }

        public String getPics_string() {
            return pics_string;
        }

        public void setPics_string(String pics_string) {
            this.pics_string = pics_string;
        }

        public String getFile_domain() {
            return file_domain;
        }

        public void setFile_domain(String file_domain) {
            this.file_domain = file_domain;
        }

        public int getComment_count() {
            return comment_count;
        }

        public void setComment_count(int comment_count) {
            this.comment_count = comment_count;
        }

        public int getPraise_count() {
            return praise_count;
        }

        public void setPraise_count(int praise_count) {
            this.praise_count = praise_count;
        }

        public int getAdType() {
            return adType;
        }

        public void setAdType(int adType) {
            this.adType = adType;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getClassfication() {
            return classfication;
        }

        public void setClassfication(String classfication) {
            this.classfication = classfication;
        }

        public String getDeepLink() {
            return deepLink;
        }

        public void setDeepLink(String deepLink) {
            this.deepLink = deepLink;
        }

        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }

        public int getFreq() {
            return freq;
        }

        public void setFreq(int freq) {
            this.freq = freq;
        }

        public String getHttp_method() {
            return http_method;
        }

        public void setHttp_method(String http_method) {
            this.http_method = http_method;
        }

        public int getIs_exposure() {
            return is_exposure;
        }

        public void setIs_exposure(int is_exposure) {
            this.is_exposure = is_exposure;
        }

        public int getJumpType() {
            return jumpType;
        }

        public void setJumpType(int jumpType) {
            this.jumpType = jumpType;
        }

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public String getOwnerCode() {
            return ownerCode;
        }

        public void setOwnerCode(String ownerCode) {
            this.ownerCode = ownerCode;
        }

        public String getTag_pic() {
            return tag_pic;
        }

        public void setTag_pic(String tag_pic) {
            this.tag_pic = tag_pic;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public boolean isVideoFlag() {
            return videoFlag;
        }

        public void setVideoFlag(boolean videoFlag) {
            this.videoFlag = videoFlag;
        }

        public String getRecipe_time() {
            return recipe_time;
        }

        public void setRecipe_time(String recipe_time) {
            this.recipe_time = recipe_time;
        }

        public int getRecipe_week() {
            return recipe_week;
        }

        public void setRecipe_week(int recipe_week) {
            this.recipe_week = recipe_week;
        }

        public int getRecipe_view_times() {
            return recipe_view_times;
        }

        public void setRecipe_view_times(int recipe_view_times) {
            this.recipe_view_times = recipe_view_times;
        }

        public int getRecipes_view_times() {
            return recipes_view_times;
        }

        public void setRecipes_view_times(int recipes_view_times) {
            this.recipes_view_times = recipes_view_times;
        }

        public int getSync() {
            return sync;
        }

        public void setSync(int sync) {
            this.sync = sync;
        }

        public String getInstructions() {
            return instructions;
        }

        public void setInstructions(String instructions) {
            this.instructions = instructions;
        }

        public List<PicsBean> getPics() {
            return pics;
        }

        public void setPics(List<PicsBean> pics) {
            this.pics = pics;
        }

        public List<?> getComment_list() {
            return comment_list;
        }

        public void setComment_list(List<?> comment_list) {
            this.comment_list = comment_list;
        }

        public List<?> getPraise_user() {
            return praise_user;
        }

        public void setPraise_user(List<?> praise_user) {
            this.praise_user = praise_user;
        }

        public List<AdsBean> getAds() {
            return ads;
        }

        public void setAds(List<AdsBean> ads) {
            this.ads = ads;
        }

        public List<RecipeBean> getRecipe() {
            return recipe;
        }

        public void setRecipe(List<RecipeBean> recipe) {
            this.recipe = recipe;
        }

        public static class FromUserBean {
            /**
             * user_id : 212766969
             * username : 13833333967
             * name : 朱百旭
             * call : 园长
             * avatar :
             * school_app_type : 0
             * birthday :
             * sex : 0
             * type : 3
             * class_id : 0
             * class_name :
             * class_pic :
             * school_id : 202032240
             * school_name : 北京迪士尼幼儿园
             * status : 2
             * is_vip : true
             * is_active : true
             * is_invite : true
             * invite_code :
             * child_id : 0
             * attendance_type : 1
             * invit_number : 0
             * is_graduation : 0
             * subtype : 13
             * style : 1
             * user_wall :
             * crown_pic :
             * signature :
             * nickname :
             * stages : 0
             * provinceid : 0
             * cityid : 0
             * areaid : 0
             * longitude :
             * latitude :
             * parent_sex : 1
             * enabled : 1
             * origin : 0
             * is_member : 0
             * is_class_star : 0
             */

            private int user_id;
            private String username;
            private String name;
            private String call;
            private String avatar;
            private int school_app_type;
            private String birthday;
            private int sex;
            private int type;
            private int class_id;
            private String class_name;
            private String class_pic;
            private int school_id;
            private String school_name;
            private int status;
            private boolean is_vip;
            private boolean is_active;
            private boolean is_invite;
            private String invite_code;
            private int child_id;
            private String attendance_type;
            private int invit_number;
            private int is_graduation;
            private String subtype;
            private int style;
            private String user_wall;
            private String crown_pic;
            private String signature;
            private String nickname;
            private int stages;
            private int provinceid;
            private int cityid;
            private int areaid;
            private String longitude;
            private String latitude;
            private int parent_sex;
            private String enabled;
            private String origin;
            private int is_member;
            private int is_class_star;

            public int getUser_id() {
                return user_id;
            }

            public void setUser_id(int user_id) {
                this.user_id = user_id;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getCall() {
                return call;
            }

            public void setCall(String call) {
                this.call = call;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public int getSchool_app_type() {
                return school_app_type;
            }

            public void setSchool_app_type(int school_app_type) {
                this.school_app_type = school_app_type;
            }

            public String getBirthday() {
                return birthday;
            }

            public void setBirthday(String birthday) {
                this.birthday = birthday;
            }

            public int getSex() {
                return sex;
            }

            public void setSex(int sex) {
                this.sex = sex;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public int getClass_id() {
                return class_id;
            }

            public void setClass_id(int class_id) {
                this.class_id = class_id;
            }

            public String getClass_name() {
                return class_name;
            }

            public void setClass_name(String class_name) {
                this.class_name = class_name;
            }

            public String getClass_pic() {
                return class_pic;
            }

            public void setClass_pic(String class_pic) {
                this.class_pic = class_pic;
            }

            public int getSchool_id() {
                return school_id;
            }

            public void setSchool_id(int school_id) {
                this.school_id = school_id;
            }

            public String getSchool_name() {
                return school_name;
            }

            public void setSchool_name(String school_name) {
                this.school_name = school_name;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public boolean isIs_vip() {
                return is_vip;
            }

            public void setIs_vip(boolean is_vip) {
                this.is_vip = is_vip;
            }

            public boolean isIs_active() {
                return is_active;
            }

            public void setIs_active(boolean is_active) {
                this.is_active = is_active;
            }

            public boolean isIs_invite() {
                return is_invite;
            }

            public void setIs_invite(boolean is_invite) {
                this.is_invite = is_invite;
            }

            public String getInvite_code() {
                return invite_code;
            }

            public void setInvite_code(String invite_code) {
                this.invite_code = invite_code;
            }

            public int getChild_id() {
                return child_id;
            }

            public void setChild_id(int child_id) {
                this.child_id = child_id;
            }

            public String getAttendance_type() {
                return attendance_type;
            }

            public void setAttendance_type(String attendance_type) {
                this.attendance_type = attendance_type;
            }

            public int getInvit_number() {
                return invit_number;
            }

            public void setInvit_number(int invit_number) {
                this.invit_number = invit_number;
            }

            public int getIs_graduation() {
                return is_graduation;
            }

            public void setIs_graduation(int is_graduation) {
                this.is_graduation = is_graduation;
            }

            public String getSubtype() {
                return subtype;
            }

            public void setSubtype(String subtype) {
                this.subtype = subtype;
            }

            public int getStyle() {
                return style;
            }

            public void setStyle(int style) {
                this.style = style;
            }

            public String getUser_wall() {
                return user_wall;
            }

            public void setUser_wall(String user_wall) {
                this.user_wall = user_wall;
            }

            public String getCrown_pic() {
                return crown_pic;
            }

            public void setCrown_pic(String crown_pic) {
                this.crown_pic = crown_pic;
            }

            public String getSignature() {
                return signature;
            }

            public void setSignature(String signature) {
                this.signature = signature;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public int getStages() {
                return stages;
            }

            public void setStages(int stages) {
                this.stages = stages;
            }

            public int getProvinceid() {
                return provinceid;
            }

            public void setProvinceid(int provinceid) {
                this.provinceid = provinceid;
            }

            public int getCityid() {
                return cityid;
            }

            public void setCityid(int cityid) {
                this.cityid = cityid;
            }

            public int getAreaid() {
                return areaid;
            }

            public void setAreaid(int areaid) {
                this.areaid = areaid;
            }

            public String getLongitude() {
                return longitude;
            }

            public void setLongitude(String longitude) {
                this.longitude = longitude;
            }

            public String getLatitude() {
                return latitude;
            }

            public void setLatitude(String latitude) {
                this.latitude = latitude;
            }

            public int getParent_sex() {
                return parent_sex;
            }

            public void setParent_sex(int parent_sex) {
                this.parent_sex = parent_sex;
            }

            public String getEnabled() {
                return enabled;
            }

            public void setEnabled(String enabled) {
                this.enabled = enabled;
            }

            public String getOrigin() {
                return origin;
            }

            public void setOrigin(String origin) {
                this.origin = origin;
            }

            public int getIs_member() {
                return is_member;
            }

            public void setIs_member(int is_member) {
                this.is_member = is_member;
            }

            public int getIs_class_star() {
                return is_class_star;
            }

            public void setIs_class_star(int is_class_star) {
                this.is_class_star = is_class_star;
            }
        }

        public static class PicsBean {
            /**
             * orig_pic : http://filesystem1.bbtree.com/2017/04/28/3925e1ec3d444c23f8db65282919fddb/And/1493345129274-1244746321.jpg@1920h_1080w_1e_1c
             * thumb_pic : http://filesystem1.bbtree.com/2017/04/28/3925e1ec3d444c23f8db65282919fddb/And/1493345129274-1244746321.jpg@200h_200w_1e_1c
             * original_pic : http://filesystem1.bbtree.com/2017/04/28/3925e1ec3d444c23f8db65282919fddb/And/1493345129274-1244746321.jpg
             */

            private String orig_pic;
            private String thumb_pic;
            private String original_pic;

            public String getOrig_pic() {
                return orig_pic;
            }

            public void setOrig_pic(String orig_pic) {
                this.orig_pic = orig_pic;
            }

            public String getThumb_pic() {
                return thumb_pic;
            }

            public void setThumb_pic(String thumb_pic) {
                this.thumb_pic = thumb_pic;
            }

            public String getOriginal_pic() {
                return original_pic;
            }

            public void setOriginal_pic(String original_pic) {
                this.original_pic = original_pic;
            }
        }

        public static class AdsBean {
            /**
             * click_callback : {"0":["https://javaport.bbtree.com/ad/v1/click?os=1&platform=1&posId=37&adId=1095&token=1493365186776&reqTs=1493365186776&userId=212616083&uuid=b80c1f46c3893a47&extra=110000_110100&ip=222.128.110.149&user=&osType=2&connt=WIFI&appv=P_PRE_6.1.0&brand=google&model=google%2Fangler%2Fangler%3A7.0%2FNBD91K%2F3318877%3Auser%2Frelease-keys"]}
             * countType : 1
             * exposure : {"0":["http://l.fastapi.net/imp?e=0zenVsnYvTUtiq_32d8Wdwu3z-rTneNbMiFqJlyeq8YST8KUSLZxscAv5L3wbwKnZT1A4AZYoVKEer6becLMqzpTPly92YbVpUj8RzoMCuGhtX9h2MGSnTgb0t8sknG1OiZlDZ2OJutRWAUFMtgFEbnGzg.4.f3ad7fd0&pid=1025962.145-81.1pqi9hx.3vpi3.2.op3zya.02c7&sid=1025962","https://javaport.bbtree.com/ad/v1/pv?os=1&platform=1&posId=37&adId=1095&token=1493365186776&reqTs=1493365186776&userId=212616083&uuid=b80c1f46c3893a47&extra=110000_110100&ip=222.128.110.149&user=&osType=2&connt=WIFI&appv=P_PRE_6.1.0&brand=google&model=google%2Fangler%2Fangler%3A7.0%2FNBD91K%2F3318877%3Auser%2Frelease-keys"]}
             * id : 1095
             * is_exposure : 1
             * keyWord : 1493365186776
             * link : http://r.fastapi.net/j?e=1yu6M4eTjWFhzaXQmrIfcQei8-PSnuJRPD1NMCjcop1THZrFX_om15xuyOHUbwKzaE9dpEUchBZJw2FZgngNVeGTlOW4ezhyetd7l4GlLsf_9EYan8DEiUUYlqZdgALkeQU8Ecf2Z7FQHANUZtxYQ7LAz-pyaz3VlYRunPwm0YRzsbvfgRsSIkJMSYQa2uTnQJGWbRArk3s2k8A.4.6e5db5c9&pvid=1025962.145-81.1pqi9hx.3vpi3.2.op3zya.02c7&cpt_cp=__AZCX__%2C__AZCY__&cpt_fmp=__AZMX__%2C__AZMY__&url=http%3A%2F%2Fjumei.com%2F
             * ownerCode : adexchange2
             * picRatio : 4x3
             * picture : http://v.pic.fastapi.net/upload/2017/04/ca7b3b368e869005fa33fc260ee020dd.jpg
             * point : JZ_AD_Classnative
             * videoFlag : false
             */

            private ClickCallbackBean click_callback;
            private int countType;
            private ExposureBean exposure;
            private String id;
            private int is_exposure;
            private String keyWord;
            private String link;
            private String ownerCode;
            private String picRatio;
            private String picture;
            private String point;
            private boolean videoFlag;

            public ClickCallbackBean getClick_callback() {
                return click_callback;
            }

            public void setClick_callback(ClickCallbackBean click_callback) {
                this.click_callback = click_callback;
            }

            public int getCountType() {
                return countType;
            }

            public void setCountType(int countType) {
                this.countType = countType;
            }

            public ExposureBean getExposure() {
                return exposure;
            }

            public void setExposure(ExposureBean exposure) {
                this.exposure = exposure;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public int getIs_exposure() {
                return is_exposure;
            }

            public void setIs_exposure(int is_exposure) {
                this.is_exposure = is_exposure;
            }

            public String getKeyWord() {
                return keyWord;
            }

            public void setKeyWord(String keyWord) {
                this.keyWord = keyWord;
            }

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
            }

            public String getOwnerCode() {
                return ownerCode;
            }

            public void setOwnerCode(String ownerCode) {
                this.ownerCode = ownerCode;
            }

            public String getPicRatio() {
                return picRatio;
            }

            public void setPicRatio(String picRatio) {
                this.picRatio = picRatio;
            }

            public String getPicture() {
                return picture;
            }

            public void setPicture(String picture) {
                this.picture = picture;
            }

            public String getPoint() {
                return point;
            }

            public void setPoint(String point) {
                this.point = point;
            }

            public boolean isVideoFlag() {
                return videoFlag;
            }

            public void setVideoFlag(boolean videoFlag) {
                this.videoFlag = videoFlag;
            }

            public static class ClickCallbackBean {
                @SerializedName("0")
                private List<String> _$0;

                public List<String> get_$0() {
                    return _$0;
                }

                public void set_$0(List<String> _$0) {
                    this._$0 = _$0;
                }
            }

            public static class ExposureBean {
                @SerializedName("0")
                private List<String> _$0;

                public List<String> get_$0() {
                    return _$0;
                }

                public void set_$0(List<String> _$0) {
                    this._$0 = _$0;
                }
            }
        }

        public static class RecipeBean {
            /**
             * dishs : [{"name":"花卷，燕麦粥","pics":[],"pics_string":"","quantity":""}]
             * meal : 早餐
             */

            private String meal;
            private List<DishsBean> dishs;

            public String getMeal() {
                return meal;
            }

            public void setMeal(String meal) {
                this.meal = meal;
            }

            public List<DishsBean> getDishs() {
                return dishs;
            }

            public void setDishs(List<DishsBean> dishs) {
                this.dishs = dishs;
            }

            public static class DishsBean {
                /**
                 * name : 花卷，燕麦粥
                 * pics : []
                 * pics_string :
                 * quantity :
                 */

                private String name;
                private String pics_string;
                private String quantity;
                private List<?> pics;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getPics_string() {
                    return pics_string;
                }

                public void setPics_string(String pics_string) {
                    this.pics_string = pics_string;
                }

                public String getQuantity() {
                    return quantity;
                }

                public void setQuantity(String quantity) {
                    this.quantity = quantity;
                }

                public List<?> getPics() {
                    return pics;
                }

                public void setPics(List<?> pics) {
                    this.pics = pics;
                }
            }
        }
    }
}
