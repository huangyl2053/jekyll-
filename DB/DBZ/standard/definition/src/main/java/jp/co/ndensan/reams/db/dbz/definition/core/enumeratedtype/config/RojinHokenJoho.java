/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.config;

/**
 * このクラスでは、業務Config 老人保健情報 に対応するキーをまとめています。
 */
public enum RojinHokenJoho implements IConfigKey {

    /**
     * 老人保健市町村番号
     */
    老人保健情報_市町村番号,
    /**
     * 老人保健受給者番号の管理体系区分　１：住民コード体系　住民コード間６桁＋ＭＣＤ１０で算出　ただし、ＤＢＲＯ登録者
     */
    老人保健情報_管理体系;
}
