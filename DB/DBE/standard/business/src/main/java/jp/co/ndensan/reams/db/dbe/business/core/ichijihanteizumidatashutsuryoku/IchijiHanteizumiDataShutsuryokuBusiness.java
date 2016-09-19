/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ichijihanteizumidatashutsuryoku;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteizumidatashutsuryoku.IchijiHanteizumiDataShutsuryokuRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 一次判定データ出力Businessです。
 *
 * @reamsid_L DBE-1610-010 wanghui
 */
public class IchijiHanteizumiDataShutsuryokuBusiness {

    private final IchijiHanteizumiDataShutsuryokuRelateEntity entity;

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link IchijiHanteizumiDataShutsuryokuRelateEntity}より{@link NinteiChosainMaster}を生成します。
     *
     * @param entity DBより取得した{@link IchijiHanteizumiDataShutsuryokuRelateEntity}
     */
    public IchijiHanteizumiDataShutsuryokuBusiness(IchijiHanteizumiDataShutsuryokuRelateEntity entity) {
        this.entity = entity;
    }

    /**
     * 申請書管理番号を返します。
     *
     * @return 申請書管理番号
     */
    public RString get申請書管理番号() {
        return entity.getShinseishoKanriNo();
    }

    /**
     * 厚労省IF識別コードを返します。
     *
     * @return 厚労省IF識別コード
     */
    public RString get厚労省IF識別コード() {
        return entity.getKoroshoIfShikibetsuCode();
    }

    /**
     * 証記載保険者番号を返します。
     *
     * @return 証記載保険者番号
     */
    public RString get証記載保険者番号() {
        return entity.getShoKisaiHokenshaNo();
    }

    /**
     * 市町村名称を返します。
     *
     * @return 市町村名称
     */
    public RString get市町村名称() {
        return entity.getShichosonMeisho();
    }

    /**
     * 認定申請年月日を返します。
     *
     * @return 認定申請年月日
     */
    public RString get認定申請年月日() {
        return entity.getNinteiShinseiYMD();
    }

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public RString get被保険者番号() {
        return entity.getHihokenshaNo();
    }

    /**
     * 被保険者氏名を返します。
     *
     * @return 被保険者氏名
     */
    public RString get被保険者氏名() {
        return entity.getHihokenshaName();
    }

    /**
     * 認定申請区分申請時コードを返します。
     *
     * @return 認定申請区分申請時コード
     */
    public RString get認定申請区分申請時コード() {
        return entity.getNinteiShinseiShinseijiKubunCode();
    }

    /**
     * 認定申請区分法令コードを返します。
     *
     * @return 認定申請区分法令コード
     */
    public RString get認定申請区分法令コード() {
        return entity.getNinteiShinseiHoreiKubunCode();
    }

    /**
     * 要介護認定一次判定年月日を返します。
     *
     * @return 要介護認定一次判定年月日
     */
    public RString get要介護認定一次判定年月日() {
        return entity.getIchijiHanteiYMD();
    }

    /**
     * 要介護認定一次判定結果コードを返します。
     *
     * @return 要介護認定一次判定結果コード
     */
    public RString get要介護認定一次判定結果コード() {
        return entity.getIchijiHanteiKekkaCode();
    }

    /**
     * 一次判定情報抽出年月日を返します。
     *
     * @return 一次判定情報抽出年月日
     */
    public RString get一次判定情報抽出年月日() {
        return entity.getIchijihanteiChushutsuYMD();
    }

    /**
     * 要介護認定一次判定警告コードを返します。
     *
     * @return 要介護認定一次判定警告コード
     */
    public RString get要介護認定一次判定警告コード() {
        return entity.getIchijiHnateiKeikokuCode();
    }
}
