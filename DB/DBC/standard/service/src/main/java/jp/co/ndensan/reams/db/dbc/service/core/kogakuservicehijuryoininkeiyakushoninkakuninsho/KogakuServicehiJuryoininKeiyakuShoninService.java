/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kogakuservicehijuryoininkeiyakushoninkakuninsho;

import jp.co.ndensan.reams.db.dbc.definition.core.shoninkubun.ShoninKubun;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3076KogakuJuryoininKeiyakuJigyoshaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc010020.KogakuServicehiJuryoininKeiyakuShoninKakuninshoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc010020.ServiceEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc100031.KogakuServiceHiJyuryoItakuKeiyakuKakuninShoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc200013.JuryoIninShoninKakuninshoIchiranEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7060KaigoJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7062KaigoJigyoshaDaihyoshaEntity;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.AtesakiFactory;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ua.uax.business.report.parts.sofubutsuatesaki.SofubutsuAtesakiSourceBuilder;
import jp.co.ndensan.reams.ua.uax.business.report.parts.util.atesaki.ReportAtesakiEditor;
import jp.co.ndensan.reams.ua.uax.business.report.parts.util.atesaki.ReportAtesakiEditorBuilder;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt250FindAtesakiEntity;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 高額サービス費受領委任契約承認（不承認）確認書作成サービスのクラスです。
 *
 * @reamsid_L DBC-1970-060 zhouchuanlin
 */
public class KogakuServicehiJuryoininKeiyakuShoninService {

    private static final RString 利用サービス内容 = new RString("高額サービス費");
    private static final int FIFTEEN = 15;
    private static final int THIRTY_SIX = 36;
    private static final int ONE = 1;
    private static final int SIXTEEN = 16;
    private static final int THIRTY = 30;

    /**
     * ServiceEntityを作成する。
     *
     * @param entity KogakuServicehiJuryoininKeiyakuShoninKakuninshoEntity
     * @param ページ int
     * @return ServiceEntity 額サービス費受領委任契約承認（不承認）確認書作成サービス用entity
     */
    public ServiceEntity setKogakuServicehiJuryoininKeiyakuShoninKakuninshoService(
            KogakuServicehiJuryoininKeiyakuShoninKakuninshoEntity entity, int ページ) {
        ServiceEntity serviceEntity = new ServiceEntity();
        UaFt250FindAtesakiEntity atesakiEntity = entity.get宛先();
        IAtesaki atesaki = AtesakiFactory.createInstance(atesakiEntity);
        ReportAtesakiEditorBuilder sofubutsuAtesakiEditorBuilder = new ReportAtesakiEditorBuilder(atesaki);
        ReportAtesakiEditor reportAtesakiEditor = new ReportAtesakiEditor(sofubutsuAtesakiEditorBuilder);
        SofubutsuAtesakiSourceBuilder sofubutsuAtesakiSourceBuilder = new SofubutsuAtesakiSourceBuilder(reportAtesakiEditor);
        SofubutsuAtesakiSource 宛先Source = sofubutsuAtesakiSourceBuilder.buildSource();
        serviceEntity.set一覧表Entity(edit一覧表Entity(entity, ページ));
        serviceEntity.set介護保険高額Entity(edit介護保険高額Entity(宛先Source, entity));
        return serviceEntity;
    }

    private JuryoIninShoninKakuninshoIchiranEntity edit一覧表Entity(KogakuServicehiJuryoininKeiyakuShoninKakuninshoEntity entity, int ページ) {
        JuryoIninShoninKakuninshoIchiranEntity 一覧表Entity = new JuryoIninShoninKakuninshoIchiranEntity();
        DbT7060KaigoJigyoshaEntity 介護事業者 = entity.get介護事業者();
        AtenaJusho jigyoshaAddress = new AtenaJusho(RString.EMPTY);
        AtenaMeisho 事業者名称 = new AtenaMeisho(RString.EMPTY);
        if (介護事業者 != null) {
            jigyoshaAddress = 介護事業者.getJigyoshaAddress();
            事業者名称 = 介護事業者.getJigyoshaName();
        }
        一覧表Entity.set連番(new RString(ページ));
        if (entity.get高額介護事業者().getHihokenshaNo() != null && !entity.get高額介護事業者().getHihokenshaNo().isEmpty()) {
            一覧表Entity.set被保険者番号(entity.get高額介護事業者().getHihokenshaNo().value());
        }
        if (entity.get名称() != null && !entity.get名称().isEmpty()) {
            一覧表Entity.set被保険者氏名1(subString(entity.get名称().value(), ONE, FIFTEEN));
        }
        if (jigyoshaAddress != null && !jigyoshaAddress.isEmpty()) {
            一覧表Entity.set事業者所在地(subString(jigyoshaAddress.value(), ONE, THIRTY_SIX));
        }
        一覧表Entity.set受付日(do日付編集パターン_4(entity.get高額介護事業者().getUketsukeYMD()));
        一覧表Entity.set承認開始日(do日付編集パターン_4(entity.get高額介護事業者().getJuryoininKaishiYMD()));
        一覧表Entity.set承認終了日(do日付編集パターン_4(entity.get高額介護事業者().getJuryoininShuryoYMD()));
        一覧表Entity.set承認終区分(ShoninKubun.toValue(entity.get高額介護事業者().getShoninKekkaKubun()).get名称());
        if (entity.get名称() != null && !entity.get名称().isEmpty()) {
            一覧表Entity.set被保険者氏名2(subString(entity.get名称().value(), SIXTEEN, THIRTY));
        }
        if (事業者名称 != null && !事業者名称.isEmpty()) {
            一覧表Entity.set事業者名称(subString(事業者名称.value(), ONE, THIRTY_SIX));
        }
        一覧表Entity.set承認日(do日付編集パターン_4(entity.get高額介護事業者().getKetteiYMD()));
        一覧表Entity.set利用サービス内容(利用サービス内容);
        return 一覧表Entity;
    }

    private KogakuServiceHiJyuryoItakuKeiyakuKakuninShoEntity edit介護保険高額Entity(
            SofubutsuAtesakiSource 宛先Source, KogakuServicehiJuryoininKeiyakuShoninKakuninshoEntity entity) {
        KogakuServiceHiJyuryoItakuKeiyakuKakuninShoEntity 介護保険高額Entity = new KogakuServiceHiJyuryoItakuKeiyakuKakuninShoEntity();
        DbT7060KaigoJigyoshaEntity 介護事業者 = entity.get介護事業者();
        DbT3076KogakuJuryoininKeiyakuJigyoshaEntity 高額介護事業者 = entity.get高額介護事業者();
        DbT7062KaigoJigyoshaDaihyoshaEntity 介護事業者代表者 = entity.get介護事業者代表者();
        AtenaMeisho 事業者名称 = new AtenaMeisho(RString.EMPTY);
        YubinNo yubinNo = new YubinNo(RString.EMPTY);
        AtenaJusho jigyoshaAddress = new AtenaJusho(RString.EMPTY);
        TelNo telNo = new TelNo(RString.EMPTY);
        AtenaMeisho 代表者名 = new AtenaMeisho(RString.EMPTY);
        if (介護事業者 != null) {
            事業者名称 = 介護事業者.getJigyoshaName();
            yubinNo = 介護事業者.getYubinNo();
            jigyoshaAddress = 介護事業者.getJigyoshaAddress();
            telNo = 介護事業者.getTelNo();
        }
        if (介護事業者代表者 != null) {
            代表者名 = 介護事業者代表者.getDaihyoshaShimei();
        }
        介護保険高額Entity.set郵便番号(宛先Source.yubinNo);
        介護保険高額Entity.set行政区(宛先Source.gyoseiku);
        介護保険高額Entity.set住所Text(宛先Source.jushoText);
        介護保険高額Entity.set住所1(宛先Source.jusho1);
        介護保険高額Entity.set住所2(宛先Source.jusho2);
        介護保険高額Entity.set住所3(宛先Source.jusho3);
        介護保険高額Entity.set方書1(宛先Source.katagaki1);
        介護保険高額Entity.set方書2(宛先Source.katagaki2);
        介護保険高額Entity.set方書Small1(宛先Source.katagakiSmall1);
        介護保険高額Entity.set方書Small2(宛先Source.katagakiSmall2);
        介護保険高額Entity.set代納人区分(宛先Source.dainoKubunMei);
        介護保険高額Entity.set氏名Text(宛先Source.shimeiText);
        介護保険高額Entity.set氏名1(宛先Source.shimei1);
        介護保険高額Entity.set氏名2(宛先Source.shimei2);
        介護保険高額Entity.set氏名Small1(宛先Source.shimeiSmall1);
        介護保険高額Entity.set氏名Small2(宛先Source.shimeiSmall2);
        介護保険高額Entity.set氏名samabunText(宛先Source.samabunShimeiText);
        介護保険高額Entity.set氏名samabun1(宛先Source.samabunShimei1);
        介護保険高額Entity.set氏名samabun2(宛先Source.samabunShimei2);
        介護保険高額Entity.set氏名samabunSmall1(宛先Source.samabunShimeiSmall1);
        介護保険高額Entity.set氏名samabunSmall2(宛先Source.samabunShimeiSmall2);
        介護保険高額Entity.set名称付与1(宛先Source.meishoFuyo1);
        介護保険高額Entity.set名称付与2(宛先Source.meishoFuyo2);
        介護保険高額Entity.set様文1(宛先Source.samaBun1);
        介護保険高額Entity.set様文2(宛先Source.samaBun2);
        介護保険高額Entity.set括弧Left1(宛先Source.kakkoLeft1);
        介護保険高額Entity.set括弧Left2(宛先Source.kakkoLeft2);
        介護保険高額Entity.set括弧Right1(宛先Source.kakkoRight1);
        介護保険高額Entity.set括弧Right2(宛先Source.kakkoRight2);
        介護保険高額Entity.setカスタマバーコード(宛先Source.customerBarCode);
        if (高額介護事業者.getHihokenshaNo() != null && !高額介護事業者.getHihokenshaNo().isEmpty()) {
            介護保険高額Entity.set被保険者番号(高額介護事業者.getHihokenshaNo().value());
        }
        介護保険高額Entity.set受付日(
                do日付編集パターン_12(高額介護事業者.getUketsukeYMD()));
        介護保険高額Entity.set承認区分(
                ShoninKubun.toValue(高額介護事業者.getShoninKekkaKubun()).get名称());
        介護保険高額Entity.set承認年月日(
                do日付編集パターン_12(高額介護事業者.getKetteiYMD()));
        if (ShoninKubun.承認しない.getコード().equals(ShoninKubun.toValue(高額介護事業者.getShoninKekkaKubun()).getコード())) {
            介護保険高額Entity.set不承認理由(高額介護事業者.getFuShoninRiyu());
        }
        if (事業者名称 != null && !事業者名称.isEmpty()) {
            介護保険高額Entity.set事業所名(事業者名称.value());
        }
        if (代表者名 != null && !代表者名.isEmpty()) {
            介護保険高額Entity.set代表者名(代表者名.value());
        }
        if (null != yubinNo && !yubinNo.isEmpty()) {
            介護保険高額Entity.set事業所郵便番号(yubinNo.value());
        }
        if (null != jigyoshaAddress && !jigyoshaAddress.isEmpty()) {
            介護保険高額Entity.set事業所所在地(jigyoshaAddress.value());
        }
        if (null != telNo && !telNo.isEmpty()) {
            介護保険高額Entity.set事業所電話番号(telNo.value());
        }
        Decimal 利用者負担上限額 = 高額介護事業者.getRiyoshaFutanJogenGaku();
        if (利用者負担上限額 != null) {
            介護保険高額Entity.set利用者負担上限額(new RString(利用者負担上限額.toString()));
        }
        edit介護保険高額名称(介護保険高額Entity, entity);
        return 介護保険高額Entity;
    }

    private void edit介護保険高額名称(KogakuServiceHiJyuryoItakuKeiyakuKakuninShoEntity 介護保険高額Entity,
            KogakuServicehiJuryoininKeiyakuShoninKakuninshoEntity entity) {
        if (entity.getカナ名称() != null && !entity.getカナ名称().isEmpty()) {
            介護保険高額Entity.set被保険者氏名カナ(entity.getカナ名称().value());
        }
        if (entity.get名称() != null && !entity.get名称().isEmpty()) {
            介護保険高額Entity.set被保険者氏名(entity.get名称().value());
        }
    }

    private RString do日付編集パターン_4(FlexibleDate date) {
        if (date == null) {
            return RString.EMPTY;
        }
        return date.wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD)
                .fillType(FillType.BLANK).toDateString();

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

    private RString do日付編集パターン_12(FlexibleDate date) {
        if (null == date) {
            return RString.EMPTY;
        }
        return date.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
    }
}
