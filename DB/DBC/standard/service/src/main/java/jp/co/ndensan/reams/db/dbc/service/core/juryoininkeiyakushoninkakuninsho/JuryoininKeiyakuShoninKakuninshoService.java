/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.juryoininkeiyakushoninkakuninsho;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import jp.co.ndensan.reams.db.dbc.definition.core.keiyakuservice.KeiyakuServiceShurui;
import jp.co.ndensan.reams.db.dbc.definition.core.shoninkubun.ShoninKubun;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc010010.BusinessEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc010010.JuryoininKeiyakuShoninKakuninshoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc100029.JyuryoItakuKeiyakuKakuninShoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc100030.JyuryoItakuKeiyakuKakuninShoKeiyakuJigyoshayoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc200013.JuryoIninShoninKakuninshoIchiranEntity;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoHanyoManager;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.AtesakiFactory;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ua.uax.business.report.parts.sofubutsuatesaki.SofubutsuAtesakiSourceBuilder;
import jp.co.ndensan.reams.ua.uax.business.report.parts.util.atesaki.ReportAtesakiEditor;
import jp.co.ndensan.reams.ua.uax.business.report.parts.util.atesaki.ReportAtesakiEditorBuilder;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt250FindAtesakiEntity;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.util.barcode.CustomerBarCode;

/**
 * 介護保険受領委任契約承認（不承認）確認書ビジネス
 *
 * @reamsid_L DBC-1910-060 yuanzhenxia
 */
public class JuryoininKeiyakuShoninKakuninshoService {

    private static final RString STRING = new RString("###,###,###,##0");
    private static final RString 帳票制御汎用キー_宛先敬称 = new RString("宛先敬称");
    private static final RString 年 = new RString("年");
    private static final RString ZERO = new RString("0");
    private static final int FIFTEEN = 15;
    private static final int THIRTY_SIX = 36;
    private static final int ONE = 1;
    private static final int SIXTEEN = 16;
    private static final int THIRTY = 30;

    /**
     * ビジネスEntityを作成する。
     *
     * @param entity JuryoininKeiyakuShoninKakuninshoEntity
     * @return BusinessEntity
     */
    public BusinessEntity setJuryoininShouninkakuninshoChouhyouSakusei(JuryoininKeiyakuShoninKakuninshoEntity entity) {
        BusinessEntity businessEntity = new BusinessEntity();
        UaFt250FindAtesakiEntity atesakiEntity = entity.get宛先();
        if (atesakiEntity != null) {
            IAtesaki atesaki = AtesakiFactory.createInstance(atesakiEntity);
            ReportAtesakiEditorBuilder sofubutsuAtesakiEditorBuilder = new ReportAtesakiEditorBuilder(atesaki);
            ReportAtesakiEditor reportAtesakiEditor = new ReportAtesakiEditor(sofubutsuAtesakiEditorBuilder);
            SofubutsuAtesakiSourceBuilder sofubutsuAtesakiSourceBuilder = new SofubutsuAtesakiSourceBuilder(reportAtesakiEditor);
            SofubutsuAtesakiSource 宛先Source = sofubutsuAtesakiSourceBuilder.buildSource();
            businessEntity.set利用者向けEntity(edit利用者向けEntity(宛先Source, entity));
        } else {
            businessEntity.set利用者向けEntity(edit利用者向けEntity(null, entity));
        }
        businessEntity.set事業者用Entity(edit事業者用Entity(entity));
        businessEntity.set一覧表Entity(edit一覧表Entity(entity));
        return businessEntity;
    }

    private JyuryoItakuKeiyakuKakuninShoEntity edit利用者向けEntity(SofubutsuAtesakiSource 宛先Source, JuryoininKeiyakuShoninKakuninshoEntity entity) {
        JyuryoItakuKeiyakuKakuninShoEntity 利用者向けEntity = new JyuryoItakuKeiyakuKakuninShoEntity();
        if (宛先Source != null) {
            利用者向けEntity.set郵便番号(宛先Source.yubinNo);
            利用者向けEntity.set行政区(宛先Source.gyoseiku);
            利用者向けEntity.set住所Text(宛先Source.jushoText);
            利用者向けEntity.set住所1(宛先Source.jusho1);
            利用者向けEntity.set住所2(宛先Source.jusho2);
            利用者向けEntity.set住所3(宛先Source.jusho3);
            利用者向けEntity.set方書1(宛先Source.katagaki1);
            利用者向けEntity.set方書2(宛先Source.katagaki2);
            利用者向けEntity.set方書Small1(宛先Source.katagakiSmall1);
            利用者向けEntity.set方書Small2(宛先Source.katagakiSmall2);
            利用者向けEntity.set代納人区分(宛先Source.dainoKubunMei);
            利用者向けEntity.set氏名Text(宛先Source.shimeiText);
            利用者向けEntity.set氏名1(宛先Source.shimei1);
            利用者向けEntity.set氏名2(宛先Source.shimei2);
            利用者向けEntity.set氏名Small1(宛先Source.shimeiSmall1);
            利用者向けEntity.set氏名Small2(宛先Source.shimeiSmall2);
            利用者向けEntity.set氏名samabunText(宛先Source.samabunShimeiText);
            利用者向けEntity.set氏名samabun1(宛先Source.samabunShimei1);
            利用者向けEntity.set氏名samabun2(宛先Source.samabunShimei2);
            利用者向けEntity.set氏名samabunSmall1(宛先Source.samabunShimeiSmall1);
            利用者向けEntity.set氏名samabunSmall2(宛先Source.samabunShimeiSmall2);
            利用者向けEntity.set名称付与1(宛先Source.meishoFuyo1);
            利用者向けEntity.set名称付与2(宛先Source.meishoFuyo2);
            利用者向けEntity.set様文1(宛先Source.samaBun1);
            利用者向けEntity.set様文2(宛先Source.samaBun2);
            利用者向けEntity.set括弧Left1(宛先Source.kakkoLeft1);
            利用者向けEntity.set括弧Left2(宛先Source.kakkoLeft2);
            利用者向けEntity.set括弧Right1(宛先Source.kakkoRight1);
            利用者向けEntity.set括弧Right2(宛先Source.kakkoRight2);
            利用者向けEntity.setカスタマバーコード(宛先Source.customerBarCode);
        }
        if (entity.get名称() != null) {
            利用者向けEntity.set被保険者氏名(entity.get名称().value());
        }
        利用者向けEntity.set被保険者番号(entity.get償還受領委任契約者().getHihokenshaNo().value());
        if (entity.get償還受領委任契約者().getUketsukeYMD() != null) {
            利用者向けEntity.set受付日(getWarekiYmd(entity.get償還受領委任契約者().getUketsukeYMD()));
        }
        利用者向けEntity.set承認区分(edit承認区分(entity.get償還受領委任契約者().getShoninKekkaKubun()));
        if (entity.get償還受領委任契約者().getKetteiYMD() != null) {
            利用者向けEntity.set承認年月日(getWarekiYmd(entity.get償還受領委任契約者().getKetteiYMD()));
        }
        if (ZERO.equals(entity.get償還受領委任契約者().getShoninKekkaKubun())) {
            利用者向けEntity.set不承認理由(entity.get償還受領委任契約者().getFuShoninRiyu());
        }
        利用者向けEntity.set給付の種類(edit契約サービス種類(entity.get償還受領委任契約者().getKeiyakuServiceShurui()));
        if (entity.get受領委任契約事業者() != null) {
            AtenaMeisho keiyakuJigyoshaName = entity.get受領委任契約事業者().getKeiyakuJigyoshaName();
            if (keiyakuJigyoshaName != null) {
                利用者向けEntity.set事業所名(keiyakuJigyoshaName.value());
            }
            AtenaMeisho keiyakuDaihyoshaName = entity.get受領委任契約事業者().getKeiyakuDaihyoshaName();
            if (keiyakuDaihyoshaName != null) {
                利用者向けEntity.set代表者氏名(keiyakuDaihyoshaName.value());
            }
            YubinNo sofusakiYubinNo = entity.get受領委任契約事業者().getSofusakiYubinNo();
            if (sofusakiYubinNo != null) {
                利用者向けEntity.set事業所郵便番号(sofusakiYubinNo.value());
            }
            AtenaJusho keiyakuJigyoshaJusho = entity.get受領委任契約事業者().getKeiyakuJigyoshaJusho();
            if (keiyakuJigyoshaJusho != null) {
                利用者向けEntity.set事業所所在地(keiyakuJigyoshaJusho.value());
            }
            TelNo keiyakuJigyoshaTelNo = entity.get受領委任契約事業者().getKeiyakuJigyoshaTelNo();
            if (keiyakuJigyoshaTelNo != null) {
                利用者向けEntity.set事業所電話番号(keiyakuJigyoshaTelNo.value());
            }
        }
        利用者向けEntity.set費用額合計(decimalFormat(entity.get償還受領委任契約者().getHiyoGakuGokei()));
        利用者向けEntity.set保険対象費用額(decimalFormat(entity.get償還受領委任契約者().getHokenTaishoHiyoGaku()));
        利用者向けEntity.set利用者負担額(decimalFormat(entity.get償還受領委任契約者().getRiyoshaJikoFutanGaku()));
        利用者向けEntity.set保険給付額(decimalFormat(entity.get償還受領委任契約者().getHokenKyufuhiGaku()));
        利用者向けEntity.setページ(new RString(entity.getページ()));
        利用者向けEntity.set受領委任契約番号(entity.get償還受領委任契約者().getKeiyakuNo());
        FlexibleDate shinseiYMD = entity.get償還受領委任契約者().getShinseiYMD();
        if (shinseiYMD != null) {
            利用者向けEntity.set契約申請年月日(new RString(entity.get償還受領委任契約者().getShinseiYMD().toString()));
        }
        利用者向けEntity.set契約事業者番号(entity.get受領委任契約事業者().getKeiyakuJigyoshaNo());
        FlexibleDate juryoininKaishiYMD = entity.get償還受領委任契約者().getJuryoininKaishiYMD();
        if (juryoininKaishiYMD != null) {
            利用者向けEntity.set承認期間_開始(new RString(juryoininKaishiYMD.toString()));
        }
        return 利用者向けEntity;
    }

    private JyuryoItakuKeiyakuKakuninShoKeiyakuJigyoshayoEntity edit事業者用Entity(JuryoininKeiyakuShoninKakuninshoEntity entity) {
        JyuryoItakuKeiyakuKakuninShoKeiyakuJigyoshayoEntity 事業者用Entity = new JyuryoItakuKeiyakuKakuninShoKeiyakuJigyoshayoEntity();
        ChohyoSeigyoHanyoManager 帳票制御汎用Manager = new ChohyoSeigyoHanyoManager();
        if (entity.get受領委任契約事業者() != null) {
            AtenaMeisho keiyakuJigyoshaName = entity.get受領委任契約事業者().getKeiyakuJigyoshaName();
            YubinNo sofusakiYubinNo = entity.get受領委任契約事業者().getSofusakiYubinNo();
            YubinNo keiyakuJigyoshaYubinNo = entity.get受領委任契約事業者().getKeiyakuJigyoshaYubinNo();
            AtenaJusho sofusakiJusho = entity.get受領委任契約事業者().getSofusakiJusho();
            AtenaJusho keiyakuJigyoshaJusho = entity.get受領委任契約事業者().getKeiyakuJigyoshaJusho();
            AtenaMeisho sofusakiJigyoshaName = entity.get受領委任契約事業者().getSofusakiJigyoshaName();
            if (sofusakiJusho != null && !sofusakiJusho.isEmpty() && sofusakiYubinNo != null) {
                事業者用Entity.set郵便番号(sofusakiYubinNo.value());
            } else if (keiyakuJigyoshaYubinNo != null) {
                事業者用Entity.set郵便番号(keiyakuJigyoshaYubinNo.value());
            }
            if (sofusakiJusho != null && !sofusakiJusho.isEmpty()) {
                事業者用Entity.set住所Text(sofusakiJusho.value());
            } else if (keiyakuJigyoshaJusho != null) {
                事業者用Entity.set住所Text(keiyakuJigyoshaJusho.value());
            }
            if (sofusakiJusho != null && !sofusakiJusho.isEmpty() && sofusakiJigyoshaName != null) {
                事業者用Entity.set氏名Text(sofusakiJigyoshaName.value());
            } else if (keiyakuJigyoshaName != null) {
                事業者用Entity.set氏名Text(keiyakuJigyoshaName.value());
            }
            if (keiyakuJigyoshaName != null) {
                事業者用Entity.set事業所名(keiyakuJigyoshaName.value());
            }
            if (sofusakiYubinNo != null) {
                事業者用Entity.set事業所郵便番号(sofusakiYubinNo.value());
            }

            if (keiyakuJigyoshaJusho != null) {
                事業者用Entity.set事業所所在地(keiyakuJigyoshaJusho.value());
            }
        }
        事業者用Entity.set名称付与1(get帳票制御汎用(帳票制御汎用Manager, 帳票制御汎用キー_宛先敬称));
        事業者用Entity.setカスタマバーコード(editカスタマバーコード(entity));
        事業者用Entity.set受領委任契約番号(entity.get償還受領委任契約者().getKeiyakuNo());
        FlexibleDate shinseiYMD = entity.get償還受領委任契約者().getShinseiYMD();
        if (shinseiYMD != null) {
            事業者用Entity.set契約申請年月日(new RString(entity.get償還受領委任契約者().getShinseiYMD().toString()));
        }
        事業者用Entity.set契約事業者番号(entity.get受領委任契約事業者().getKeiyakuJigyoshaNo());
        FlexibleDate juryoininKaishiYMD = entity.get償還受領委任契約者().getJuryoininKaishiYMD();
        if (juryoininKaishiYMD != null) {
            事業者用Entity.set承認期間_開始(new RString(juryoininKaishiYMD.toString()));
        }
        edit事業者用EntitySub(entity, 事業者用Entity);
        return 事業者用Entity;
    }

    private void edit事業者用EntitySub(JuryoininKeiyakuShoninKakuninshoEntity entity,
            JyuryoItakuKeiyakuKakuninShoKeiyakuJigyoshayoEntity 事業者用Entity) {
        if (entity.get名称() != null) {
            事業者用Entity.set被保険者氏名(entity.get名称().value());
        }
        事業者用Entity.set被保険者番号(entity.get償還受領委任契約者().getHihokenshaNo().value());
        if (entity.get償還受領委任契約者().getUketsukeYMD() != null) {
            事業者用Entity.set受付日(getWarekiYmd(entity.get償還受領委任契約者().getUketsukeYMD()));
        }
        事業者用Entity.set承認区分(edit承認区分(entity.get償還受領委任契約者().getShoninKekkaKubun()));
        if (entity.get償還受領委任契約者().getKetteiYMD() != null) {
            事業者用Entity.set承認年月日(getWarekiYmd(entity.get償還受領委任契約者().getKetteiYMD()));
        }
        if (ZERO.equals(entity.get償還受領委任契約者().getShoninKekkaKubun())) {
            事業者用Entity.set不承認理由(entity.get償還受領委任契約者().getFuShoninRiyu());
        }
        事業者用Entity.set給付の種類(edit契約サービス種類(entity.get償還受領委任契約者().getKeiyakuServiceShurui()));

        if (entity.get受領委任契約事業者() != null) {
            AtenaMeisho keiyakuDaihyoshaName = entity.get受領委任契約事業者().getKeiyakuDaihyoshaName();
            if (keiyakuDaihyoshaName != null) {
                事業者用Entity.set代表者氏名(keiyakuDaihyoshaName.value());
            }

            TelNo keiyakuJigyoshaTelNo = entity.get受領委任契約事業者().getKeiyakuJigyoshaTelNo();
            if (keiyakuJigyoshaTelNo != null) {
                事業者用Entity.set事業所電話番号(keiyakuJigyoshaTelNo.value());
            }
        }
        事業者用Entity.set費用額合計(decimalFormat(entity.get償還受領委任契約者().getHiyoGakuGokei()));
        事業者用Entity.set保険対象費用額(decimalFormat(entity.get償還受領委任契約者().getHokenTaishoHiyoGaku()));
        事業者用Entity.set利用者負担額(decimalFormat(entity.get償還受領委任契約者().getRiyoshaJikoFutanGaku()));
        事業者用Entity.set保険給付額(decimalFormat(entity.get償還受領委任契約者().getHokenKyufuhiGaku()));
        事業者用Entity.setページ(new RString(entity.getページ()));

    }

    private JuryoIninShoninKakuninshoIchiranEntity edit一覧表Entity(JuryoininKeiyakuShoninKakuninshoEntity entity) {
        JuryoIninShoninKakuninshoIchiranEntity 一覧表Entity = new JuryoIninShoninKakuninshoIchiranEntity();
        一覧表Entity.set連番(new RString(entity.getページ()));
        if (entity.get償還受領委任契約者().getHihokenshaNo() != null) {
            一覧表Entity.set被保険者番号(entity.get償還受領委任契約者().getHihokenshaNo().value());
        }
        if (entity.get名称() != null) {
            一覧表Entity.set被保険者氏名1(subString(entity.get名称().value(), ONE, FIFTEEN));
            一覧表Entity.set被保険者氏名2(subString(entity.get名称().value(), SIXTEEN, THIRTY));
        }

        一覧表Entity.set受付日(editパターン4(entity.get償還受領委任契約者().getUketsukeYMD()));
        一覧表Entity.set承認開始日(editパターン4(entity.get償還受領委任契約者().getJuryoininKaishiYMD()));
        一覧表Entity.set承認終了日(editパターン4(entity.get償還受領委任契約者().getJuryoininShuryoYMD()));
        一覧表Entity.set承認終区分(edit承認区分(entity.get償還受領委任契約者().getShoninKekkaKubun()));
        if (entity.get受領委任契約事業者() != null) {
            AtenaMeisho keiyakuJigyoshaName = entity.get受領委任契約事業者().getKeiyakuJigyoshaName();
            if (keiyakuJigyoshaName != null) {
                一覧表Entity.set事業者名称(subString(keiyakuJigyoshaName.value(), ONE, THIRTY_SIX));
            }
            AtenaJusho keiyakuJigyoshaJusho = entity.get受領委任契約事業者().getKeiyakuJigyoshaJusho();
            if (keiyakuJigyoshaJusho != null) {
                一覧表Entity.set事業者所在地(subString(keiyakuJigyoshaJusho.value(), ONE, THIRTY_SIX));
            }
        }
        一覧表Entity.set承認日(editパターン4(entity.get償還受領委任契約者().getKetteiYMD()));
        一覧表Entity.set利用サービス内容(edit契約サービス種類(entity.get償還受領委任契約者().getKeiyakuServiceShurui()));
        一覧表Entity.set受領委任契約番号(entity.get償還受領委任契約者().getKeiyakuNo());
        FlexibleDate shinseiYMD = entity.get償還受領委任契約者().getShinseiYMD();
        if (shinseiYMD != null) {
            一覧表Entity.set契約申請年月日(new RString(entity.get償還受領委任契約者().getShinseiYMD().toString()));
        }
        一覧表Entity.set契約事業者番号(entity.get受領委任契約事業者().getKeiyakuJigyoshaNo());
        return 一覧表Entity;
    }

    /**
     * 金額を編集します。
     * <pre>
     * 結果：###,###,###,##9
     * </pre>
     *
     * @param number 金額
     * @return 結果
     */
    public RString decimalFormat(Decimal number) {
        if (number == null) {
            return RString.EMPTY;
        }
        NumberFormat format = new DecimalFormat(STRING.toString());
        return new RString(format.format(number));
    }

    private RString getWarekiYmd(FlexibleDate date) {
        RString wareki = RString.EMPTY;
        if (date != null) {
            wareki = date.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getYear()
                    .concat(年).concat(date.wareki().separator(Separator.JAPANESE).fillType(FillType.BLANK).getMonthDay());
        }
        return wareki;
    }

    private RString edit承認区分(RString kubun) {
        if (kubun == null || kubun.isEmpty()) {
            return RString.EMPTY;
        } else if (ShoninKubun.承認しない.getコード().equals(kubun)) {
            return ShoninKubun.承認しない.get名称();
        } else if (ShoninKubun.承認する.getコード().equals(kubun)) {
            return ShoninKubun.承認する.get名称();
        } else {
            return RString.EMPTY;
        }
    }

    private RString edit契約サービス種類(RString 契約サービス種類) {
        if (契約サービス種類 == null || 契約サービス種類.isEmpty()) {
            return RString.EMPTY;
        } else if (KeiyakuServiceShurui.予防住宅改修.getコード().equals(契約サービス種類)) {
            return KeiyakuServiceShurui.予防住宅改修.get名称();
        } else if (KeiyakuServiceShurui.予防福祉用具.getコード().equals(契約サービス種類)) {
            return KeiyakuServiceShurui.予防福祉用具.get名称();
        } else if (KeiyakuServiceShurui.住宅改修.getコード().equals(契約サービス種類)) {
            return KeiyakuServiceShurui.住宅改修.get名称();
        } else if (KeiyakuServiceShurui.償還払支給.getコード().equals(契約サービス種類)) {
            return KeiyakuServiceShurui.償還払支給.get名称();
        } else if (KeiyakuServiceShurui.福祉用具.getコード().equals(契約サービス種類)) {
            return KeiyakuServiceShurui.福祉用具.get名称();
        } else if (KeiyakuServiceShurui.高額給付支給.getコード().equals(契約サービス種類)) {
            return KeiyakuServiceShurui.高額給付支給.get名称();
        } else {
            return RString.EMPTY;
        }
    }

    private RString subString(RString rstr, int from, int to) {
        if (RString.isNullOrEmpty(rstr) || rstr.length() < from) {
            return RString.EMPTY;
        }
        RString tmp = RString.EMPTY;
        if (rstr.length() >= from && rstr.length() <= to) {
            tmp = rstr.substring(from - 1);
        }
        if (rstr.length() > to) {
            tmp = rstr.substring(from - 1, to);
        }
        return tmp;
    }

    private RString editパターン4(FlexibleDate date) {
        if (date == null) {
            return RString.EMPTY;
        }
        return date.wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD)
                .fillType(FillType.BLANK).toDateString();

    }

    private RString get帳票制御汎用(ChohyoSeigyoHanyoManager 帳票制御汎用Manager, RString 項目名) {
        RString 設定値 = RString.EMPTY;
        ChohyoSeigyoHanyo chohyoSeigyoHanyo = 帳票制御汎用Manager.get帳票制御汎用(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100030.getReportId(),
                FlexibleYear.MIN, 項目名);
        if (chohyoSeigyoHanyo != null) {
            設定値 = chohyoSeigyoHanyo.get設定値();
        }
        return 設定値;
    }

    private RString editカスタマバーコード(JuryoininKeiyakuShoninKakuninshoEntity entity) {
        CustomerBarCode barcode = new CustomerBarCode();
        if (entity.get受領委任契約事業者() != null) {
            AtenaJusho sofusakiJusho = entity.get受領委任契約事業者().getSofusakiJusho();
            YubinNo yubinNo = entity.get受領委任契約事業者().getSofusakiYubinNo();
            AtenaJusho keiyakuJigyoshaJusho = entity.get受領委任契約事業者().getKeiyakuJigyoshaJusho();
            YubinNo keiyakuJigyoshaYubinNo = entity.get受領委任契約事業者().getKeiyakuJigyoshaYubinNo();
            if (sofusakiJusho != null && !sofusakiJusho.isEmpty()
                    && yubinNo != null) {
                return barcode.convertCustomerBarCode(yubinNo.value(),
                        sofusakiJusho.value())
                        .getCustomerBarCode();
            } else if (keiyakuJigyoshaJusho != null && !keiyakuJigyoshaJusho.isEmpty()
                    && keiyakuJigyoshaYubinNo != null) {
                return barcode.convertCustomerBarCode(keiyakuJigyoshaYubinNo.value(),
                        keiyakuJigyoshaJusho.value()).getCustomerBarCode();
            } else {
                return RString.EMPTY;
            }
        } else {
            return RString.EMPTY;
        }
    }

}
