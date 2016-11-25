/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kaigokyufujuryoininkeiyakutoroku;

import java.util.HashMap;
import java.util.Map;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JuryoininKeiyakuJigyosha;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanJuryoininKeiyakusha;
import jp.co.ndensan.reams.db.dbc.business.core.kaigokyufujuryoininkeiyakutoroku.KaigoKyufuJuryoininKeiyakuTorokuResult;
import jp.co.ndensan.reams.db.dbc.definition.core.keiyakuservice.KeiyakuServiceShurui;
import jp.co.ndensan.reams.db.dbc.definition.core.shoninkubun.ShoninKubun;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kaigokyufujuryoininkeiyakutoroku.HihokenshaJohoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kaigokyufujuryoininkeiyakutoroku.KaigoKyufuJuryoininKeiyakuTorokuJigyoshaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kaigokyufujuryoininkeiyakutoroku.KaigoKyufuJuryoininKeiyakuTorokuRiyoshaEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kaigokyufujuryoininkeiyakutoroku.IKaigoKyufuJuryoininKeiyakuTorokuMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.core.editedatesaki.EditedAtesakiBuilder;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedAtesaki;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7065ChohyoSeigyoKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7067ChohyoSeigyoHanyoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7065ChohyoSeigyoKyotsuDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7067ChohyoSeigyoHanyoDac;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.GyomuKoyuKeyRiyoKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.SofusakiRiyoKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.atesaki.IAtesakiGyomuHanteiKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.atesaki.IAtesakiPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.service.core.shikibetsutaisho.ShikibetsuTaishoService;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.util.barcode.CustomerBarCode;
import jp.co.ndensan.reams.uz.uza.report.util.barcode.CustomerBarCodeResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 介護保険受領委任契約承認（不承認）確認書のビジネスクラスです。
 *
 * @reamsid_L DBC-2130-050 cuilin
 */
public class KaigoKyufuJuryoininKeiyakuToroku {

    private final MapperProvider mapperProvider;
    private final DbT7065ChohyoSeigyoKyotsuDac 帳票制御共通Dac;
    private final DbT7067ChohyoSeigyoHanyoDac 帳票制御汎用Dac;
    private static final RString KEY_HIHOKENSHANO = new RString("被保険者番号");
    private static final RString KEY_SHORIYMD = new RString("処理年月日");
    private static final ReportId 利用者向け帳票分類ID = new ReportId("DBC100029_JyuryoItakuKeiyakuKakuninSho");
    private static final ReportId 事業者用帳票分類ID = new ReportId("DBC100030_JyuryoItakuKeiyakuKakuninShoKeiyakuJigyoshayo");
    private static final RString 帳票タイトル = new RString("帳票タイトル");
    private static final RString 宛先敬称 = new RString("宛先敬称");
    private static final int NUM_1 = 1;
    private static final int NUM_2 = 2;

    /**
     * コンストラクタです。
     */
    KaigoKyufuJuryoininKeiyakuToroku() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.帳票制御共通Dac = InstanceProvider.create(DbT7065ChohyoSeigyoKyotsuDac.class);
        this.帳票制御汎用Dac = InstanceProvider.create(DbT7067ChohyoSeigyoHanyoDac.class);
    }

    /**
     * コンストラクタです。
     *
     * @param mapperProvider MapperProvider
     * @param 帳票制御共通Dac DbT7065ChohyoSeigyoKyotsuDac
     * @param 帳票制御汎用Dac DbT7067ChohyoSeigyoHanyoDac
     */
    KaigoKyufuJuryoininKeiyakuToroku(MapperProvider mapperProvider,
            DbT7065ChohyoSeigyoKyotsuDac 帳票制御共通Dac,
            DbT7067ChohyoSeigyoHanyoDac 帳票制御汎用Dac) {
        this.mapperProvider = mapperProvider;
        this.帳票制御共通Dac = 帳票制御共通Dac;
        this.帳票制御汎用Dac = 帳票制御汎用Dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KaigoKyufuJuryoininKeiyakuToroku}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link KaigoKyufuJuryoininKeiyakuToroku}のインスタンス
     */
    public static KaigoKyufuJuryoininKeiyakuToroku createInstance() {
        return InstanceProvider.create(KaigoKyufuJuryoininKeiyakuToroku.class);
    }

    /**
     * 受領委任契約承認確認書（被保険者向け、事業者用）を編集する。
     *
     * @param 償還受領委任契約者データ ShokanJuryoininKeiyakusha
     * @param 受領委任契約事業者データ JuryoininKeiyakuJigyosha
     * @param 文書番号 RString
     * @return KaigoKyufuJuryoininKeiyakuTorokuResult
     */
    public KaigoKyufuJuryoininKeiyakuTorokuResult setJuryoininShouninkakuninshoChouhyouSakusei(
            ShokanJuryoininKeiyakusha 償還受領委任契約者データ, JuryoininKeiyakuJigyosha 受領委任契約事業者データ, RString 文書番号) {
        KaigoKyufuJuryoininKeiyakuTorokuRiyoshaEntity 利用者向けEntity = new KaigoKyufuJuryoininKeiyakuTorokuRiyoshaEntity();
        KaigoKyufuJuryoininKeiyakuTorokuJigyoshaEntity 事業者用Entity = new KaigoKyufuJuryoininKeiyakuTorokuJigyoshaEntity();

        IKaigoKyufuJuryoininKeiyakuTorokuMapper mapper = mapperProvider.create(IKaigoKyufuJuryoininKeiyakuTorokuMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put(KEY_HIHOKENSHANO.toString(), 償還受領委任契約者データ.get被保険者番号());
        map.put(KEY_SHORIYMD.toString(), FlexibleDate.getNowDate());
        HihokenshaJohoEntity 被保険者情報 = mapper.get被保険者情報(map);
        set利用者向けEntity(利用者向けEntity, 文書番号, 償還受領委任契約者データ, 受領委任契約事業者データ, 被保険者情報);
        set事業者用Entity(事業者用Entity, 文書番号, 償還受領委任契約者データ, 受領委任契約事業者データ, 被保険者情報);
        KaigoKyufuJuryoininKeiyakuTorokuResult result = new KaigoKyufuJuryoininKeiyakuTorokuResult();
        result.set利用者向けEntity(利用者向けEntity);
        result.set事業者用Entity(事業者用Entity);
        return result;
    }

    private void set利用者向けEntity(KaigoKyufuJuryoininKeiyakuTorokuRiyoshaEntity 利用者向けEntity, RString 文書番号,
            ShokanJuryoininKeiyakusha 償還受領委任契約者データ, JuryoininKeiyakuJigyosha 受領委任契約事業者データ, HihokenshaJohoEntity 被保険者情報) {
        if (被保険者情報 == null) {
            return;
        }
        Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
        ChohyoSeigyoKyotsu 帳票利用者向け制御共通 = load帳票制御共通(利用者向け帳票分類ID);
        set送付物宛先_利用者向け(利用者向けEntity, 地方公共団体, 帳票利用者向け制御共通, 被保険者情報.get識別コード());
        利用者向けEntity.set識別コード(被保険者情報.get識別コード());
        利用者向けEntity.set文書番号(文書番号);
        ChohyoSeigyoHanyo 帳票制御汎用 = load帳票制御汎用(利用者向け帳票分類ID, 帳票タイトル);
        利用者向けEntity.setタイトル(帳票制御汎用.get設定値());

        Map<Integer, RString> 通知文情報 = ReportUtil.get通知文(SubGyomuCode.DBC介護給付, 利用者向け帳票分類ID, KamokuCode.EMPTY, NUM_1);
        利用者向けEntity.set文書1(通知文情報.get(NUM_1));
        利用者向けEntity.set被保険者氏名(被保険者情報.get名称漢字().getColumnValue());
        利用者向けEntity.set被保険者番号(償還受領委任契約者データ.get被保険者番号());
        利用者向けEntity.set受付日(償還受領委任契約者データ.get受付年月日().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.NONE).toDateString());
        利用者向けEntity.set承認区分(ShoninKubun.toValue(償還受領委任契約者データ.get承認結果区分()).get名称());
        利用者向けEntity.set承認年月日(償還受領委任契約者データ.get決定年月日() == null || 償還受領委任契約者データ.get決定年月日().isEmpty()
                ? RString.EMPTY : 償還受領委任契約者データ.get決定年月日().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.NONE).toDateString());
        利用者向けEntity.set不承認理由(ShoninKubun.承認しない.getコード().equals(償還受領委任契約者データ.get承認結果区分())
                ? 償還受領委任契約者データ.get不承認理由() : RString.EMPTY);
        利用者向けEntity.set給付の種類(KeiyakuServiceShurui.toValue(償還受領委任契約者データ.get契約サービス種類()).get名称());
        利用者向けEntity.set事業所名(受領委任契約事業者データ.get契約事業者名称());
        利用者向けEntity.set代表者氏名(受領委任契約事業者データ.get契約代表者氏名());
        利用者向けEntity.set事業所郵便番号(受領委任契約事業者データ.get契約事業者郵便番号());
        利用者向けEntity.set事業所所在地(受領委任契約事業者データ.get契約事業者住所());
        利用者向けEntity.set事業所電話番号(受領委任契約事業者データ.get契約事業者電話番号());
        利用者向けEntity.set費用額合計(toDecimal(償還受領委任契約者データ.get費用額合計()));
        利用者向けEntity.set保険対象費用額(toDecimal(償還受領委任契約者データ.get保険対象費用額()));
        利用者向けEntity.set利用者負担額(toDecimal(償還受領委任契約者データ.get利用者自己負担額()));
        利用者向けEntity.set保険給付額(toDecimal(償還受領委任契約者データ.get保険給付費額()));
        利用者向けEntity.set文書2(通知文情報.get(NUM_2));
        利用者向けEntity.setページ(RString.EMPTY);
    }

    private void set事業者用Entity(KaigoKyufuJuryoininKeiyakuTorokuJigyoshaEntity 事業者用Entity, RString 文書番号,
            ShokanJuryoininKeiyakusha 償還受領委任契約者データ, JuryoininKeiyakuJigyosha 受領委任契約事業者データ, HihokenshaJohoEntity 被保険者情報) {
        if (被保険者情報 == null) {
            return;
        }
        事業者用Entity.set識別コード(被保険者情報.get識別コード());
        CustomerBarCode barcode = new CustomerBarCode();
        if (受領委任契約事業者データ.get送付先住所() == null || 受領委任契約事業者データ.get送付先住所().getColumnValue().isEmpty()) {
            事業者用Entity.set郵便番号(受領委任契約事業者データ.get契約事業者郵便番号().getEditedYubinNo());
            事業者用Entity.set住所Text(受領委任契約事業者データ.get契約事業者住所().getColumnValue());
            事業者用Entity.set氏名Text(受領委任契約事業者データ.get契約事業者名称() == null ? RString.EMPTY
                    : 受領委任契約事業者データ.get契約事業者名称().getColumnValue());
            CustomerBarCodeResult result = barcode.convertCustomerBarCode(受領委任契約事業者データ.get契約事業者郵便番号().getYubinNo(),
                    受領委任契約事業者データ.get契約事業者住所().getColumnValue());
            事業者用Entity.setカスタマバーコード(result.getCustomerBarCode());
        } else {
            事業者用Entity.set郵便番号(受領委任契約事業者データ.get送付先郵便番号().getEditedYubinNo());
            事業者用Entity.set住所Text(受領委任契約事業者データ.get送付先住所().getColumnValue());
            事業者用Entity.set氏名Text(受領委任契約事業者データ.get送付先事業者名称() == null ? RString.EMPTY
                    : 受領委任契約事業者データ.get送付先事業者名称().getColumnValue());
            CustomerBarCodeResult result = barcode.convertCustomerBarCode(受領委任契約事業者データ.get送付先郵便番号().getYubinNo(),
                    受領委任契約事業者データ.get送付先住所().getColumnValue());
            事業者用Entity.setカスタマバーコード(result.getCustomerBarCode());
        }
        事業者用Entity.set行政区(RString.EMPTY);
        事業者用Entity.set住所1(RString.EMPTY);
        事業者用Entity.set住所2(RString.EMPTY);
        事業者用Entity.set住所3(RString.EMPTY);
        事業者用Entity.set方書Text(RString.EMPTY);
        事業者用Entity.set方書1(RString.EMPTY);
        事業者用Entity.set方書2(RString.EMPTY);
        事業者用Entity.set方書Small1(RString.EMPTY);
        事業者用Entity.set方書Small2(RString.EMPTY);
        事業者用Entity.set代納人区分(RString.EMPTY);
        事業者用Entity.set氏名1(RString.EMPTY);
        事業者用Entity.set氏名2(RString.EMPTY);
        事業者用Entity.set氏名Small1(RString.EMPTY);
        事業者用Entity.set氏名Small2(RString.EMPTY);
        事業者用Entity.set氏名samabunText(RString.EMPTY);
        事業者用Entity.set氏名samabun1(RString.EMPTY);
        事業者用Entity.set氏名samabun2(RString.EMPTY);
        事業者用Entity.set氏名samabunSmall1(RString.EMPTY);
        事業者用Entity.set氏名samabunSmall2(RString.EMPTY);

        ChohyoSeigyoHanyo 名称付与制御汎用 = load帳票制御汎用(事業者用帳票分類ID, 宛先敬称);
        事業者用Entity.set名称付与1(名称付与制御汎用.get設定値());
        事業者用Entity.set名称付与2(RString.EMPTY);
        事業者用Entity.set様文1(RString.EMPTY);
        事業者用Entity.set様文2(RString.EMPTY);
        事業者用Entity.set括弧Left1(RString.EMPTY);
        事業者用Entity.set括弧Left2(RString.EMPTY);
        事業者用Entity.set括弧Right1(RString.EMPTY);
        事業者用Entity.set括弧Right2(RString.EMPTY);
        事業者用Entity.set文書番号(文書番号);

        ChohyoSeigyoHanyo 帳票制御汎用 = load帳票制御汎用(事業者用帳票分類ID, 帳票タイトル);
        事業者用Entity.setタイトル(帳票制御汎用.get設定値());

        Map<Integer, RString> 通知文情報 = ReportUtil.get通知文(SubGyomuCode.DBC介護給付, 事業者用帳票分類ID, KamokuCode.EMPTY, NUM_1);
        事業者用Entity.set文書1(通知文情報.get(NUM_1));
        事業者用Entity.set被保険者氏名(被保険者情報.get名称漢字().getColumnValue());
        事業者用Entity.set被保険者番号(償還受領委任契約者データ.get被保険者番号());
        事業者用Entity.set受付日(償還受領委任契約者データ.get受付年月日().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.NONE).toDateString());
        事業者用Entity.set承認区分(ShoninKubun.toValue(償還受領委任契約者データ.get承認結果区分()).get名称());
        事業者用Entity.set承認年月日(償還受領委任契約者データ.get決定年月日() == null || 償還受領委任契約者データ.get決定年月日().isEmpty()
                ? RString.EMPTY : 償還受領委任契約者データ.get決定年月日().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.NONE).toDateString());
        事業者用Entity.set不承認理由(ShoninKubun.承認しない.getコード().equals(償還受領委任契約者データ.get承認結果区分())
                ? 償還受領委任契約者データ.get不承認理由() : RString.EMPTY);
        事業者用Entity.set給付の種類(KeiyakuServiceShurui.toValue(償還受領委任契約者データ.get契約サービス種類()).get名称());
        事業者用Entity.set事業所名(受領委任契約事業者データ.get契約事業者名称());
        事業者用Entity.set代表者氏名(受領委任契約事業者データ.get契約代表者氏名());
        事業者用Entity.set事業所郵便番号(受領委任契約事業者データ.get契約事業者郵便番号());
        事業者用Entity.set事業所所在地(受領委任契約事業者データ.get契約事業者住所());
        事業者用Entity.set事業所電話番号(受領委任契約事業者データ.get契約事業者電話番号());
        事業者用Entity.set費用額合計(toDecimal(償還受領委任契約者データ.get費用額合計()));
        事業者用Entity.set保険対象費用額(toDecimal(償還受領委任契約者データ.get保険対象費用額()));
        事業者用Entity.set利用者負担額(toDecimal(償還受領委任契約者データ.get利用者自己負担額()));
        事業者用Entity.set保険給付額(toDecimal(償還受領委任契約者データ.get保険給付費額()));
        事業者用Entity.set文書2(通知文情報.get(NUM_2));
        事業者用Entity.setページ(RString.EMPTY);
    }

    private void set送付物宛先_利用者向け(KaigoKyufuJuryoininKeiyakuTorokuRiyoshaEntity 利用者向けEntity, Association 地方公共団体,
            ChohyoSeigyoKyotsu 帳票利用者向け制御共通, ShikibetsuCode 識別コード) {
        IAtesakiGyomuHanteiKey 宛先業務判定キー
                = AtesakiGyomuHanteiKeyFactory.createInstace(GyomuCode.DB介護保険, SubGyomuCode.DBC介護給付);
        IAtesakiPSMSearchKey searchKey = new AtesakiPSMSearchKeyBuilder(宛先業務判定キー)
                .set識別コード(識別コード)
                .set業務固有キー利用区分(GyomuKoyuKeyRiyoKubun.利用しない)
                .set送付先利用区分(SofusakiRiyoKubun.利用する).build();
        IAtesaki 宛先 = ShikibetsuTaishoService.getAtesakiFinder().get宛先(searchKey);

        if (宛先 != null) {
            EditedAtesaki 編集後宛先 = EditedAtesakiBuilder.create編集後宛先(宛先, 地方公共団体, 帳票利用者向け制御共通);
            SofubutsuAtesakiSource 送付物宛先 = 編集後宛先.getSofubutsuAtesakiSource().get送付物宛先ソース();
            利用者向けEntity.set郵便番号(送付物宛先.yubinNo);
            利用者向けEntity.set行政区(送付物宛先.gyoseiku);
            利用者向けEntity.set住所Text(送付物宛先.jushoText);
            利用者向けEntity.set住所1(送付物宛先.jusho1);
            利用者向けEntity.set住所2(送付物宛先.jusho2);
            利用者向けEntity.set住所3(送付物宛先.jusho3);
            利用者向けEntity.set方書Text(送付物宛先.katagakiText);
            利用者向けEntity.set方書1(送付物宛先.katagaki1);
            利用者向けEntity.set方書2(送付物宛先.katagaki2);
            利用者向けEntity.set方書Small1(送付物宛先.katagakiSmall1);
            利用者向けEntity.set方書Small2(送付物宛先.katagakiSmall2);
            利用者向けEntity.set代納人区分(送付物宛先.dainoKubunMei);
            利用者向けEntity.set氏名Text(送付物宛先.shimeiText);
            利用者向けEntity.set氏名1(送付物宛先.shimei1);
            利用者向けEntity.set氏名2(送付物宛先.shimei2);
            利用者向けEntity.set氏名Small1(送付物宛先.shimeiSmall1);
            利用者向けEntity.set氏名Small2(送付物宛先.shimeiSmall2);
            利用者向けEntity.set氏名samabunText(送付物宛先.samabunShimeiText);
            利用者向けEntity.set氏名samabun1(送付物宛先.samabunShimei1);
            利用者向けEntity.set氏名samabun2(送付物宛先.samabunShimei2);
            利用者向けEntity.set氏名samabunSmall1(送付物宛先.samabunShimeiSmall1);
            利用者向けEntity.set氏名samabunSmall2(送付物宛先.samabunShimeiSmall2);
            利用者向けEntity.set名称付与1(送付物宛先.meishoFuyo1);
            利用者向けEntity.set名称付与2(送付物宛先.meishoFuyo2);
            利用者向けEntity.set様文1(送付物宛先.samaBun1);
            利用者向けEntity.set様文2(送付物宛先.samaBun2);
            利用者向けEntity.set括弧Left1(送付物宛先.kakkoLeft1);
            利用者向けEntity.set括弧Left2(送付物宛先.kakkoLeft2);
            利用者向けEntity.set括弧Right1(送付物宛先.kakkoRight1);
            利用者向けEntity.set括弧Right2(送付物宛先.kakkoRight2);
            利用者向けEntity.setカスタマバーコード(送付物宛先.customerBarCode);
        }
    }

    private ChohyoSeigyoKyotsu load帳票制御共通(ReportId 帳票分類ID) throws NullPointerException {
        requireNonNull(帳票分類ID, UrSystemErrorMessages.値がnull.getReplacedMessage(帳票分類ID.toString()));
        DbT7065ChohyoSeigyoKyotsuEntity entity = 帳票制御共通Dac.selectByKey(SubGyomuCode.DBC介護給付, 帳票分類ID);
        if (entity == null) {
            return null;
        }
        return new ChohyoSeigyoKyotsu(entity);
    }

    private ChohyoSeigyoHanyo load帳票制御汎用(ReportId 帳票分類ID, RString 項目名) {
        requireNonNull(帳票分類ID, UrSystemErrorMessages.値がnull.getReplacedMessage(帳票分類ID.toString()));
        DbT7067ChohyoSeigyoHanyoEntity entity = 帳票制御汎用Dac.get帳票制御汎用(SubGyomuCode.DBC介護給付, 帳票分類ID, 項目名);
        if (entity == null) {
            return null;
        }
        return new ChohyoSeigyoHanyo(entity);
    }

    private RString toDecimal(Decimal decimal) {
        if (decimal == null) {
            return RString.EMPTY;
        }
        return DecimalFormatter.toコンマ区切りRString(decimal, 0);
    }
}
