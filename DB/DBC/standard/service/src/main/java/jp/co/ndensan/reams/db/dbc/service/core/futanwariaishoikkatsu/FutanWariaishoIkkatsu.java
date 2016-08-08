/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.futanwariaishoikkatsu;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.processprm.futanwariaishohakko.FutanwariaishoHakkoProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.FutanwariaiShoHakkoIchiranCSVEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.futanwariaishohakko.RiyoshaFutanwariaishoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.futanwariaishohakkoichiran.FutanWariaiShoHakkoIchiranEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.futanwariaishokattokami.FutanWariaiShoKattokamiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.ShichosonCodeYoriShichoson;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedAtesaki;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedKojin;
import jp.co.ndensan.reams.db.dbz.definition.core.futanwariai.FutanwariaiKubun;
import jp.co.ndensan.reams.db.dbz.service.core.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.AtesakiFactory;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.ninshosha.Ninshosha;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.NinshoshaSourceBuilderFactory;
import jp.co.ndensan.reams.ur.urz.definition.core.ninshosha.KenmeiFuyoKubunType;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.ninshosha.NinshoshaFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * ビジネス設計_DBCMNK3001_負担割合証ソースファイル作成（service）
 *
 * @reamsid_L DBC-4990-032 pengxingyi
 */
public class FutanWariaishoIkkatsu {

    private static final RString 交付年月日TITLE = new RString("交付年月日　");
    private static final RString 開始年月日TITLE = new RString("開始年月日　");
    private static final RString 終了年月日TITLE = new RString("終了年月日　");
    private static final RString ZERO = new RString("0");
    private static final RString ONE = new RString("1");
    private static final RString TWO = new RString("2");
    private static final RString 済 = new RString("済");
    private static final RString 事業対象者 = new RString("事業対象者");
    private static final RString 受給者 = new RString("受給者");
    private static final RString 号 = new RString("号");
    private static final RString 時 = new RString("時");
    private static final RString 分 = new RString("分");
    private static final RString 秒 = new RString("秒");
    private static final RString 未発行 = new RString("未発行");
    private static final RString 発行済み = new RString("発行済み");
    private static final RString 全て = new RString("全て");
    private static final RString 全件 = new RString("未発行");
    private static final RString 異動分 = new RString("発行済み");
    private static final RString 新規認定分 = new RString("全て");
    private static final int NUM_ONE = 1;
    private static final int NUM_TWO = 2;
    private static final int NUM_THREE = 3;
    private static final int NUM_FOUR = 4;
    private static final int NUM_FIVE = 5;

    /**
     * 負担割合証ソースデータ取得です。
     *
     * @param 帳票制御共通 帳票制御共通
     * @param imageFolderPath 帳票イメージフォルダパス
     * @param 利用者負担割合証Temp 利用者負担割合証Temp
     * @param 交付年月日 交付年月日
     * @param 連番 連番
     * @return {@link FutanWariaiShoKattokamiEntity}
     */
    public FutanWariaiShoKattokamiEntity getFutanWariaiSourceData(ChohyoSeigyoKyotsu 帳票制御共通, RString imageFolderPath,
            RiyoshaFutanwariaishoTempEntity 利用者負担割合証Temp, RDate 交付年月日, RString 連番) {
        IAtesaki 宛先 = AtesakiFactory.createInstance(利用者負担割合証Temp.get宛先());
        IShikibetsuTaisho 宛名 = ShikibetsuTaishoFactory.createShikibetsuTaisho(利用者負担割合証Temp.get宛名());
        Ninshosha 認証者 = NinshoshaFinderFactory.createInstance().
                get帳票認証者(GyomuCode.DB介護保険, new RString("0001"), FlexibleDate.getNowDate());
        Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
        NinshoshaSource compNinshosha = NinshoshaSourceBuilderFactory.
                createInstance(認証者, 地方公共団体, imageFolderPath, RDate.getNowDate(), 0, false, false, KenmeiFuyoKubunType.付与なし).buildSource();
        EditedAtesaki 編集後宛先 = new EditedAtesaki(宛先, 地方公共団体, 帳票制御共通);
//        SofubutsuAtesakiSource 送付物宛先ソースデータ = 編集後宛先.getSofubutsuAtesakiSource().get送付物宛先ソース();
        SofubutsuAtesakiSource 送付物宛先ソースデータ = null;
        EditedKojin 編集後個人 = new EditedKojin(宛名.to個人(), 帳票制御共通, 地方公共団体);
        return getFutanWariaishoEntitySource(利用者負担割合証Temp, 編集後個人, 交付年月日, compNinshosha, 連番, 送付物宛先ソースデータ);
    }

    private FutanWariaiShoKattokamiEntity getFutanWariaishoEntitySource(RiyoshaFutanwariaishoTempEntity entity, EditedKojin 編集後個人,
            RDate 交付年月日, NinshoshaSource compNinshosha, RString 連番, SofubutsuAtesakiSource 送付物宛先ソースデータ) {

        FutanWariaiShoKattokamiEntity source = new FutanWariaiShoKattokamiEntity();
        source.set交付年月日(交付年月日TITLE.concat(dateFormat基本形１(交付年月日)));
        source.set被保険者番号(entity.get被保台帳().getHihokenshaNo().getColumnValue());
        source.set住所(編集後個人.get編集後住所());
        source.setカナ氏名(編集後個人.get名称().getKana().getColumnValue());
        source.set氏名(編集後個人.get名称().getName().getColumnValue());
        source.set生年月日(編集後個人.get生年月日For帳票());
        source.set性別(編集後個人.get性別());
        source.set負担割合１(entity.get負担割合期間().getFutanWariaiKubun1());
        source.set適用開始年月日１(開始年月日TITLE.concat(dateFormat基本形１(entity.get負担割合期間().getYukoKaishiYMD1())));
        source.set適用終了年月日１(終了年月日TITLE.concat(dateFormat基本形１(entity.get負担割合期間().getYukoShuryoYMD1())));
        source.set負担割合２(entity.get負担割合期間().getFutanWariaiKubun2());
        source.set適用開始年月日２(開始年月日TITLE.concat(dateFormat基本形１(entity.get負担割合期間().getYukoKaishiYMD2())));
        source.set適用終了年月日２(終了年月日TITLE.concat(dateFormat基本形１(entity.get負担割合期間().getYukoShuryoYMD2())));
        ShoKisaiHokenshaNo HokenshaNo = getHokenshaCode(new HihokenshaDaicho(entity.get被保台帳()));
        source.set保険者コード１(HokenshaNo.getColumnValue().substring(0, NUM_ONE));
        source.set保険者コード２(HokenshaNo.getColumnValue().substring(NUM_ONE, NUM_TWO));
        source.set保険者コード３(HokenshaNo.getColumnValue().substring(NUM_TWO, NUM_THREE));
        source.set保険者コード４(HokenshaNo.getColumnValue().substring(NUM_THREE, NUM_FOUR));
        source.set保険者コード５(HokenshaNo.getColumnValue().substring(NUM_FOUR, NUM_FIVE));
        source.set保険者コード６(HokenshaNo.getColumnValue().substring(NUM_FIVE));
        source.set保険者名(compNinshosha.ninshoshaShimeiKakeru);
        source.set保険者電話番号(get電話番号());
        source.set電子公印(compNinshosha.denshiKoin);
        source.set連番(連番);
        source.setOcr連番(連番);
        source.set送付物宛先(送付物宛先ソースデータ);
        return source;
    }

    private RString get電話番号() {
        return BusinessConfig.get(ConfigNameDBU.保険者情報_電話番号, SubGyomuCode.DBU介護統計報告);
    }

    private ShoKisaiHokenshaNo getHokenshaCode(HihokenshaDaicho 被保台帳) {
        List<ShoKisaiHokenshaNo> 証記載保険者番号 = new ArrayList<>();
        LasdecCode 市町村コード = null;
        if (ONE.equals(被保台帳.get広域内住所地特例フラグ())) {
            市町村コード = 被保台帳.get広住特措置元市町村コード();
        } else if (ZERO.equals(被保台帳.get広域内住所地特例フラグ())) {
            市町村コード = 被保台帳.get市町村コード();
        }
        Code 導入形態コード = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務).get導入形態コード();
        if (DonyuKeitaiCode.事務単一.getCode().equals(導入形態コード.getKey())
                || DonyuKeitaiCode.事務構成市町村.getCode().equals(導入形態コード.getKey())) {
            List<KoikiZenShichosonJoho> 市町村情報 = KoikiShichosonJohoFinder.createInstance().koseiShichosonJoho().records();
            return 市町村情報.get(0).get証記載保険者番号();
        } else if (DonyuKeitaiCode.事務広域.getCode().equals(導入形態コード.getKey())) {
            List<ShichosonCodeYoriShichoson> 市町村コードによる市町村情報
                    = KoikiShichosonJohoFinder.createInstance().shichosonCodeYoriShichosonJoho(市町村コード).records();
            return 市町村コードによる市町村情報.get(0).get証記載保険者番号();
        }
        return null;
    }

    /**
     * 負担割合証発行一覧ソースデータ取得です。
     *
     * @param 帳票制御共通 帳票制御共通
     * @param 利用者負担割合証 利用者負担割合証
     * @param param param
     * @param 保険者番号 保険者番号
     * @param 保険者名 保険者名
     * @param ソート順１ ソート順１
     * @param ソート順２ ソート順２
     * @param ソート順３ ソート順３
     * @param ソート順４ ソート順４
     * @param ソート順５ ソート順５
     * @param ページ ページ
     * @param 作成日時 作成日時
     * @param 連番 連番
     * @return FutanWariaiShoHakkoIchiranEntity
     */
    public FutanWariaiShoHakkoIchiranEntity getHakkoIchiranSourceData(ChohyoSeigyoKyotsu 帳票制御共通,
            RiyoshaFutanwariaishoTempEntity 利用者負担割合証, FutanwariaishoHakkoProcessParameter param, RString 保険者番号,
            RString 保険者名, RString ソート順１, RString ソート順２, RString ソート順３, RString ソート順４, RString ソート順５,
            RString ページ, RDateTime 作成日時, RString 連番) {
        IAtesaki 宛先 = AtesakiFactory.createInstance(利用者負担割合証.get宛先());
        IShikibetsuTaisho 宛名 = ShikibetsuTaishoFactory.createShikibetsuTaisho(利用者負担割合証.get宛名());
        Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
        EditedAtesaki 編集後宛先 = new EditedAtesaki(宛先, 地方公共団体, 帳票制御共通);
        EditedKojin 編集後個人 = new EditedKojin(宛名.to個人(), 帳票制御共通, 地方公共団体);
        FutanWariaiShoHakkoIchiranEntity source = new FutanWariaiShoHakkoIchiranEntity();
        source.set年度(dateFormatパターン107(param.get年度()));
        source.set条件(param.get出力対象());
        if (ZERO.equals(param.get出力対象())) {
            source.set条件(全件);
        } else if (ONE.equals(param.get出力対象())) {
            source.set条件(異動分);
        } else if (TWO.equals(param.get出力対象())) {
            source.set条件(新規認定分);
        }
        source.set抽出対象期間開始(format日時(param.get抽出期間開始日時()));
        source.set抽出対象期間終了(format日時(param.get抽出期間終了日時()));
        if (ZERO.equals(param.get発行区分())) {
            source.set発行区分(未発行);
        } else if (ONE.equals(param.get発行区分())) {
            source.set発行区分(発行済み);
        } else if (TWO.equals(param.get発行区分())) {
            source.set発行区分(全て);
        }
        source.set交付日(dateFormat基本形１(param.get交付年月日()));
        source.set保険者番号(保険者番号);
        source.set保険者名(保険者名);
        source.setソート順１(ソート順１);
        source.setソート順２(ソート順２);
        source.setソート順３(ソート順３);
        source.setソート順４(ソート順４);
        source.setソート順５(ソート順５);
        source.setページ(ページ);
        source.set作成日時(format日時(作成日時));
        source.set連番(連番);
        source.set被保険者番号(利用者負担割合証.get被保台帳().getHihokenshaNo().getColumnValue());
//        source.set送付先住所(編集後宛先.get編集後住所());
        source.set被保険者氏名(編集後個人.get名称().getName().getColumnValue());
        source.set判定日(dateFormat基本形１(利用者負担割合証.get利用者負担割合().getHanteiYMD()));
        if (利用者負担割合証.get負担割合期間().getYukoKaishiYMD2() != null) {
            source.set開始年月日(dateFormat基本形１(利用者負担割合証.get負担割合期間().getYukoKaishiYMD2()));
        } else {
            source.set開始年月日(dateFormat基本形１(利用者負担割合証.get負担割合期間().getYukoKaishiYMD1()));
        }
        if (利用者負担割合証.get負担割合期間().getYukoShuryoYMD2() != null) {
            source.set終了年月日(dateFormat基本形１(利用者負担割合証.get負担割合期間().getYukoShuryoYMD2()));
        } else {
            source.set終了年月日(dateFormat基本形１(利用者負担割合証.get負担割合期間().getYukoShuryoYMD1()));
        }
        if (!RString.isNullOrEmpty(利用者負担割合証.get負担割合期間().getFutanWariaiKubun2())) {
            source.set負担割合(FutanwariaiKubun.toValue(利用者負担割合証.get負担割合期間().getFutanWariaiKubun2()).get名称());
        } else {
            source.set負担割合(FutanwariaiKubun.toValue(利用者負担割合証.get負担割合期間().getFutanWariaiKubun1()).get名称());
        }
        source.set判定区分(利用者負担割合証.get利用者負担割合().getHanteiKubun());
        if (ZERO.equals(利用者負担割合証.get利用者負担割合().getHakoKubun())) {
            source.set発行済(RString.EMPTY);
        } else {
            source.set発行済(済);
        }
        getHokenshaCode(new HihokenshaDaicho(利用者負担割合証.get被保台帳()));
        return source;
    }

    /**
     * 負担割合証発行一覧CSVデータ取得です。
     *
     * @param 帳票制御共通 帳票制御共通
     * @param 利用者負担割合証Temp 利用者負担割合証Temp
     * @param 連番 連番
     * @return FutanwariaiShoHakkoIchiranCSVEntity
     */
    public FutanwariaiShoHakkoIchiranCSVEntity getHakkoIchiranCSVData(ChohyoSeigyoKyotsu 帳票制御共通,
            RiyoshaFutanwariaishoTempEntity 利用者負担割合証Temp, RString 連番) {
        IAtesaki 宛先 = AtesakiFactory.createInstance(利用者負担割合証Temp.get宛先());
        IShikibetsuTaisho 宛名 = ShikibetsuTaishoFactory.createShikibetsuTaisho(利用者負担割合証Temp.get宛名());
        Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
        EditedAtesaki 編集後宛先 = new EditedAtesaki(宛先, 地方公共団体, 帳票制御共通);
        EditedKojin 編集後個人 = new EditedKojin(宛名.to個人(), 帳票制御共通, 地方公共団体);
        FutanwariaiShoHakkoIchiranCSVEntity csvEntity = new FutanwariaiShoHakkoIchiranCSVEntity();
        csvEntity.set連番(連番);
        csvEntity.set被保険者番号(利用者負担割合証Temp.get被保台帳().getHihokenshaNo().getColumnValue());
        //       csvEntity.set送付先住所(編集後宛先.get編集後住所());
        csvEntity.set被保険者氏名(編集後個人.get名称().getName().getColumnValue());
        csvEntity.set判定日(dateFormat基本形１(利用者負担割合証Temp.get利用者負担割合().getHanteiYMD()));
        if (利用者負担割合証Temp.get負担割合期間().getYukoKaishiYMD2() != null) {
            csvEntity.set開始年月日(dateFormat基本形１(利用者負担割合証Temp.get負担割合期間().getYukoKaishiYMD2()));
        } else {
            csvEntity.set開始年月日(dateFormat基本形１(利用者負担割合証Temp.get負担割合期間().getYukoKaishiYMD1()));
        }
        if (利用者負担割合証Temp.get負担割合期間().getYukoShuryoYMD2() != null) {
            csvEntity.set開始年月日(dateFormat基本形１(利用者負担割合証Temp.get負担割合期間().getYukoShuryoYMD2()));
        } else {
            csvEntity.set開始年月日(dateFormat基本形１(利用者負担割合証Temp.get負担割合期間().getYukoShuryoYMD1()));
        }
        if (!RString.isNullOrEmpty(利用者負担割合証Temp.get負担割合期間().getFutanWariaiKubun2())) {
            csvEntity.set負担割合(FutanwariaiKubun.toValue(利用者負担割合証Temp.get負担割合期間().getFutanWariaiKubun2()).get名称());
        } else {
            csvEntity.set負担割合(FutanwariaiKubun.toValue(利用者負担割合証Temp.get負担割合期間().getFutanWariaiKubun1()).get名称());
        }
        csvEntity.set判定区分(利用者負担割合証Temp.get利用者負担割合().getHanteiKubun());
        if (ZERO.equals(利用者負担割合証Temp.get利用者負担割合().getHakoKubun())) {
            csvEntity.set発行済(RString.EMPTY);
        } else {
            csvEntity.set発行済(済);
        }
        if (ONE.equals(利用者負担割合証Temp.get事業対象者受給者区分())) {
            csvEntity.set事業対象者受給者区分(事業対象者);
        } else if (TWO.equals(利用者負担割合証Temp.get事業対象者受給者区分())) {
            csvEntity.set事業対象者受給者区分(受給者);
        }
        if (!RString.isNullOrEmpty(利用者負担割合証Temp.get負担割合期間().getShikakuKubun2())) {
            csvEntity.set事業対象者受給者区分(利用者負担割合証Temp.get負担割合期間().getShikakuKubun2().concat(号));
        } else {
            csvEntity.set事業対象者受給者区分(利用者負担割合証Temp.get負担割合期間().getShikakuKubun1().concat(号));
        }
        csvEntity.set証記載保険者番号(getHokenshaCode(new HihokenshaDaicho(利用者負担割合証Temp.get被保台帳())).getColumnValue());
        return csvEntity;
    }

    private RString dateFormat基本形１(RDate date) {
        if (date == null) {
            return RString.EMPTY;
        }
        return date.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
    }

    private RString dateFormat基本形１(FlexibleDate date) {
        if (date == null) {
            return RString.EMPTY;
        }
        return date.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
    }

    private RString dateFormatパターン107(FlexibleYear nendo) {
        if (nendo == null) {
            return RString.EMPTY;
        }
        return nendo.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).toDateString();
    }

    private RString format日時(RDateTime 作成日時) {

        RStringBuilder dateTime = new RStringBuilder();

        dateTime.append(作成日時.getDate().wareki().
                eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.BLANK).toDateString());
        dateTime.append("　");
        dateTime.append(new RString(new Decimal(作成日時.getHour()).toString("00")));
        dateTime.append(時);
        dateTime.append(new RString(new Decimal(作成日時.getMinute()).toString("00")));
        dateTime.append(分);
        dateTime.append(new RString(new Decimal(作成日時.getSecond()).toString("00")));
        dateTime.append(秒);

        return dateTime.toRString();
    }
}
