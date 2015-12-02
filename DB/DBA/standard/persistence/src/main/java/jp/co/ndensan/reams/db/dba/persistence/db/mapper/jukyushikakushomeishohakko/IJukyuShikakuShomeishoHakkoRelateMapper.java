/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.db.mapper.jukyushikakushomeishohakko;

import jp.co.ndensan.reams.db.dba.definition.mybatis.param.jukyushikakushomeishohakko.JukyuShikakuShomeishoHakkoParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.JukyuShikakuShomeishoHakkoRelateEntity;

/**
 * 車両検索用のマッパーインタフェースです。
 *
 */
public interface IJukyuShikakuShomeishoHakkoRelateMapper {

    /**
     * 被保険者番号をキーに受給者台帳テーブル、要介護認定結果情報テーブルと宛名識別対象PSMからデータを取得します。
     *
     * @param 受給資格証明書発行情報をキー
     * @return JukyuShikakuShomeishoHakkoRelateEntity
     */
     JukyuShikakuShomeishoHakkoRelateEntity getJukyuShikakuShomeishoHakko(JukyuShikakuShomeishoHakkoParameter 受給資格証明書発行情報をキー);

    /**
     * サービス種類情報検索結果を返します。
     *
     * @param 受給資格証明書発行情報をキー
     * @return 検索結果リスト
     */
     JukyuShikakuShomeishoHakkoRelateEntity getServiceCodeList(JukyuShikakuShomeishoHakkoParameter 受給資格証明書発行情報をキー);

    /**
     * フォーカスアウトのサービス種類検索結果を返します。
     *
     * @param 受給資格証明書発行情報をキー
     * @return JukyuShikakuShomeishoHakkoRelateEntity
     */
     JukyuShikakuShomeishoHakkoRelateEntity getServiceMeiList(JukyuShikakuShomeishoHakkoParameter 受給資格証明書発行情報をキー);
    
    /**
     * 認定申請中データを取得します。
     *
     * @param 受給資格証明書発行情報をキー
     * @return JukyuShikakuShomeishoHakkoRelateEntity
     */
     JukyuShikakuShomeishoHakkoRelateEntity getNinTeiShinSeiChuData(JukyuShikakuShomeishoHakkoParameter 受給資格証明書発行情報をキー);
    
    /**
     * 認定調査情報を取得します。
     *
     * @param 受給資格証明書発行情報をキー
     * @return JukyuShikakuShomeishoHakkoRelateEntity
     */
     JukyuShikakuShomeishoHakkoRelateEntity getNinTeiChouSaJou(JukyuShikakuShomeishoHakkoParameter 受給資格証明書発行情報をキー);

}
