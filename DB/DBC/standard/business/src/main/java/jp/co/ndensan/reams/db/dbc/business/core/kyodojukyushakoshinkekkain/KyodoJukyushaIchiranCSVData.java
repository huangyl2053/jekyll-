/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kyodojukyushakoshinkekkain;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_IdoKubunCode;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_JukyushaIdoJiyu;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_KyodoKogakuRiyoshafutanDai2dankai;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_KyodoKogakuRoreifukushinenkinJukyuUmu;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_KyodoKogakuSetaiShotokuKubunCode;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_KyodoKogakuShikyuShinseishoShutsuryokuUmu;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_KyodoKogakuShotokuKubunCode;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_KyodoShokanIchijiSashitomeKubunCode;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_TeiseiKubunCode;
import jp.co.ndensan.reams.db.dbc.entity.csv.kyodojukyushakoshinkekkain.KyodoJukyushaIchiranCSVEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyodojukyushakoshinkekkaichiran.DbWT0001HihokenshaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyodojukyushakoshinkekkaichiran.DbWT5C30KyoudouShoriEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyodojukyushakoshinkekkaichiran.KyodoJukyushaKoshinkekkaIchiranReportData;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyodojukyushakoshinkekkain.KyodoJukyushaKoshinkekkaIchiranEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 共同処理用受給者情報一覧表のCsvData設定クラスです。
 *
 * @reamsid_L DBC-2780-010 lishengli
 */
public class KyodoJukyushaIchiranCSVData {

    private static final RString DATE_時 = new RString("時");
    private static final RString DATE_分 = new RString("分");
    private static final RString DATE_秒 = new RString("秒");
    private static final RString SAKUSEI = new RString("作成");

    /**
     * 共同処理用受給者情報一覧表のReportデータの設定です。
     *
     * @param entity 共同処理用受給者情報一覧表のEntity
     * @return 共同処理用受給者情報一覧表のReportデータ
     */
    public KyodoJukyushaKoshinkekkaIchiranReportData getReportData(KyodoJukyushaKoshinkekkaIchiranEntity entity) {
        DbWT5C30KyoudouShoriEntity t5C30Entity = new DbWT5C30KyoudouShoriEntity();
        t5C30Entity.set連番(entity.get連番());
        t5C30Entity.set保険者番号(entity.get保険者番号());
        t5C30Entity.set保険者名(entity.get保険者名());
        t5C30Entity.set集約被保険者番号(entity.get集約被保険者番号());
        t5C30Entity.set集約異動年月日(entity.get集約異動年月日());
        t5C30Entity.set基_交換情報識別番号(entity.get基_交換情報識別番号());
        t5C30Entity.set基_異動年月日(entity.get基_異動年月日());
        t5C30Entity.set基_異動区分コード(entity.get基_異動区分コード());
        t5C30Entity.set基_訂正年月日(entity.get基_訂正年月日());
        t5C30Entity.set基_訂正区分コード(entity.get基_訂正区分コード());
        t5C30Entity.set基_異動事由(entity.get基_異動事由());
        t5C30Entity.set基_証記載保険者番号(entity.get基_証記載保険者番号());
        t5C30Entity.set基_被保険者番号(entity.get基_被保険者番号());
        t5C30Entity.set基_被保険者氏名(entity.get基_被保険者氏名());
        t5C30Entity.set基_電話番号(entity.get基_電話番号());
        t5C30Entity.set基_郵便番号(entity.get基_郵便番号());
        t5C30Entity.set基_住所カナ(entity.get基_住所カナ());
        t5C30Entity.set基_住所(entity.get基_住所());
        t5C30Entity.set基_帳票出力順序コード(entity.get基_帳票出力順序コード());
        t5C30Entity.set償_交換情報識別番号(entity.get償_交換情報識別番号());
        t5C30Entity.set償_異動年月日(entity.get償_異動年月日());
        t5C30Entity.set償_異動区分コード(entity.get償_異動区分コード());
        t5C30Entity.set償_訂正年月日(entity.get償_訂正年月日());
        t5C30Entity.set償_訂正区分コード(entity.get償_訂正区分コード());
        t5C30Entity.set償_異動事由(entity.get償_異動事由());
        t5C30Entity.set償_証記載保険者番号(entity.get償_証記載保険者番号());
        t5C30Entity.set償_被保険者番号(entity.get償_被保険者番号());
        t5C30Entity.set償_保険給付支払の一時差止の開始年月日(entity.get償_保険給付支払の一時差止の開始年月日());
        t5C30Entity.set償_保険給付支払の一時差止の終了年月日(entity.get償_保険給付支払の一時差止の終了年月日());
        t5C30Entity.set償_保険給付支払の一時差止区分(entity.get償_保険給付支払の一時差止区分());
        t5C30Entity.set償_保険給付支払の一時差止金額(entity.get償_保険給付支払の一時差止金額());
        t5C30Entity.set高_交換情報識別番号(entity.get高_交換情報識別番号());
        t5C30Entity.set高_異動年月日(entity.get高_異動年月日());
        t5C30Entity.set高_異動区分コード(entity.get高_異動区分コード());
        t5C30Entity.set高_訂正年月日(entity.get高_訂正年月日());
        t5C30Entity.set高_訂正区分コード(entity.get高_訂正区分コード());
        t5C30Entity.set高_異動事由(entity.get高_異動事由());
        t5C30Entity.set高_証記載保険者番号(entity.get高_証記載保険者番号());
        t5C30Entity.set高_被保険者番号(entity.get高_被保険者番号());
        t5C30Entity.set高_世帯主被保険者番号(entity.get高_世帯主被保険者番号());
        t5C30Entity.set高_世帯所得区分コード(entity.get高_世帯所得区分コード());
        t5C30Entity.set高_所得区分コード(entity.get高_所得区分コード());
        t5C30Entity.set高_老齢福祉年金受給の有無(entity.get高_老齢福祉年金受給の有無());
        t5C30Entity.set高_利用者負担第２段階(entity.get高_利用者負担第２段階());
        t5C30Entity.set高_支給申請書出力の有無(entity.get高_支給申請書出力の有無());
        DbWT0001HihokenshaEntity t0001Entity = new DbWT0001HihokenshaEntity();
        t0001Entity.set連番(entity.getT0001連番());
        t0001Entity.set証記載保険者番号(entity.get証記載保険者番号());
        t0001Entity.set被保険者番号(entity.get被保険者番号());
        t0001Entity.setサービス提供年月末日(entity.getサービス提供年月末日());
        t0001Entity.set被保険者カナ氏名(entity.get被保険者カナ氏名());
        t0001Entity.set被保険者氏名(entity.get被保険者氏名());
        t0001Entity.set旧市町村コード(entity.get旧市町村コード());
        t0001Entity.set変換被保険者番号(entity.get変換被保険者番号());
        t0001Entity.set登録被保険者番号(entity.get登録被保険者番号());
        t0001Entity.set市町村コード(entity.get市町村コード());
        t0001Entity.set管内管外区分(entity.get管内管外区分());
        t0001Entity.set郵便番号(entity.get郵便番号());
        t0001Entity.set町域コード(entity.get町域コード());
        t0001Entity.set行政区コード(entity.get行政区コード());
        t0001Entity.set行政区名(entity.get行政区名());
        t0001Entity.set住所(entity.get住所());
        t0001Entity.set番地(entity.get番地());
        t0001Entity.set方書(entity.get方書());
        t0001Entity.set宛名カナ名称(entity.get宛名カナ名称());
        t0001Entity.set宛名名称(entity.get宛名名称());
        t0001Entity.set氏名50音カナ(entity.get氏名50音カナ());
        t0001Entity.set識別コード(entity.get識別コード());
        t0001Entity.set資格取得日(entity.get資格取得日());
        t0001Entity.set資格取得事由コード(entity.get資格取得事由コード());
        t0001Entity.set資格喪失日(entity.get資格喪失日());
        t0001Entity.set資格喪失事由コード(entity.get資格喪失事由コード());
        t0001Entity.set世帯集約番号(entity.get世帯集約番号());
        DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity t3002Entity = new DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity();
        t3002Entity.setInsertDantaiCd(entity.getInsertDantaiCd());
        t3002Entity.setIsDeleted(entity.isDeleted());
        t3002Entity.setLastUpdateReamsLoginId(entity.getInsertDantaiCd());
        t3002Entity.setHiHokenshaNo(entity.getHiHokenshaNo());
        t3002Entity.setIdoYMD(entity.getIdoYMD());
        t3002Entity.setRirekiNo(entity.getRirekiNo());
        t3002Entity.setIdoKubunCode(entity.getIdoKubunCode());
        t3002Entity.setJukyushaIdoJiyu(entity.getJukyushaIdoJiyu());
        t3002Entity.setShoKisaiHokenshaNo(entity.getShoKisaiHokenshaNo());
        t3002Entity.setHiHokenshaName(entity.getHiHokenshaName());
        t3002Entity.setYubinNo(entity.getYubinNo());
        t3002Entity.setDdressKana(entity.getDdressKana());
        t3002Entity.setAddress(entity.getAddress());
        t3002Entity.setTelNo(entity.getTelNo());
        t3002Entity.setChohyoOutputJunjyoCode(entity.getChohyoOutputJunjyoCode());
        t3002Entity.setTeiseiRenrakuhyoFlag(entity.isTeiseiRenrakuhyoFlag());
        t3002Entity.setSofuYM(entity.getSofuYM());
        t3002Entity.setTeiseiKubunCode(entity.getTeiseiKubunCode());
        t3002Entity.setTeiseiYMD(entity.getTeiseiYMD());
        t3002Entity.setLogicalDeletedFlag(entity.isLogicalDeletedFlag());
        KyodoJukyushaKoshinkekkaIchiranReportData reportData = new KyodoJukyushaKoshinkekkaIchiranReportData();
        reportData.set共同処理一時TBL(t5C30Entity);
        reportData.set被保険者一時TBL(t0001Entity);
        reportData.set共同処理用受給者異動基本送付TBL(t3002Entity);
        return reportData;
    }

    /**
     * 共同処理用受給者情報一覧表のCsvData設定処理です。
     *
     * @param data 共同処理用受給者情報一覧表のReportデータ
     * @param is1行目 is1行目
     * @param 作成日時 作成日時
     * @return 共同処理用受給者情報一覧表のCsvEntity
     */
    public KyodoJukyushaIchiranCSVEntity getCSVEntity(KyodoJukyushaKoshinkekkaIchiranReportData data, boolean is1行目, RDateTime 作成日時) {
        KyodoJukyushaIchiranCSVEntity csvEntity = new KyodoJukyushaIchiranCSVEntity();
        if (is1行目) {
            csvEntity.set作成日時(get作成日時(作成日時));
        }
        csvEntity.set保険者番号(data.get共同処理一時TBL().get保険者番号());
        csvEntity.set保険者名(data.get共同処理一時TBL().get保険者名());
        if (data.get被保険者一時TBL().get登録被保険者番号() != null && !data.get被保険者一時TBL().get登録被保険者番号().isEmpty()) {
            csvEntity.set基_被保険者番号(data.get被保険者一時TBL().get登録被保険者番号().value());
        }
        csvEntity.set基_行政区コード(data.get被保険者一時TBL().get行政区コード());
        csvEntity.set基_行政区(data.get被保険者一時TBL().get行政区名());
        csvEntity.set基_被保険者カナ氏名(data.get被保険者一時TBL().get宛名カナ名称());
        csvEntity.set基_町域コード(data.get被保険者一時TBL().get町域コード());
        if (!RString.isNullOrEmpty(data.get共同処理一時TBL().get基_交換情報識別番号())) {
            csvEntity.set基_異動年月日(getパターン4(data.get共同処理一時TBL().get基_異動年月日()));
            csvEntity.set基_異動区分(data.get共同処理一時TBL().get基_異動区分コード());
            csvEntity.set基_異動区分名称(get異動区分名称(data.get共同処理一時TBL().get基_異動区分コード()));
            csvEntity.set基_異動事由(data.get共同処理一時TBL().get基_異動事由());
            csvEntity.set基_異動事由名称(get異動事由名称(data.get共同処理一時TBL().get基_異動事由()));
            csvEntity.set基_訂正年月日(getパターン4(data.get共同処理一時TBL().get基_訂正年月日()));
            csvEntity.set基_訂正区分(data.get共同処理一時TBL().get基_訂正区分コード());
            csvEntity.set基_訂正区分名称(get訂正区分名称(data.get共同処理一時TBL().get基_訂正区分コード()));
            csvEntity.set基_順序(data.get共同処理一時TBL().get基_帳票出力順序コード());
            csvEntity.set基_証記載保険者番号(data.get共同処理一時TBL().get基_証記載保険者番号());
            csvEntity.set基_被保険者氏名(data.get共同処理一時TBL().get基_被保険者氏名());
            csvEntity.set基_電話番号(data.get共同処理一時TBL().get基_電話番号());
            csvEntity.set基_郵便番号(data.get共同処理一時TBL().get基_郵便番号());
            csvEntity.set基_住所カナ(data.get共同処理一時TBL().get基_住所カナ());
            csvEntity.set基_住所(data.get共同処理一時TBL().get基_住所());
        } else {
            csvEntity.set基_異動年月日(getパターン4(data.get共同処理用受給者異動基本送付TBL().getIdoYMD()));
            csvEntity.set基_異動区分(data.get共同処理用受給者異動基本送付TBL().getIdoKubunCode());
            csvEntity.set基_異動区分名称(get異動区分名称(data.get共同処理用受給者異動基本送付TBL().getIdoKubunCode()));
            csvEntity.set基_異動事由(data.get共同処理用受給者異動基本送付TBL().getJukyushaIdoJiyu());
            csvEntity.set基_異動事由名称(get異動事由名称(data.get共同処理用受給者異動基本送付TBL().getJukyushaIdoJiyu()));
            csvEntity.set基_訂正年月日(getパターン4(data.get共同処理用受給者異動基本送付TBL().getTeiseiYMD()));
            csvEntity.set基_訂正区分(data.get共同処理用受給者異動基本送付TBL().getTeiseiKubunCode());
            csvEntity.set基_訂正区分名称(get訂正区分名称(data.get共同処理用受給者異動基本送付TBL().getTeiseiKubunCode()));
            csvEntity.set基_順序(data.get共同処理用受給者異動基本送付TBL().getChohyoOutputJunjyoCode());
            csvEntity.set基_証記載保険者番号(get証記載保険者番号(data.get共同処理用受給者異動基本送付TBL().getShoKisaiHokenshaNo()));
            csvEntity.set基_被保険者氏名(data.get共同処理用受給者異動基本送付TBL().getHiHokenshaName());
            csvEntity.set基_電話番号(get電話番号(data.get共同処理用受給者異動基本送付TBL().getTelNo()));
            csvEntity.set基_郵便番号(get郵便番号(data.get共同処理用受給者異動基本送付TBL().getYubinNo()));
            csvEntity.set基_住所カナ(data.get共同処理用受給者異動基本送付TBL().getDdressKana());
            csvEntity.set基_住所(data.get共同処理用受給者異動基本送付TBL().getAddress());
        }
        if (!RString.isNullOrEmpty(data.get共同処理一時TBL().get償_交換情報識別番号())) {
            csvEntity.set償_異動年月日(getパターン4(data.get共同処理一時TBL().get償_異動年月日()));
            csvEntity.set償_異動区分(data.get共同処理一時TBL().get償_異動区分コード());
            csvEntity.set償_異動区分名称(get異動区分名称(data.get共同処理一時TBL().get償_異動区分コード()));
            csvEntity.set償_異動事由(data.get共同処理一時TBL().get償_異動事由());
            csvEntity.set償_異動事由名称(get異動事由名称(data.get共同処理一時TBL().get償_異動事由()));
            csvEntity.set償_訂正年月日(getパターン4(data.get共同処理一時TBL().get償_訂正年月日()));
            csvEntity.set償_訂正区分(data.get共同処理一時TBL().get償_訂正区分コード());
            csvEntity.set償_訂正区分名称(get訂正区分名称(data.get共同処理一時TBL().get償_訂正区分コード()));
            csvEntity.set償_差止開始日(getパターン4(data.get共同処理一時TBL().get償_保険給付支払の一時差止の開始年月日()));
            csvEntity.set償_差止終了日(getパターン4(data.get共同処理一時TBL().get償_保険給付支払の一時差止の終了年月日()));
            csvEntity.set償_差止区分(data.get共同処理一時TBL().get償_保険給付支払の一時差止区分());
            csvEntity.set償_差止区分名称(get差止区分名称(data.get共同処理一時TBL().get償_保険給付支払の一時差止区分()));
            csvEntity.set償_差止金額(get一時差止金額(data.get共同処理一時TBL().get償_保険給付支払の一時差止金額()));
        }
        if (!RString.isNullOrEmpty(data.get共同処理一時TBL().get高_交換情報識別番号())) {
            csvEntity.set高_異動年月日(getパターン4(data.get共同処理一時TBL().get高_異動年月日()));
            csvEntity.set高_異動区分(data.get共同処理一時TBL().get高_異動区分コード());
            csvEntity.set高_異動区分名称(get異動区分名称(data.get共同処理一時TBL().get高_異動区分コード()));
            csvEntity.set高_異動事由(data.get共同処理一時TBL().get高_異動事由());
            csvEntity.set高_異動事由名称(get異動事由名称(data.get共同処理一時TBL().get高_異動事由()));
            csvEntity.set高_訂正年月日(getパターン4(data.get共同処理一時TBL().get償_訂正年月日()));
            csvEntity.set高_訂正区分(data.get共同処理一時TBL().get高_訂正区分コード());
            csvEntity.set高_訂正区分名称(get訂正区分名称(data.get共同処理一時TBL().get高_訂正区分コード()));
            csvEntity.set高_世帯主被保番号(data.get共同処理一時TBL().get高_世帯主被保険者番号());
            csvEntity.set高_世帯所得区分(data.get共同処理一時TBL().get高_世帯所得区分コード());
            csvEntity.set高_世帯所得区分名称(get世帯所得区分名称(data.get共同処理一時TBL().get高_世帯所得区分コード()));
            csvEntity.set高_所得区分(data.get共同処理一時TBL().get高_所得区分コード());
            csvEntity.set高_所得区分名称(get所得区分名称(data.get共同処理一時TBL().get高_所得区分コード()));
            csvEntity.set高_第２段階(data.get共同処理一時TBL().get高_利用者負担第２段階());
            csvEntity.set高_第２段階名称(get第２段階名称(data.get共同処理一時TBL().get高_利用者負担第２段階()));
            csvEntity.set高_支給申請書(data.get共同処理一時TBL().get高_利用者負担第２段階());
            csvEntity.set高_支給申請書名称(get支給申請書名称(data.get共同処理一時TBL().get高_利用者負担第２段階()));
            csvEntity.set高_年金受給有無(data.get共同処理一時TBL().get高_老齢福祉年金受給の有無());
            csvEntity.set高_年金受給有無名称(get年金受給有無名称(data.get共同処理一時TBL().get高_老齢福祉年金受給の有無()));
        }
        return csvEntity;
    }

    private RString get作成日時(RDateTime 作成日時) {
        RStringBuilder printTimeStampSb = new RStringBuilder();
        printTimeStampSb.append(作成日時.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.BLANK).toDateString());
        printTimeStampSb.append(RString.HALF_SPACE);
        printTimeStampSb.append(String.format("%02d", 作成日時.getHour()));
        printTimeStampSb.append(DATE_時);
        printTimeStampSb.append(String.format("%02d", 作成日時.getMinute()));
        printTimeStampSb.append(DATE_分);
        printTimeStampSb.append(String.format("%02d", 作成日時.getSecond()));
        printTimeStampSb.append(DATE_秒);
        printTimeStampSb.append(RString.HALF_SPACE);
        printTimeStampSb.append(SAKUSEI);
        return printTimeStampSb.toRString();
    }

    private RString getパターン4(RString 年月日) {
        if (!RString.isNullOrEmpty(年月日)) {
            return new FlexibleDate(年月日).wareki().eraType(EraType.KANJI_RYAKU).
                    firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
        }
        return RString.EMPTY;
    }

    private RString getパターン4(FlexibleDate 年月日) {
        if (年月日 != null && !年月日.isEmpty()) {
            return 年月日.wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
        }
        return RString.EMPTY;
    }

    private RString get異動区分名称(RString 異動区分コード) {
        if (!RString.isNullOrEmpty(異動区分コード)) {
            return JukyushaIF_IdoKubunCode.toValue(異動区分コード).get名称();
        }
        return RString.EMPTY;
    }

    private RString get異動事由名称(RString 異動事由) {
        if (!RString.isNullOrEmpty(異動事由)) {
            return JukyushaIF_JukyushaIdoJiyu.toValue(異動事由).get名称();
        }
        return RString.EMPTY;
    }

    private RString get訂正区分名称(RString 訂正区分) {
        if (!RString.isNullOrEmpty(訂正区分)) {
            return JukyushaIF_TeiseiKubunCode.toValue(訂正区分).get名称();
        }
        return RString.EMPTY;
    }

    private RString get差止区分名称(RString 差止区分) {
        if (!RString.isNullOrEmpty(差止区分)) {
            return JukyushaIF_KyodoShokanIchijiSashitomeKubunCode.toValue(差止区分).get名称();
        }
        return RString.EMPTY;
    }

    private RString get世帯所得区分名称(RString 世帯所得区分) {
        if (!RString.isNullOrEmpty(世帯所得区分)) {
            return JukyushaIF_KyodoKogakuSetaiShotokuKubunCode.toValue(世帯所得区分).get名称();
        }
        return RString.EMPTY;
    }

    private RString get所得区分名称(RString 所得区分) {
        if (!RString.isNullOrEmpty(所得区分)) {
            return JukyushaIF_KyodoKogakuShotokuKubunCode.toValue(所得区分).get名称();
        }
        return RString.EMPTY;
    }

    private RString get第２段階名称(RString 第２段階) {
        if (!RString.isNullOrEmpty(第２段階)) {
            return JukyushaIF_KyodoKogakuRiyoshafutanDai2dankai.toValue(第２段階).get名称();
        }
        return RString.EMPTY;
    }

    private RString get支給申請書名称(RString 支給申請書) {
        if (!RString.isNullOrEmpty(支給申請書)) {
            return JukyushaIF_KyodoKogakuShikyuShinseishoShutsuryokuUmu.toValue(支給申請書).get名称();
        }
        return RString.EMPTY;
    }

    private RString get年金受給有無名称(RString 年金受給有無) {
        if (!RString.isNullOrEmpty(年金受給有無)) {
            return JukyushaIF_KyodoKogakuRoreifukushinenkinJukyuUmu.toValue(年金受給有無).get名称();
        }
        return RString.EMPTY;
    }

    private RString get一時差止金額(RString 金額) {
        if (RString.isNullOrEmpty(金額)) {
            return RString.EMPTY;
        }
        if (金額.contains(",")) {
            金額 = 金額転換(金額.split(","));
        }
        return DecimalFormatter.toコンマ区切りRString(new Decimal(金額.toString()), 0);
    }

    private RString 金額転換(List<RString> 金額) {
        RStringBuilder builder = new RStringBuilder();
        for (RString kinkaku : 金額) {
            builder.append(kinkaku);
        }
        return builder.toRString();
    }

    private RString get証記載保険者番号(ShoKisaiHokenshaNo 証記載保険者番号) {
        if (証記載保険者番号 != null && !証記載保険者番号.isEmpty()) {
            return 証記載保険者番号.value();
        }
        return RString.EMPTY;
    }

    private RString get郵便番号(YubinNo 郵便番号) {
        if (郵便番号 != null && !郵便番号.isEmpty()) {
            return 郵便番号.getEditedYubinNo();
        }
        return RString.EMPTY;
    }

    private RString get電話番号(TelNo 電話番号) {
        if (電話番号 != null && !電話番号.isEmpty()) {
            return 電話番号.value();
        }
        return RString.EMPTY;
    }

}
