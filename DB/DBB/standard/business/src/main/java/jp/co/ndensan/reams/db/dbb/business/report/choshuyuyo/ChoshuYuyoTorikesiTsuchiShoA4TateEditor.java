/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.choshuyuyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HyojiCodes;
import jp.co.ndensan.reams.db.dbb.entity.report.choshuyuyo.KaigoHokenHokenryoChoshuyoyoTorikeshiTsuchishoA4TateSource;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBBCodeShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.business.core.kaigosofubutsuatesakisource.KaigoSofubutsuAtesakiSource;
import jp.co.ndensan.reams.db.dbz.business.report.parts.kaigotoiawasesaki.CompKaigoToiawasesakiSource;
import jp.co.ndensan.reams.db.dbz.business.report.parts.kaigotoiawasesaki.IKaigoToiawasesakiSourceBuilder;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedAtesaki;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 * 介護保険料徴収猶予取消通知書 A4縦タイプEditorするクラスです。
 *
 * @reamsid_L DBB-0740-070 chenaoqi
 */
public class ChoshuYuyoTorikesiTsuchiShoA4TateEditor implements IChoshuYuyoTorikesiTsuchiShoA4TateEditor {

    private final RString 文書番号;
    private final ChoshuYuyoTorikesiTsuchiShoJoho 徴収猶予取消通知書情報;
    private final RString 通知書定型文;
    private final IKaigoToiawasesakiSourceBuilder 介護問合せ先ソースビルダー;
    private final NinshoshaSource sourceBuilder;
    private final HyojiCodes 表示コード;
    private final List<KibetsuChoshyuYuyoKikan> 期別徴収猶予期間リスト;
    private final List<RString> 期別納期リスト;
    private final List<RString> 随時リスト;
    private final EditedAtesaki 編集後宛先;
    private final int i;
    private static final RString YEAR = new RString("年度");

    /**
     * コンストラクタです。
     *
     * @param 文書番号 RString
     * @param 徴収猶予取消通知書情報 ChoshuYuyoTorikesiTsuchiShoJoho
     * @param 通知書定型文 RString
     * @param 介護問合せ先ソースビルダー IKaigoToiawasesakiSourceBuilder
     * @param sourceBuilder NinshoshaSource
     * @param 表示コード HyojiCodes
     * @param 期別徴収猶予期間リスト List<KibetsuChoshyuYuyoKikan>
     * @param 期別納期リスト List<RString>
     * @param 随時リスト List<RString>
     * @param 編集後宛先 EditedAtesaki
     * @param i int
     */
    public ChoshuYuyoTorikesiTsuchiShoA4TateEditor(
            RString 文書番号,
            ChoshuYuyoTorikesiTsuchiShoJoho 徴収猶予取消通知書情報,
            RString 通知書定型文,
            IKaigoToiawasesakiSourceBuilder 介護問合せ先ソースビルダー,
            NinshoshaSource sourceBuilder,
            HyojiCodes 表示コード,
            List<KibetsuChoshyuYuyoKikan> 期別徴収猶予期間リスト,
            List<RString> 期別納期リスト,
            List<RString> 随時リスト,
            EditedAtesaki 編集後宛先,
            int i) {

        this.文書番号 = 文書番号;
        this.徴収猶予取消通知書情報 = 徴収猶予取消通知書情報;
        this.通知書定型文 = 通知書定型文;
        this.介護問合せ先ソースビルダー = 介護問合せ先ソースビルダー;
        this.sourceBuilder = sourceBuilder;
        this.表示コード = 表示コード;
        this.期別徴収猶予期間リスト = 期別徴収猶予期間リスト;
        this.期別納期リスト = 期別納期リスト;
        this.随時リスト = 随時リスト;
        this.編集後宛先 = 編集後宛先;
        this.i = i;
    }

    @Override
    public KaigoHokenHokenryoChoshuyoyoTorikeshiTsuchishoA4TateSource edit(KaigoHokenHokenryoChoshuyoyoTorikeshiTsuchishoA4TateSource source) {
        source.bunshoNo = 文書番号;
        source.bikoTitle = 通知書定型文;
        source.biko = 通知書定型文;
        set表示コード(source);
        set徴収猶予の情報(source);
        set期別徴収猶予期間リスト(source);
        set編集後宛先(source);
        set認証者ソース(source);
        set介護問合せ先ソースビルダー(source);
        return source;
    }

    private void set表示コード(KaigoHokenHokenryoChoshuyoyoTorikeshiTsuchishoA4TateSource source) {
        if (表示コード != null) {
            source.hyojicodeName1 = 表示コード.get表示コード名１();
            source.hyojicodeName2 = 表示コード.get表示コード名２();
            source.hyojicodeName3 = 表示コード.get表示コード名３();
            source.hyojicode1 = 表示コード.get表示コード１();
            source.hyojicode2 = 表示コード.get表示コード２();
            source.hyojicode3 = 表示コード.get表示コード３();
        }
    }

    private void set徴収猶予の情報(KaigoHokenHokenryoChoshuyoyoTorikeshiTsuchishoA4TateSource source) {
        if (徴収猶予取消通知書情報.get徴収猶予の情報() != null) {
            FlexibleYear 調定年度 = 徴収猶予取消通知書情報.get徴収猶予の情報().get調定年度();
            source.choteiNendo = 調定年度 != null ? 調定年度.wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.ICHI_NEN).toDateString() : RString.EMPTY;
            FlexibleYear 賦課年度 = 徴収猶予取消通知書情報.get徴収猶予の情報().get賦課年度();
            source.fukaNendo = (賦課年度 != null ? 賦課年度.wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.ICHI_NEN).toDateString().concat(YEAR) : RString.EMPTY);
            TsuchishoNo 通知書番号 = 徴収猶予取消通知書情報.get徴収猶予の情報().get通知書番号();
            source.tsuchishoNo = (通知書番号 != null ? 通知書番号.value() : RString.EMPTY);
            SetaiCode 世帯コード = 徴収猶予取消通知書情報.get宛名().get世帯コード();
            source.setaiCode = (世帯コード != null ? 世帯コード.value() : RString.EMPTY);
            HihokenshaNo 被保険者番号 = 徴収猶予取消通知書情報.get徴収猶予の情報().get被保険者番号();
            source.hihokenshaNo = (被保険者番号 != null ? 被保険者番号.value() : RString.EMPTY);
            ShikibetsuCode 識別コード = 徴収猶予取消通知書情報.get徴収猶予の情報().get識別コード();
            source.shikibetsuCode = (識別コード != null ? 識別コード.value() : RString.EMPTY);
            FlexibleDate 取消年月日 = 徴収猶予取消通知書情報.get徴収猶予の情報().get徴収猶予取消年月日();
            source.torikeshiYMD = (取消年月日 != null ? 取消年月日.wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.ICHI_NEN).separator(Separator.JAPANESE)
                    .fillType(FillType.BLANK).toDateString() : RString.EMPTY);
            Code 徴収猶予取消種類コード = 徴収猶予取消通知書情報.get徴収猶予の情報().get徴収猶予取消種類コード();
            RString 取消理由1 = RString.EMPTY;
            if (徴収猶予取消種類コード != null) {
                取消理由1 = CodeMaster.getCodeMeisho(SubGyomuCode.DBB介護賦課, DBBCodeShubetsu.保険料徴収猶予取消種類.getコード(),
                        徴収猶予取消種類コード, FlexibleDate.getNowDate());
            }
            source.torikeshiRiyu1 = 取消理由1;
            source.torikeshiRiyu2 = 徴収猶予取消通知書情報.get徴収猶予の情報().get徴収猶予取消事由();
            //TODO
        }
    }

    private void set期別徴収猶予期間リスト(KaigoHokenHokenryoChoshuyoyoTorikeshiTsuchishoA4TateSource source) {
        if (期別徴収猶予期間リスト != null && !期別徴収猶予期間リスト.isEmpty()) {
            source.listKibetsu_1 = format月と期(期別徴収猶予期間リスト.get(i).get特徴期());
            source.listKibetsu_2 = format月と期(期別徴収猶予期間リスト.get(i).get特徴月());
            source.listKibetsu_3 = 期別徴収猶予期間リスト.get(i).get特徴期別金額();
            source.listKibetsu_4 = format月と期(期別徴収猶予期間リスト.get(i).get普徴期());
            source.listKibetsu_5 = format月と期(期別徴収猶予期間リスト.get(i).get普徴月());
            source.listKibetsu_6 = 期別徴収猶予期間リスト.get(i).get普徴期別金額();
            source.listKibetsu_7 = 期別徴収猶予期間リスト.get(i).get徴収猶予期間();
            source.listZuiji_1 = 随時リスト.get(i);
            if (期別納期リスト != null && !期別納期リスト.isEmpty() && !期別徴収猶予期間リスト.get(i).get徴収猶予期間().isEmpty()) {
                source.listTorikeshiAtoNoki_1 = 期別納期リスト.get(i);
            }
        }
    }

    private RString format月と期(RString value) {
        if (value.isEmpty()) {
            return value;
        }
        return new RString(Integer.valueOf(value.trim().toString())).padLeft(RString.HALF_SPACE, 2);
    }

    private void set編集後宛先(KaigoHokenHokenryoChoshuyoyoTorikeshiTsuchishoA4TateSource source) {
        if (編集後宛先 != null) {
            KaigoSofubutsuAtesakiSource 送付物宛先 = 編集後宛先.getSofubutsuAtesakiSource();
            if (送付物宛先 != null && 送付物宛先.get送付物宛先ソース() != null) {
                source.yubinNo = 送付物宛先.get送付物宛先ソース().yubinNo;
                source.gyoseiku = 送付物宛先.get送付物宛先ソース().gyoseiku;
                source.jusho3 = 送付物宛先.get送付物宛先ソース().jusho3;
                source.jushoText = 送付物宛先.get送付物宛先ソース().jushoText;
                source.jusho1 = 送付物宛先.get送付物宛先ソース().jusho1;
                source.jusho2 = 送付物宛先.get送付物宛先ソース().jusho2;
                source.katagakiText = 送付物宛先.get送付物宛先ソース().katagakiText;
                source.katagaki2 = 送付物宛先.get送付物宛先ソース().katagaki2;
                source.katagakiSmall2 = 送付物宛先.get送付物宛先ソース().katagakiSmall2;
                source.katagaki1 = 送付物宛先.get送付物宛先ソース().katagaki1;
                source.katagakiSmall1 = 送付物宛先.get送付物宛先ソース().katagakiSmall1;
                source.kakkoRight2 = 送付物宛先.get送付物宛先ソース().kakkoRight2;
                source.kakkoRight1 = 送付物宛先.get送付物宛先ソース().kakkoRight1;
                source.shimei2 = 送付物宛先.get送付物宛先ソース().shimei2;
                source.shimeiSmall2 = 送付物宛先.get送付物宛先ソース().shimeiSmall2;
                source.shimeiText = 送付物宛先.get送付物宛先ソース().shimeiText;
                source.meishoFuyo2 = 送付物宛先.get送付物宛先ソース().meishoFuyo2;
                source.shimeiSmall1 = 送付物宛先.get送付物宛先ソース().shimeiSmall1;
                source.dainoKubunMei = 送付物宛先.get送付物宛先ソース().dainoKubunMei;
                source.shimei1 = 送付物宛先.get送付物宛先ソース().shimei1;
                source.meishoFuyo1 = 送付物宛先.get送付物宛先ソース().meishoFuyo1;
                source.samabunShimeiText = 送付物宛先.get送付物宛先ソース().samabunShimeiText;
                source.samabunShimeiSmall2 = 送付物宛先.get送付物宛先ソース().samabunShimeiSmall2;
                source.samaBun2 = 送付物宛先.get送付物宛先ソース().samaBun2;
                source.kakkoLeft2 = 送付物宛先.get送付物宛先ソース().kakkoLeft2;
                source.samabunShimei2 = 送付物宛先.get送付物宛先ソース().samabunShimei2;
                source.kakkoLeft1 = 送付物宛先.get送付物宛先ソース().kakkoLeft1;
                source.samabunShimei1 = 送付物宛先.get送付物宛先ソース().samabunShimei1;
                source.samaBun1 = 送付物宛先.get送付物宛先ソース().samaBun1;
                source.samabunShimeiSmall1 = 送付物宛先.get送付物宛先ソース().samabunShimeiSmall1;
                source.customerBarCode = 送付物宛先.get送付物宛先ソース().customerBarCode;
                // TODO世帯主名 様方
            }
        }
    }

    private void set認証者ソース(KaigoHokenHokenryoChoshuyoyoTorikeshiTsuchishoA4TateSource source) {
        if (sourceBuilder != null) {
            source.denshiKoin = sourceBuilder.denshiKoin;
            source.hakkoYMD = sourceBuilder.hakkoYMD;
            source.ninshoshaYakushokuMei = sourceBuilder.ninshoshaYakushokuMei;
            source.ninshoshaYakushokuMei1 = sourceBuilder.ninshoshaYakushokuMei1;
            source.koinMojiretsu = sourceBuilder.koinMojiretsu;
            source.ninshoshaYakushokuMei2 = sourceBuilder.ninshoshaYakushokuMei2;
            source.ninshoshaShimeiKakenai = sourceBuilder.ninshoshaShimeiKakenai;
            source.ninshoshaShimeiKakeru = sourceBuilder.ninshoshaShimeiKakeru;
            source.koinShoryaku = sourceBuilder.koinShoryaku;
        }
    }

    private void set介護問合せ先ソースビルダー(KaigoHokenHokenryoChoshuyoyoTorikeshiTsuchishoA4TateSource source) {
        if (介護問合せ先ソースビルダー != null) {
            CompKaigoToiawasesakiSource buildSource = 介護問合せ先ソースビルダー.buildSource();
            source.yubinBango = buildSource.yubinBango;
            source.shozaichi = buildSource.shozaichi;
            source.choshaBushoName = buildSource.choshaBushoName;
            source.tantoName = buildSource.tantoName;
            source.naisenNo = buildSource.naisenNo;
            source.naisenLabel = buildSource.naisenLabel;
            source.telNo = buildSource.telNo;
        }
    }
}
