/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.shokanketteitsuchishoshiharai;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanketteitsuchishoshiharai.ShokanKetteiTsuchiShoShiharaiRelateEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 償還払支給（不支給）決定通知書の情報インターフェースです。
 */
public class ShokanKetteiTsuchiShoShiharai {

    private final ShokanKetteiTsuchiShoShiharaiRelateEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity 償還払支給（不支給）決定通知書情報Entityクラス
     */
    public ShokanKetteiTsuchiShoShiharai(ShokanKetteiTsuchiShoShiharaiRelateEntity entity) {
        this.entity = entity;
    }

    /**
     * 整理番号を取得します。
     *
     * @return 整理番号
     */
    public RString get整理番号() {
        return entity.getSeiriNo();
    }

    /**
     * 決定通知Noを取得します。
     *
     * @return 決定通知No
     */
    public RString get決定通知No() {
        return entity.getKetteiTsuchiNo();
    }

    /**
     * 被保険者番号を取得します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return entity.getHiHokenshaNo();
    }

    /**
     * 被保険者氏名を取得します。
     *
     * @return 被保険者氏名
     */
    public RString get被保険者氏名() {
        return entity.getHiHokenshaShimei();
    }

    /**
     * 住所を取得します。
     *
     * @return 住所
     */
    public RString get住所() {
        return entity.getJusho();
    }

    /**
     * 郵便番号を取得します。
     *
     * @return 郵便番号
     */
    public RString get郵便番号() {
        return entity.getYubinNo();
    }

    /**
     * 番地を取得します。
     *
     * @return 番地
     */
    public RString get番地() {
        return entity.getBanchi();
    }

    /**
     * 提供年月を取得します。
     *
     * @return 提供年月
     */
    public FlexibleYearMonth get提供年月() {
        return entity.getTeikyoYM();
    }

    /**
     * 要介護認定状態区分コードを取得します。
     *
     * @return 要介護認定状態区分コード
     */
    public Code get要介護認定状態区分コード() {
        return entity.getYokaigoJotaiKubunCode();
    }

    /**
     * 認定開始日を取得します。
     *
     * @return 認定開始日
     */
    public FlexibleDate get認定開始日() {
        return entity.getNinteiYukoKikanKaishiYMD();
    }

    /**
     * 認定終了日を取得します。
     *
     * @return 認定終了日
     */
    public FlexibleDate get認定終了日() {
        return entity.getNinteiYukoKikanShuryoYMD();
    }

    /**
     * 受付年月日を取得します。
     *
     * @return 受付年月日
     */
    public FlexibleDate get受付年月日() {
        return entity.getUketsukeYMD();
    }

    /**
     * 決定年月日を取得します。
     *
     * @return 決定年月日
     */
    public FlexibleDate get決定年月日() {
        return entity.getKetteiYMD();
    }

    /**
     * 本人支払額を取得します。
     *
     * @return 本人支払額
     */
    public Decimal get本人支払額() {
        return entity.getShiharaiKingakuUchiwakeRiyoshabun();
    }

    /**
     * 支給額を取得します。
     *
     * @return 支給額
     */
    public Decimal get支給額() {
        return entity.getShiharaiKingaku();
    }

    /**
     * 様式名称を取得します。
     *
     * @return 様式名称
     */
    public RString get様式名称() {
        return entity.getRyakusho();
    }

    /**
     * 金額を取得します。
     *
     * @return 金額
     */
    public Decimal get金額() {
        return entity.getKingaku();
    }

    /**
     * 追加を取得します。
     *
     * @return 追加
     */
    public RString get追加() {
        return entity.getTuika();
    }

    /**
     * 種類を取得します。
     *
     * @return 種類
     */
    public RString get種類() {
        return entity.getServiceNameRyaku();
    }

    /**
     * 支給不支給決定区分を取得します。
     *
     * @return 支給不支給決定区分
     */
    public RString get支給不支給決定区分() {
        return entity.getShikyuHushikyuKetteiKubun();
    }

    /**
     * 増減理由等を取得します。
     *
     * @return 増減理由等
     */
    public RString get増減理由等() {
        return entity.getZougenRiyu();
    }

    /**
     * 金融機関コードを取得します。
     *
     * @return 金融機関コード
     */
    public KinyuKikanCode get金融機関コード() {
        return entity.getKinyuKikanCode();
    }

    /**
     * 金融機関名称を取得します。
     *
     * @return 金融機関名称
     */
    public RString get金融機関名称() {
        return entity.getKinyuKikanName();
    }

    /**
     * 支店名称を取得します。
     *
     * @return 支店名称
     */
    public RString get支店名称() {
        return entity.getShideMeisho();
    }

    /**
     * 預金種別名称を取得します。
     *
     * @return 預金種別名称
     */
    public RString get預金種別名称() {
        return entity.getYokinShubetsuMeisho();
    }

    /**
     * 口座番号を取得します。
     *
     * @return 口座番号
     */
    public RString get口座番号() {
        return entity.getKozaBango();
    }

    /**
     * 口座名義人漢字を取得します。
     *
     * @return 口座名義人漢字
     */
    public RString get口座名義人漢字() {
        return entity.getKozaMeigininKanji();
    }

    /**
     * 支払方法区分コードを取得します。
     *
     * @return 支払方法区分コード
     */
    public RString get支払方法区分コード() {
        return entity.getShiharaiHohoKubunCode();
    }

    /**
     * 支払期間開始年月日を取得します。
     *
     * @return 支払期間開始年月日
     */
    public FlexibleDate get支払期間開始年月日() {
        return entity.getShiharaiKaishiYMD();
    }

    /**
     * 支払期間終了年月日を取得します。
     *
     * @return 支払期間終了年月日
     */
    public FlexibleDate get支払期間終了年月日() {
        return entity.getShiharaiShuryoYMD();
    }

    /**
     * 支払窓口開始時間を取得します。
     *
     * @return 支払窓口開始時間
     */
    public RString get支払窓口開始時間() {
        return entity.getShiharaiKaishiTime();
    }

    /**
     * 支払窓口終了期間を取得します。
     *
     * @return 支払窓口終了期間
     */
    public RString get支払窓口終了期間() {
        return entity.getShiharaiShuryoTime();
    }

    /**
     * 証記載保険者番号を取得します。
     *
     * @return 証記載保険者番号
     */
    public RString get証記載保険者番号() {
        return entity.getShoKisaiHokenshaNo();
    }
}
