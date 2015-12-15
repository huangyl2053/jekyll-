/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.db.mapper.jukyushikakushomeishohakko;

import jp.co.ndensan.reams.db.dba.definition.mybatis.param.jukyushikakushomeishohakko.JukyuShikakuShomeishoHakkoParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.JukyuShikakuShomeishoHakkoRelateEntity;

/**
 * 受給資格証明書発行情報を取得のマッパーインタフェースです。
 *
 */
public interface IJukyuShikakuShomeishoHakkoRelateMapper {

    /**
     * 被保険者番号をキーに受給者台帳テーブル、要介護認定結果情報テーブルと宛名識別対象PSMからデータを取得します。
     *
     * @param 受給資格証明書発行情報の検索キー 受給資格証明書発行情報の検索キー
     * @return JukyuShikakuShomeishoHakkoRelateEntity
     */
    JukyuShikakuShomeishoHakkoRelateEntity getJukyuShikakuShomeishoHakko(JukyuShikakuShomeishoHakkoParameter 受給資格証明書発行情報の検索キー);

    /**
     * サービス種類情報検索結果を返します。
     *
     * @param 受給資格証明書発行情報の検索キー 受給資格証明書発行情報の検索キー
     * @return JukyuShikakuShomeishoHakkoRelateEntity
     */
    JukyuShikakuShomeishoHakkoRelateEntity getServiceCode(JukyuShikakuShomeishoHakkoParameter 受給資格証明書発行情報の検索キー);

    /**
     * フォーカスアウトのサービス種類検索結果を返します。
     *
     * @param 受給資格証明書発行情報の検索キー 受給資格証明書発行情報の検索キー
     * @return JukyuShikakuShomeishoHakkoRelateEntity
     */
    JukyuShikakuShomeishoHakkoRelateEntity getServiceMei(JukyuShikakuShomeishoHakkoParameter 受給資格証明書発行情報の検索キー);

    /**
     * 認定申請中データを取得します。
     *
     * @param 受給資格証明書発行情報の検索キー 受給資格証明書発行情報の検索キー
     * @return JukyuShikakuShomeishoHakkoRelateEntity
     */
    JukyuShikakuShomeishoHakkoRelateEntity getNinTeiShinSeiChuData(JukyuShikakuShomeishoHakkoParameter 受給資格証明書発行情報の検索キー);

    /**
     * 認定調査情報を取得します。
     *
     * @param 受給資格証明書発行情報の検索キー 受給資格証明書発行情報の検索キー
     * @return JukyuShikakuShomeishoHakkoRelateEntity
     */
    JukyuShikakuShomeishoHakkoRelateEntity getNinTeiChouSaJou(JukyuShikakuShomeishoHakkoParameter 受給資格証明書発行情報の検索キー);

}
