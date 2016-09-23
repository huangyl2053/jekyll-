/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninnteichousairai;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninnteichousairai.WaritsukeEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 割付済み申請者一覧を管理するクラスです。
 *
 * @reamsid_L DBE-0010-010 sunhaidi
 */
public class WaritsukeBusiness {

    private final WaritsukeEntity entity;

    /**
     * 割付済み申請者一覧を返します。
     *
     * @param entity WaritsukeEntity
     */
    public WaritsukeBusiness(WaritsukeEntity entity) {
        this.entity = entity;
    }

    /**
     * 厚労省IF識別コードを返します。
     *
     * @return 厚労省IF識別コード
     */
    public Code getKoroshoIfShikibetsuCode() {
        return entity.getKoroshoIfShikibetsuCode();
    }

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public RString getHihokenshaNo() {
        return entity.getHihokenshaNo();
    }

    /**
     * 被保険者氏名を返します。
     *
     * @return 被保険者氏名
     */
    public AtenaMeisho getHihokenshaName() {
        return entity.getHihokenshaName();
    }

    /**
     * 被保険者性別コードを返します。
     *
     * @return 被保険者性別コード
     */
    public Code getSeibetsu() {
        return entity.getSeibetsu();
    }

    /**
     * 認定申請年月日を返します。
     *
     * @return 認定申請年月日
     */
    public FlexibleDate getNinteiShinseiYMD() {
        return entity.getNinteiShinseiYMD();
    }

    /**
     * 認定申請区分（申請時）コードを返します。
     *
     * @return 認定申請区分（申請時）コード
     */
    public Code getNinteiShinseiKubunCode() {
        return entity.getNinteiShinseiKubunCode();
    }

    /**
     * 被保険者地区コードを返します。
     *
     * @return 被保険者地区コード
     */
    public ChikuCode getChikuCode() {
        return entity.getChikuCode();
    }

    /**
     * 調査区分コードを返します。
     *
     * @return 調査区分コード
     */
    public Code getChosaKubun() {
        return entity.getChosaKubun();
    }

    /**
     * 被保険者住所を返します。
     *
     * @return 被保険者住所
     */
    public AtenaJusho getJusho() {
        return entity.getJusho();
    }

    /**
     * 認定調査委託先割付定員を返します。
     *
     * @return 認定調査委託先割付定員
     */
    public int getWaritsukeTeiin() {
        return entity.getWaritsukeTeiin();
    }

    /**
     * 主治医医療機関を返します。
     *
     * @return 主治医医療機関
     */
    public RString getIryoKikanMeisho() {
        return entity.getIryoKikanMeisho();
    }

    /**
     * 主治医を返します。
     *
     * @return 主治医
     */
    public AtenaMeisho getShujiiName() {
        return entity.getShujiiName();
    }

    /**
     * 調査員割付可能人数/月を返します。
     *
     * @return 調査員割付可能人数/月
     */
    public int getChosaKanoNinzuPerMonth() {
        return entity.getChosaKanoNinzuPerMonth();
    }

    /**
     * 前回認定調査委託先を返します。
     *
     * @return 前回認定調査委託先
     */
    public RString getTemp_jigyoshaMeisho() {
        return entity.getTemp_jigyoshaMeisho();
    }

    /**
     * 前回主治医医療機関を返します。
     *
     * @return 前回主治医医療機関
     */
    public RString getTemp_iryoKikanMeisho() {
        return entity.getTemp_iryoKikanMeisho();
    }

    /**
     * 前回主治医を返します。
     *
     * @return 前回主治医
     */
    public AtenaMeisho getTemp_shujiiName() {
        return entity.getTemp_shujiiName();
    }

    /**
     * 前回調査員氏名を返します。
     *
     * @return 前回調査員氏名
     */
    public RString getTemp_chosainShimei() {
        return entity.getTemp_chosainShimei();
    }

    /**
     * 認定調査依頼年月日を返します。
     *
     * @return 認定調査依頼年月日
     */
    public FlexibleDate getNinteichosaIraiYMD() {
        return entity.getNinteichosaIraiYMD();
    }

    /**
     * 認定調査期限年月日を返します。
     *
     * @return 認定調査期限年月日
     */
    public FlexibleDate getNinteichosaKigenYMD() {
        return entity.getNinteichosaKigenYMD();
    }

    /**
     * 依頼書出力年月日を返します。
     *
     * @return 依頼書出力年月日
     */
    public FlexibleDate getIraishoShutsuryokuYMD() {
        return entity.getIraishoShutsuryokuYMD();
    }

    /**
     * 調査票等出力年月日を返します。
     *
     * @return 調査票等出力年月日
     */
    public FlexibleDate getChosahyoTouShutsuryokuYMD() {
        return entity.getChosahyoTouShutsuryokuYMD();
    }

    /**
     * 被保険者氏名カナを返します。
     *
     * @return 被保険者氏名カナ
     */
    public AtenaKanaMeisho getHihokenshaKana() {
        return entity.getHihokenshaKana();
    }

    /**
     * 生年月日を返します。
     *
     * @return 生年月日
     */
    public FlexibleDate getSeinengappiYMD() {
        return entity.getSeinengappiYMD();
    }

    /**
     * 住所郵便番号を返します。
     *
     * @return 住所郵便番号
     */
    public YubinNo getYubinNo() {
        return entity.getYubinNo();
    }

    /**
     * 電話番号を返します。
     *
     * @return 電話番号
     */
    public TelNo getTelNo() {
        return entity.getTelNo();
    }

    /**
     * 訪問調査先郵便番号を返します。
     *
     * @return 訪問調査先郵便番号
     */
    public YubinNo getHomonChosasakiYubinNo() {
        return entity.getHomonChosasakiYubinNo();
    }

    /**
     * 訪問調査先住所を返します。
     *
     * @return 訪問調査先住所
     */
    public AtenaJusho getHomonChosasakiJusho() {
        return entity.getHomonChosasakiJusho();
    }

    /**
     * 訪問調査先名称を返します。
     *
     * @return 訪問調査先名称
     */
    public AtenaMeisho getHomonChosasakiName() {
        return entity.getHomonChosasakiName();
    }

    /**
     * 訪問調査先電話番号を返します。
     *
     * @return 訪問調査先電話番号
     */
    public TelNo getHomonChosasakiTelNo() {
        return entity.getHomonChosasakiTelNo();
    }

    /**
     * 要介護認定（更新）申請日を返します。
     *
     * @return 要介護認定（更新）申請日
     */
    public FlexibleDate getNinteiShinseiYMDKoShin() {
        return entity.getNinteiShinseiYMDKoShin();
    }

    /**
     * 前回認定年月日を返します。
     *
     * @return 前回認定年月日
     */
    public FlexibleDate getZenkaiNinteiYMD() {
        return entity.getZenkaiNinteiYMD();
    }

    /**
     * 前回要介護状態区分コードを返します。
     *
     * @return 前回要介護状態区分コード
     */
    public Code getZenYokaigoKubunCode() {
        return entity.getZenYokaigoKubunCode();
    }

    /**
     * 年齢を返します。
     *
     * @return 年齢
     */
    public int getAge() {
        return entity.getAge();
    }

    /**
     * 認定調査完了年月日を返します。
     *
     * @return 認定調査完了年月日
     */
    public FlexibleDate getNinteichosaKanryoYMD() {
        return entity.getNinteichosaKanryoYMD();
    }

    /**
     * 申請書管理番号を返します。
     *
     * @return 申請書管理番号
     */
    public RString getShinseishoKanriNo() {
        return entity.getShinseishoKanriNo();
    }

    /**
     * 認定調査依頼履歴番号を返します。
     *
     * @return 認定調査依頼履歴番号
     */
    public int getNinteichosaIraiRirekiNo() {
        return entity.getNinteichosaIraiRirekiNo();
    }

    /**
     * 調査員コードを返します。
     *
     * @return 調査員コード
     */
    public RString getNinteiChosainCode() {
        return entity.getNinteiChosainCode();
    }

    /**
     * 保険者番号を返します。
     *
     * @return 保険者番号
     */
    public RString getHokenshaNo() {
        return entity.getHokenshaNo();
    }

    /**
     * 認定調査委託先コードを返します。
     *
     * @return 認定調査委託先コード
     */
    public RString getNinteiChosaItakusakiCode() {
        return entity.getNinteiChosaItakusakiCode();
    }

    /**
     * 市町村コードを返します。
     *
     * @return 市町村コード
     */
    public RString getShichosonCode() {
        return entity.getShichosonCode();
    }

    /**
     * 連絡先続柄を返します。
     *
     * @return 連絡先続柄
     */
    public RString getRenrakusakiTuzukigara() {
        return entity.getRenrakusakiTuzukigara();
    }

    /**
     * 連絡先郵便番号を返します。
     *
     * @return 連絡先郵便番号
     */
    public YubinNo getRenrakusakiYubinNo() {
        return entity.getRenrakusakiYubinNo();
    }

    /**
     * 連絡先電話番号を返します。
     *
     * @return 連絡先電話番号
     */
    public TelNo getRenrakusakiTelNo() {
        return entity.getRenrakusakiTelNo();
    }

    /**
     * 連絡先携帯番号を返します。
     *
     * @return 連絡先携帯番号
     */
    public TelNo getRenrakusakiKeitaiTelNo() {
        return entity.getRenrakusakiKeitaiTelNo();
    }

    /**
     * 連絡先氏名を返します。
     *
     * @return 連絡先氏名
     */
    public AtenaMeisho getRenrakusakiShimei() {
        return entity.getRenrakusakiShimei();
    }

    /**
     * 連絡先住所を返します。
     *
     * @return 連絡先住所
     */
    public AtenaJusho getRenrakusakiJusho() {
        return entity.getRenrakusakiJusho();
    }
}
