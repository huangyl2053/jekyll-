/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakushikyufushikyuketteitsuchihakko;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.servicehishikyuketteitsuchisho.KogakuShikyuFushikyuKetteiTsuchiHakkoEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.kogakushikyufushikyuketteitsuchihakkoichiran.KogakuShikyuFushikyuKetteiTsuchiHakkoSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 高額介護サービス費支給（不支給）決定通知一覧表BodyEditorクラスです。
 *
 * @reamsid_L DBC-2000-080 wangxingpeng
 */
public class KogakuShikyuFushikyuKetteiTsuchiHakkoBodyEditor implements IKogakuShikyuFushikyuKetteiTsuchiHakkoEditor {

    private final KogakuShikyuFushikyuKetteiTsuchiHakkoEntity entity;

    /**
     * コンストラクタです
     *
     * @param entity KogakuShikyuFushikyuKetteiTsuchiHakkoEntity
     */
    public KogakuShikyuFushikyuKetteiTsuchiHakkoBodyEditor(KogakuShikyuFushikyuKetteiTsuchiHakkoEntity entity) {
        this.entity = entity;
    }

    @Override
    public KogakuShikyuFushikyuKetteiTsuchiHakkoSource edit(KogakuShikyuFushikyuKetteiTsuchiHakkoSource source) {
        if (entity != null) {
            source.listUpper_1 = entity.get連番();
            source.listUpper_2 = entity.get決定通知No();
            source.listUpper_3 = entity.get被保険者番号();
            source.listUpper_4 = entity.get被保険者氏名();
            source.listUpper_5 = entity.get郵便番号();
            source.listLower_1 = entity.get住所();
            source.listUpper_6 = entity.get提供年月();
            source.listLower_2 = entity.get要介護度();
            source.listLower_3 = entity.get認定終了日();
            source.listUpper_8 = entity.get受付年月日();
            source.listLower_4 = entity.get決定年月日();
            source.listUpper_9 = entity.get本人支払額()
                    == null ? RString.EMPTY : DecimalFormatter.toコンマ区切りRString(entity.get本人支払額(), 0);
            source.listLower_5 = entity.get支給額()
                    == null ? RString.EMPTY : DecimalFormatter.toコンマ区切りRString(entity.get支給額(), 0);
            source.listUpper_10 = entity.get支給_不支給_決定区分();
            source.listUpper_11 = entity.get資格喪失日();
            source.listUpper_12 = entity.get自動償還();
            source.listLower_7 = entity.get喪失事由();
            source.listUpper_7 = entity.get認定開始日();

            source.yubinNo = entity.get郵便番号();
            source.choikiCode = entity.get町域コード();
            source.gyoseikuCode = entity.get行政区コード();
            source.kanaMeisho = entity.get氏名５０音カナ();
            source.shichosonCode = entity.get市町村コード();
            source.shoKisaiHokenshaNo = entity.get証記載保険者番号();
            source.hihokenshaNo = entity.get被保険者番号();
            source.tsuchishoNo = entity.get決定通知No();
            source.shikakuJyotaiKubun = entity.get資格状態区分();
            setPageBreakEmpty(source);
        }
        return source;
    }

    private void setPageBreakEmpty(KogakuShikyuFushikyuKetteiTsuchiHakkoSource source) {
        if (source.yubinNo == null) {
            source.yubinNo = RString.EMPTY;
        }
        if (source.choikiCode == null) {
            source.choikiCode = RString.EMPTY;
        }
        if (source.gyoseikuCode == null) {
            source.gyoseikuCode = RString.EMPTY;
        }
        if (source.kanaMeisho == null) {
            source.kanaMeisho = RString.EMPTY;
        }
        if (source.shichosonCode == null) {
            source.shichosonCode = RString.EMPTY;
        }
        if (source.shoKisaiHokenshaNo == null) {
            source.shoKisaiHokenshaNo = RString.EMPTY;
        }
        if (source.hihokenshaNo == null) {
            source.hihokenshaNo = RString.EMPTY;
        }
        if (source.tsuchishoNo == null) {
            source.tsuchishoNo = RString.EMPTY;
        }
        if (source.shikakuJyotaiKubun == null) {
            source.shikakuJyotaiKubun = RString.EMPTY;
        }
    }
}
