/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.chosakekkainfogaikyo;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.chosakekkainfogaikyo.ChosaKekkaInfoGaikyoRelateEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査結果情報照会_概況調査クラスです。
 *
 * @reamsid_L DBE-3000-260 lizhuoxuan
 */
public class ChosaKekkaInfoGaikyoBusiness {

    private final ChosaKekkaInfoGaikyoRelateEntity choentity;

    /**
     * 認定調査結果情報照会_概況調査項目を返します。
     *
     * @param choentity ChosaKekkaInfoGaikyoRelateEntity
     */
    public ChosaKekkaInfoGaikyoBusiness(ChosaKekkaInfoGaikyoRelateEntity choentity) {
        this.choentity = choentity;
    }

    /**
     * 認定調査実施年月日を返します。
     *
     * @return 認定調査実施年月日
     */
    public FlexibleDate get認定調査実施年月日() {
        return choentity.getNinteichosaJisshiYMD();
    }

    /**
     * 認定調査実施場所名称を返します。
     *
     * @return 認定調査実施場所名称
     */
    public RString get認定調査実施場所名称() {
        return choentity.getChosaJisshiBashoMeisho();
    }

    /**
     * 特記を返します。
     *
     * @return 特記
     */
    public RString get特記() {
        return choentity.getTokki();
    }

    /**
     * 認定調査_サービス区分コードを返します。
     *
     * @return 認定調査_サービス区分コード
     */
    public Code get認定調査_サービス区分コード() {
        return choentity.getServiceKubunCode();
    }

    /**
     * 利用施設名を返します。
     *
     * @return 利用施設名
     */
    public RString get利用施設名() {
        return choentity.getRiyoShisetsuShimei();
    }

    /**
     * 利用施設住所を返します。
     *
     * @return 利用施設住所
     */
    public RString get利用施設住所() {
        return choentity.getRiyoShisetsuJusho();
    }

    /**
     * 利用施設電話番号を返します。
     *
     * @return 利用施設電話番号
     */
    public RString get利用施設電話番号() {
        return choentity.getRiyoShisetsuTelNo();
    }

    /**
     * 厚労省IF識別コードを返します。
     *
     * @return 厚労省IF識別コード
     */
    public Code get厚労省IF識別コード() {
        return choentity.getKoroshoIfShikibetsuCode();
    }

    /**
     * 記入項目連番を返します。
     *
     * @return 記入項目連番
     */
    public int get記入項目連番() {
        return choentity.getRemban();
    }

    /**
     * サービスの状況記入を返します。
     *
     * @return サービスの状況記入
     */
    public RString getサービスの状況記入() {
        return choentity.getServiceJokyoKinyu();
    }

    /**
     * 住宅改修（改修箇所）を返します。
     *
     * @return 住宅改修（改修箇所）
     */
    public RString get住宅改修_改修箇所() {
        return choentity.getJutakuKaishu();
    }

    /**
     * 市町村特別給付サービス種類名を返します。
     *
     * @return 市町村特別給付サービス種類名
     */
    public RString get市町村特別給付サービス種類名() {
        return choentity.getTokubetsuKyufuService();
    }

    /**
     * 介護保険給付以外の在宅サービス種類名を返します。
     *
     * @return 介護保険給付以外の在宅サービス種類名
     */
    public RString get介護保険給付以外の在宅サービス種類名() {
        return choentity.getZaitakuService();
    }

    /**
     * 概況特記事項（主訴）を返します。
     *
     * @return 概況特記事項（主訴）
     */
    public RString get概況特記事項_主訴() {
        return choentity.getShuso();
    }

    /**
     * 概況特記事項（家族状況）を返します。
     *
     * @return 概況特記事項（家族状況）
     */
    public RString get概況特記事項_家族状況() {
        return choentity.getKazokuJokyo();
    }

    /**
     * 概況特記事項（居住環境）を返します。
     *
     * @return 概況特記事項（居住環境）
     */
    public RString get概況特記事項_居住環境() {
        return choentity.getKyojuKankyo();
    }

    /**
     * 概況特記事項（機器・器械）を返します。
     *
     * @return 概況特記事項（機器・器械）
     */
    public RString get概況特記事項_機器_器械() {
        return choentity.getKikaiKiki();
    }

}
