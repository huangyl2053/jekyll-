/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.dbd210010;

import java.text.DecimalFormat;
import jp.co.ndensan.reams.db.dbd.definition.core.shiharaihohohenko.ShiharaiHenkoBenmeiRiyuCode;
import jp.co.ndensan.reams.db.dbd.definition.core.shiharaihohohenko.ShiharaiHenkoBenmeiShinsaKekkaKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.shiharaihohohenko.ShiharaiHenkoShuryoShinseiRiyuCode;
import jp.co.ndensan.reams.db.dbd.definition.core.shiharaihohohenko.ShiharaiHenkoShuryoShinseiShinsaKekkaKubun;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd210010.KyufuSeikentaishoshaCsvEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd210010.KyufuSeikentaishoshaEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd210010.ShiharaiHohoHenkoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd210010.ShiharaiHouhouKanriHitotokiTempEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd210010.TainouJokyoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd210010.TainouJokyoTempEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.definition.core.shiharaihohohenko.ShiharaiHenkoKanriKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.shiharaihohohenko.ShiharaiHenkoShuryoKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.shiharaihohohenko.ShiharaiHenkoTorokuKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 給付制限対象者一覧CSVのDataManagerクラスです。
 *
 * @reamsid_L DBD-4300-030 liuwei2
 */
public class ShiharaiHouhouKanriHitotokiDataManager {

    private static final RString NUM1 = new RString(1);
    private static final RString NINE = new RString("99999999");

    /**
     * コンストラクタです。
     */
    public ShiharaiHouhouKanriHitotokiDataManager() {
    }

    /**
     * 支払方法管理一時テーブルを設定します。
     *
     * @param entity ShiharaiHohoHenkoEntity
     * @return ShiharaiHouhouKanriHitotokiTempEntity
     */
    public ShiharaiHouhouKanriHitotokiTempEntity set支払方法管理一時テーブル(ShiharaiHohoHenkoEntity entity) {
        ShiharaiHouhouKanriHitotokiTempEntity tempTable = new ShiharaiHouhouKanriHitotokiTempEntity();
        if (entity.get被保険者番号() == null) {
            entity.set被保険者番号(HihokenshaNo.EMPTY);
        }
        if (entity.get識別コード() == null) {
            entity.set識別コード(ShikibetsuCode.EMPTY);
        }
        if (entity.get市町村コード() == null) {
            entity.set市町村コード(LasdecCode.EMPTY);
        }
        if (entity.get名称() == null) {
            entity.set名称(AtenaMeisho.EMPTY);
        }
        set支払方法管理一時EmptyテーブルONE(entity);
        tempTable.setHihokenshaNo(entity.get被保険者番号());
        tempTable.setShikibetsuCode(entity.get識別コード());
        tempTable.setShichosonCode(entity.get市町村コード());
        tempTable.setMeisho(entity.get名称());
        tempTable.setKanaMeisho(entity.getカナ名称());
        tempTable.setSeinengappiYMD(entity.get生年月日());
        tempTable.setSeibetsuCode(entity.get性別コード());
        tempTable.setYubinNo(entity.get郵便番号());
        tempTable.setZenkokuJushoCode(entity.get全国住所コード());
        tempTable.setGyoseikuCode(entity.get行政区コード());
        tempTable.setSetaiCode(entity.get世帯コード());
        tempTable.setJusho(entity.get住所().value().concat(entity.get番地()).concat(entity.get方書()));
        tempTable.setShikakuShutokuYMD(entity.get資格取得年月日());
        tempTable.setShikakuSoshitsuYMD(entity.get資格喪失年月日());
        tempTable.setNinteiShinseihi(entity.get認定年月日());
        tempTable.setYokaigoJotaiKubunCode(entity.get要介護認定状態区分コード());
        tempTable.setNinteiYukoKikanKaishiYMD(entity.get認定有効期間開始年月日());
        tempTable.setNinteiYukoKikanShuryoYMD(entity.get認定有効期間終了年月日());
        tempTable.setNinteiihi(entity.get認定年月日());
        tempTable.setKanriKubun(entity.get管理区分());
        tempTable.setRirekiNo(entity.get履歴番号());
        tempTable.setTorokuKubun(entity.get登録区分());
        tempTable.setTekiyoKaishiYMD(entity.get適用開始年月日());
        tempTable.setTekiyoShuryoYMD(entity.get適用終了年月日());
        tempTable.setShuryoKubun(entity.get終了区分());
        tempTable.setYokoku_TorokuYMD(entity.get予告登録年月日());
        tempTable.setSashitome_IraiJuriYMD(entity.get差止依頼書受理年月日());
        tempTable.setYokoku_TsuchiHakkoYMD(entity.get予告通知書発行年月日());
        tempTable.setBemmei_TeishutsuYMD(entity.get弁明書提出期限());
        tempTable.setBemmei_UketsukeYMD(entity.get弁明書受付年月日());
        tempTable.setBemmei_RiyuCode(entity.get弁明理由コード());
        tempTable.setBemmei_ShinsaKetteiYMD(entity.get弁明審査決定年月日());
        tempTable.setBemmei_ShinsaKekkaKubun(entity.get弁明審査結果区分());
        tempTable.setShokan_KetteiYMD(entity.get償還払化決定年月日());
        tempTable.setShokan_TsuchiHakkoYMD(entity.get償還払化通知書発行年月日());
        tempTable.setHihokenshaShoTeishutsuYMD(entity.get被保険者証提出期限());
        tempTable.setHihokenshaShoTeishutsuYMD(entity.get被保険者証提出期限());
        tempTable.setSashitomeFlag(entity.getFlag1());
        tempTable.setSashitome_KetteiYMD(entity.get差止決定年月日());
        tempTable.setSashitome_KaijoYMD(entity.get差止解除年月日());
        tempTable.setKojo_KetteiYMD(entity.get控除決定年月日());
        tempTable.setGemmen_KetteiYMD(entity.get減額決定年月日());
        tempTable.setGemmen_TsuchiHakkoYMD(entity.get減額通知書発行年月日());
        tempTable.setKyufuRitsu(entity.get給付率());
        tempTable.setShuryoShinsei_UketsukeYMD(entity.get終了申請書受付年月日());
        tempTable.setShuryoShinsei_YMD(entity.get終了申請年月日());
        tempTable.setShuryoShinsei_RiyuCode(entity.get終了申請理由コード());
        tempTable.setShuryoShinsei_ShinsaKetteiYMD(entity.get終了申請審査決定年月日());
        tempTable.setShuryoShinsei_ShinsaKekkaKubun(entity.get終了申請審査結果区分());
        tempTable.setChoshukenShometsuKikan(entity.get徴収権消滅期間());
        tempTable.setNofusumiKikan(entity.get納付済期間());
        tempTable.setNofusumiGengakuKikan(entity.get納付済減額期間());
        tempTable.setKakutei_GengakuKaishiYMD(entity.get確定減額期間開始年月日());
        tempTable.setKakutei_GengakuShuryoYMD(entity.get確定減額期間終了年月日());
        tempTable.setKoikinaiJushochiTokureiFlag(entity.get広域内住所地特例フラグ());
        tempTable.setFlag(entity.getFlag());
        tempTable.setChoikiCode(entity.get町域コード());
        tempTable.setKoikinaiTokureiSochimotoShichosonCode(entity.get広住特措置元市町村コード());
        tempTable.setShoKisaiHokenshaNo(entity.get証記載保険者番号());
        return tempTable;
    }

    /**
     * 滞納状況一時テーブルを設定します。
     *
     * @param entity TainouJokyoEntity
     * @return TainouJokyoTempEntity
     */
    public TainouJokyoTempEntity set滞納状況一時テーブル(TainouJokyoEntity entity) {
        TainouJokyoTempEntity tempTable = new TainouJokyoTempEntity();
        tempTable.setHihokenshaNo(entity.get被保険者番号());
        tempTable.setKanriKubun(entity.get管理区分());
        tempTable.setRirekiNo(entity.get履歴番号());
        tempTable.setTainoHanteiKubun(entity.get滞納判定区分());
        tempTable.setTsuchishoNo(new TsuchishoNo(entity.get通知書番号()));
        tempTable.setShukeiainougaku(entity.get集計滞納額());

        return tempTable;
    }

    /**
     * 給付制限対象者CSVを設定します。
     *
     * @param entity KyufuSeikentaishoshaEntity
     * @return KyufuSeikentaishoshaCsvEntity
     */
    public KyufuSeikentaishoshaCsvEntity set給付制限対象者CSV(KyufuSeikentaishoshaEntity entity) {
        KyufuSeikentaishoshaCsvEntity tempTable = new KyufuSeikentaishoshaCsvEntity();
        tempTable.set被保険者番号(entity.get被保険者番号().value());
        tempTable.set識別コード(entity.get識別コード().value());
        if (NUM1.equals(entity.get広域内住所地特例フラグ())) {
            tempTable.set市町村コード(entity.get広住特措置元市町村コード().value());
        } else {
            tempTable.set市町村コード(entity.get市町村コード().value());
        }
        tempTable.set氏名(entity.get氏名().value());
        tempTable.setカナ氏名(entity.getカナ氏名().value());
        tempTable.set生年月日(entity.get生年月日().seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString());
        tempTable.set性別コード(entity.get性別コード());
        if (NUM1.equals(entity.get性別コード())) {
            tempTable.set性別(new RString("男"));
        } else {
            tempTable.set性別(new RString("女"));
        }
        tempTable.set郵便番号(entity.get郵便番号());
        tempTable.set住所コード(entity.get住所コード().value());
        tempTable.set行政区コード(entity.get行政区コード().value());
        tempTable.set世帯コード(entity.get世帯コード());
        tempTable.set住所(entity.get住所());
        tempTable.set資格取得日(entity.get資格取得日().seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString());
        if (NINE.toString().equals(entity.get資格喪失日().toString())) {
            tempTable.set資格喪失日(RString.EMPTY);
        } else {
            tempTable.set資格喪失日(entity.get資格取得日().seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString());
        }
        tempTable.set認定申請日(entity.get認定申請日().seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString());
        tempTable.set要介護状態区分(entity.get要介護状態区分().value());
        if (entity.get要介護状態区分() == null || entity.get要介護状態区分().isEmpty()) {
            tempTable.set要介護状態名称(RString.EMPTY);
        } else {
            tempTable.set要介護状態名称(YokaigoJotaiKubun.toValue(entity.get要介護状態区分().value()).get名称());
        }

        tempTable.set認定有効開始年月日(entity.get認定有効開始年月日().seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString());
        tempTable.set認定有効終了年月日(entity.get認定有効終了年月日().seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString());
        tempTable.set認定日(entity.get認定日().seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString());
        tempTable.set管理区分(entity.get管理区分());
        if (entity.get管理区分() == null || entity.get管理区分().isEmpty()) {
            tempTable.set管理区分名称(RString.EMPTY);
        } else {
            tempTable.set管理区分名称(ShiharaiHenkoKanriKubun.toValue(new RString(Integer.valueOf(entity.get管理区分().toString()))).get名称());
        }
        tempTable.set登録区分(entity.get登録区分());

        if (entity.get登録区分() == null || entity.get登録区分().isEmpty()) {
            tempTable.set登録区分名称(RString.EMPTY);
        } else {
            tempTable.set登録区分名称(ShiharaiHenkoTorokuKubun.toValue(entity.get登録区分()).get名称());
        }
        tempTable.set適用開始日(entity.get適用開始日().seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString());
        tempTable.set適用終了日(entity.get適用終了日().seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString());
        tempTable.set終了区分(entity.get終了区分());
        if (entity.get終了区分() == null || entity.get終了区分().isEmpty()) {
            tempTable.set終了区分名称(RString.EMPTY);
        } else {
            tempTable.set終了区分名称(ShiharaiHenkoShuryoKubun.toValue(entity.get終了区分()).get名称());
        }
        tempTable.set予告登録日(entity.get予告登録日().seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString());
        tempTable.set差止依頼書受理日(entity.get差止依頼書受理日().seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString());
        tempTable.set予告通知書出力日(RString.EMPTY);
        tempTable.set予告通知書発行日(entity.get予告通知書発行日().seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString());
        tempTable.set弁明書提出期限(new RString(entity.get弁明書提出期限().toString()));
        tempTable.set弁明書受付日(entity.get弁明書受付日().seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString());
        tempTable.set弁明理由(entity.get弁明理由());
        if (entity.get弁明理由() == null || entity.get弁明理由().isEmpty()) {
            tempTable.set弁明理由名称(RString.EMPTY);
        } else {
            tempTable.set弁明理由名称(ShiharaiHenkoBenmeiRiyuCode.toValue(new RString(entity.get弁明理由().toString())).get名称());
        }

        tempTable.set弁明内容決定日(entity.get弁明内容決定日().seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString());
        tempTable.set弁明審査結果(entity.get弁明審査結果());

        if (entity.get弁明審査結果() == null || entity.get弁明審査結果().isEmpty()) {
            tempTable.set弁明審査結果名称(RString.EMPTY);
        } else {
            tempTable.set弁明審査結果名称(ShiharaiHenkoBenmeiShinsaKekkaKubun.toValue(entity.get弁明審査結果()).getコード());
        }
        tempTable.set償還払化決定日(entity.get償還払化決定日().seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString());
        tempTable.set償還払化通知書出力日(RString.EMPTY);
        tempTable.set償還払化通知書発行日(entity.get償還払化通知書発行日().seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString());

        tempTable.set被保険者証提出期限(new RString(entity.get被保険者証提出期限().toString()));
        tempTable.set差止対象フラグ(entity.get差止対象フラグ());
        tempTable.set差止決定日(entity.get差止決定日().seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString());
        tempTable.set差止解除日(entity.get差止解除日().seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString());
        tempTable.set控除決定日(entity.get控除決定日().seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString());
        tempTable.set減額決定日(entity.get減額決定日().seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString());
        tempTable.set減額通知書出力日(RString.EMPTY);
        tempTable.set減額通知書発行日(entity.get減額通知書発行日().seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString());

        tempTable.set給付率(new RString(entity.get給付率().value().toString()));
        tempTable.set終了申請書受付日(entity.get終了申請書受付日().seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString());
        tempTable.set終了申請年月日(entity.get終了申請年月日().seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString());
        tempTable.set終了申請理由(entity.get終了申請理由());
        if (entity.get終了申請理由() == null || entity.get終了申請理由().isEmpty()) {
            tempTable.set終了申請理由名称(RString.EMPTY);
        } else {
            tempTable.set終了申請理由名称(ShiharaiHenkoShuryoShinseiRiyuCode.toValue(entity.get終了申請理由()).get名称());
        }
        tempTable.set終了申請内容決定日(entity.get終了申請内容決定日().seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString());
        tempTable.set終了申請審査結果(entity.get終了申請審査結果());
        if (entity.get終了申請審査結果() == null) {
            tempTable.set終了申請審査結果名称(RString.EMPTY);
        } else {
            tempTable.set終了申請審査結果名称(ShiharaiHenkoShuryoShinseiShinsaKekkaKubun.toValue(entity.get終了申請審査結果()).get名称());
        }
        set給付制限対象者CSVOne(tempTable, entity);
        return tempTable;
    }

    private KyufuSeikentaishoshaCsvEntity set給付制限対象者CSVOne(KyufuSeikentaishoshaCsvEntity tempTable, KyufuSeikentaishoshaEntity entity) {
        DecimalFormat df = new DecimalFormat("##.000");
        tempTable.set徴収権消滅期間(new RString(df.format(entity.get徴収権消滅期間()).toString()));
        tempTable.set納付済期間(new RString(df.format(entity.get納付済期間()).toString()));
        tempTable.set納付済減額期間(new RString(entity.get納付済減額期間().intValue()));

        tempTable.set確定給付額減額期間開始日(new RString(entity.get確定給付額減額期間開始日().toString()));
        tempTable.set確定給付額減額期間終了日(new RString(entity.get確定給付額減額期間終了日().toString()));
        if (entity.get通知時滞納額合計() == null) {
            tempTable.set通知時滞納額合計(RString.EMPTY);
        } else {
            tempTable.set通知時滞納額合計(new RString(entity.get通知時滞納額合計().toString()));
        }

        if (entity.get現在滞納額合計() == null) {
            tempTable.set現在滞納額合計(RString.EMPTY);
        } else {
            tempTable.set現在滞納額合計(new RString(entity.get現在滞納額合計().toString()));
        }
        return tempTable;
    }

    private ShiharaiHohoHenkoEntity set支払方法管理一時EmptyテーブルONE(ShiharaiHohoHenkoEntity entity) {

        if (entity.getカナ名称() == null) {
            entity.setカナ名称(AtenaKanaMeisho.EMPTY);
        }
        if (entity.get生年月日() == null) {
            entity.set生年月日(FlexibleDate.EMPTY);
        }
        if (entity.get性別コード() == null) {
            entity.set性別コード(RString.EMPTY);
        }
        if (entity.get郵便番号() == null) {
            entity.set郵便番号(RString.EMPTY);
        }
        if (entity.get全国住所コード() == null) {
            entity.set全国住所コード(ZenkokuJushoCode.EMPTY);
        }
        if (entity.get行政区コード() == null) {
            entity.set行政区コード(GyoseikuCode.EMPTY);
        }
        if (entity.get世帯コード() == null) {
            entity.set世帯コード(RString.EMPTY);
        }
        if (entity.get番地() == null) {
            entity.set番地(RString.EMPTY);
        }
        if (entity.get住所() == null) {
            entity.set住所(AtenaJusho.EMPTY);
        }
        if (entity.get方書() == null) {
            entity.set方書(RString.EMPTY);
        }
        if (entity.get資格取得年月日() == null) {
            entity.set資格取得年月日(FlexibleDate.EMPTY);
        }
        if (entity.get資格喪失年月日() == null) {
            entity.set資格喪失年月日(FlexibleDate.EMPTY);
        }
        if (entity.get認定年月日() == null) {
            entity.set認定年月日(FlexibleDate.EMPTY);
        }
        if (entity.get要介護認定状態区分コード() == null) {
            entity.set要介護認定状態区分コード(Code.EMPTY);
        }
        if (entity.get認定有効期間開始年月日() == null) {
            entity.set認定有効期間開始年月日(FlexibleDate.EMPTY);
        }
        if (entity.get認定有効期間終了年月日() == null) {
            entity.set認定有効期間終了年月日(FlexibleDate.EMPTY);
        }
        if (entity.get認定年月日() == null) {
            entity.set認定年月日(FlexibleDate.EMPTY);
        }
        if (entity.get管理区分() == null) {
            entity.set管理区分(RString.EMPTY);
        }
        set支払方法管理一時EmptyテーブルTwo(entity);
        return entity;
    }

    private ShiharaiHohoHenkoEntity set支払方法管理一時EmptyテーブルTwo(ShiharaiHohoHenkoEntity entity) {
        if (entity.get登録区分() == null) {
            entity.set登録区分(RString.EMPTY);
        }
        if (entity.get適用開始年月日() == null) {
            entity.set適用開始年月日(FlexibleDate.EMPTY);
        }
        if (entity.get適用終了年月日() == null) {
            entity.set適用終了年月日(FlexibleDate.EMPTY);
        }
        if (entity.get終了区分() == null) {
            entity.set終了区分(RString.EMPTY);
        }
        if (entity.get予告登録年月日() == null) {
            entity.set予告登録年月日(FlexibleDate.EMPTY);
        }
        if (entity.get差止依頼書受理年月日() == null) {
            entity.set差止依頼書受理年月日(FlexibleDate.EMPTY);
        }
        if (entity.get予告通知書発行年月日() == null) {
            entity.set予告通知書発行年月日(FlexibleDate.EMPTY);
        }
        if (entity.get弁明書提出期限() == null) {
            entity.set弁明書提出期限(FlexibleDate.EMPTY);
        }
        if (entity.get弁明書受付年月日() == null) {
            entity.set弁明書受付年月日(FlexibleDate.EMPTY);
        }
        if (entity.get弁明理由コード() == null) {
            entity.set弁明理由コード(RString.EMPTY);
        }
        if (entity.get弁明審査決定年月日() == null) {
            entity.set弁明審査決定年月日(FlexibleDate.EMPTY);
        }
        if (entity.get弁明審査結果区分() == null) {
            entity.set弁明審査結果区分(RString.EMPTY);
        }
        if (entity.get償還払化決定年月日() == null) {
            entity.set償還払化決定年月日(FlexibleDate.EMPTY);
        }
        if (entity.get償還払化通知書発行年月日() == null) {
            entity.set償還払化通知書発行年月日(FlexibleDate.EMPTY);
        }
        if (entity.get被保険者証提出期限() == null) {
            entity.set被保険者証提出期限(FlexibleDate.EMPTY);
        }
        if (entity.get差止決定年月日() == null) {
            entity.set差止決定年月日(FlexibleDate.EMPTY);
        }
        if (entity.get差止解除年月日() == null) {
            entity.set差止解除年月日(FlexibleDate.EMPTY);
        }
        set支払方法管理一時EmptyテーブルThree(entity);
        return entity;
    }

    private ShiharaiHohoHenkoEntity set支払方法管理一時EmptyテーブルThree(ShiharaiHohoHenkoEntity entity) {

        if (entity.get控除決定年月日() == null) {
            entity.set控除決定年月日(FlexibleDate.EMPTY);
        }
        if (entity.get減額決定年月日() == null) {
            entity.set減額決定年月日(FlexibleDate.EMPTY);
        }
        if (entity.get減額通知書発行年月日() == null) {
            entity.set減額通知書発行年月日(FlexibleDate.EMPTY);
        }
        if (entity.get給付率() == null) {
            entity.set給付率(HokenKyufuRitsu.ZERO);
        }
        if (entity.get終了申請書受付年月日() == null) {
            entity.set終了申請書受付年月日(FlexibleDate.EMPTY);
        }
        if (entity.get終了申請年月日() == null) {
            entity.set終了申請年月日(FlexibleDate.EMPTY);
        }
        if (entity.get終了申請理由コード() == null) {
            entity.set終了申請理由コード(RString.EMPTY);
        }
        if (entity.get終了申請審査決定年月日() == null) {
            entity.set終了申請審査決定年月日(FlexibleDate.EMPTY);
        }
        if (entity.get終了申請審査結果区分() == null) {
            entity.set終了申請審査結果区分(RString.EMPTY);
        }
        if (entity.get徴収権消滅期間() == null) {
            entity.set徴収権消滅期間(Decimal.ZERO);
        }
        if (entity.get納付済期間() == null) {
            entity.set納付済期間(Decimal.ZERO);
        }
        if (entity.get納付済減額期間() == null) {
            entity.set納付済減額期間(Decimal.ZERO);
        }
        if (entity.get確定減額期間開始年月日() == null) {
            entity.set確定減額期間開始年月日(FlexibleDate.EMPTY);
        }
        if (entity.get確定減額期間終了年月日() == null) {
            entity.set確定減額期間終了年月日(FlexibleDate.EMPTY);
        }
        if (entity.get広域内住所地特例フラグ() == null) {
            entity.set広域内住所地特例フラグ(RString.EMPTY);
        }
        if (entity.get町域コード() == null) {
            entity.set町域コード(ChoikiCode.EMPTY);
        }
        if (entity.get広住特措置元市町村コード() == null) {
            entity.set広住特措置元市町村コード(LasdecCode.EMPTY);
        }
        if (entity.get証記載保険者番号() == null) {
            entity.set証記載保険者番号(ShoKisaiHokenshaNo.EMPTY);
        }
        return entity;
    }

}
