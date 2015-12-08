/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.config;

/**
 * このクラスでは、業務Config 動作関連 に対応するキーをまとめています。
 */
public enum DousaKanren implements IConfigKey {

    /**
     * 0：実施していない　1：実施している
     */
    動作関連_コンビニ収納実施区分,
    /**
     * 0：実施していない　1：実施している
     */
    動作関連_公示送達実施区分,
    /**
     * 0：稼動していない　1：稼動している
     */
    動作関連_収納システム区分,
    /**
     * 0：稼動していない　1：稼動している
     */
    動作関連_口座システム区分,
    /**
     * 0：保留無し　1：保留有り
     */
    動作関連_所得調査中賦課保留有無,
    /**
     * 0：なし　1：あり（国保／後期）　2：あり（後期）
     */
    動作関連_特徴分配集約システム,
    /**
     * 1：全件対象　2：賦課基準日で判定
     */
    動作関連_過年度賦課対象;

}
