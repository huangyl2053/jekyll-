/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.kyokaisokanrimasterlistchohyodatasakusei;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.kyokaisogaitosha.KyokaisoGaitoshaMybatisParameter;
import jp.co.ndensan.reams.db.dbu.definition.processprm.kyokaisogaitosha.KyokaisoGaitoshaProcessParameter;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * バッチ設計_DBUMN52001_境界層管理マスタリストのバッチ処理クラスです。
 *
 * @reamsid_L DBU-1050-020 wanghui
 *
 */
public class KyokaisoKanriMasterListBusiness {

    private static final RString 取得モード_1 = new RString("1");
    private static final RString 取得モード_2 = new RString("2");
    private static final RString 取得モード_3 = new RString("3");
    private static final RString 境界層該当申請日名称 = new RString("1");
    private static final RString 境界層該当開始日名称 = new RString("2");
    private static final RString 境界層該当終了日名称 = new RString("3");
    private static final RString 登録されて = new RString("1");
    private static final RString 出力条件_基準日 = new RString("【抽出条件】 基準日で抽出");
    private static final RString 出力条件_範囲 = new RString("【抽出条件】 範囲で抽出");
    private static final RString 出力条件_指定無し = new RString("【抽出条件】 指定無し");
    private static final RString 境界層該当申請日 = new RString("境界層該当申請日");
    private static final RString 境界層該当開始日 = new RString("境界層該当開始日");
    private static final RString 境界層該当終了日 = new RString("境界層該当終了日");
    private static final RString 時点での境界層登録者 = new RString("時点での境界層登録者");
    private static final RString 標準負担額 = new RString("標準負担額の減額情報が登録されている情報");
    private static final RString 給付額減額記載解除 = new RString("給付額減額記載解除情報が登録されている情報");
    private static final RString 特定介護サービス居住費 = new RString("特定介護サービス居住費等負担額の減額情報が登録されている情報");
    private static final RString 特定介護サービス食費負 = new RString("特定介護サービス食費負担額の減額情報が登録されている情報");
    private static final RString 高額介護サービス費世帯 = new RString("高額介護サービス費世帯上限額の減額情報が登録されている情報");
    private static final RString 保険料額 = new RString("保険料額の低減適用情報が登録されている情報");
    private static final RString 出力条件_が = new RString("が");
    private static final RString 出力条件_ = new RString("～");
    private static final RString 境界層該当内容 = new RString("【境界層該当内容】");

    /**
     * MybatisParameterを設定するメッソドです。
     *
     * @param 出力順 出力順
     * @param parameter KyokaisoGaitoshaProcessParameter
     * @return KyokaisoGaitoshaMybatisParameter
     */
    public KyokaisoGaitoshaMybatisParameter createMybatisParameter(RString 出力順, KyokaisoGaitoshaProcessParameter parameter) {
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先));
        key.setデータ取得区分(DataShutokuKubun.直近レコード);
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        KyokaisoGaitoshaMybatisParameter mybatisParameter = parameter.toKyokaisoGaitoshaMybatisParameter();
        KyokaisoGaitoshaMybatisParameter piarameter = KyokaisoGaitoshaMybatisParameter.createParam(
                mybatisParameter.getMode(),
                mybatisParameter.getRange(),
                mybatisParameter.getDate_FROM(),
                mybatisParameter.getDate_TO(),
                mybatisParameter.getIskyuufugakuFlag(),
                mybatisParameter.getIshyojunFutanFlag(),
                mybatisParameter.getIskyojuhinadoFutangFlag(),
                mybatisParameter.getIsshokuhiKeiFlag(),
                mybatisParameter.getIskogakuFlag(),
                mybatisParameter.getIshokenFlag(),
                出力順,
                new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString()));
        return piarameter;
    }

    /**
     * 帳票分類ID「DBU200003_KyokaisoKanriMasterList」（境界層管理マスタリスト）出力順設定可能項目です。
     */
    public enum ShutsuryokujunEnum implements IReportItems {

        /**
         * 行政区コード
         */
        世帯コード(new RString("0008"), new RString("listLower_3"), new RString("\"PSM_setaiCode\"")),
        /**
         * 町域コード
         */
        町域コード(new RString("0002"), new RString("choikiCode"), new RString("\"PSM_choikiCode\"")),
        /**
         * 氏名５０音カナ
         */
        氏名５０音カナ(new RString("0010"), new RString("listUpper_2"), new RString("\"PSM_kanaMeisho\"")),
        /**
         * 住民種別
         */
        住民種別(new RString("0014"), new RString("listUpper_4"), new RString("\"PSM_juminShubetsuCode\"")),
        /**
         * 証記載保険者番号
         */
        性別(new RString("0013"), new RString("listUpper_3"), new RString("\"PSM_seibetsuCode\"")),
        /**
         * 生年月日
         */
        生年月日(new RString("0012"), new RString("listUpper_6"), new RString("\"PSM_seinengappiYMD\"")),
        /**
         * 被保険者番号
         */
        被保険者番号(new RString("0104"), new RString("listUpper_1"), new RString("\"DbT1006Kyo_hihokenshaNo\"")),
        /**
         * 市町村コード
         */
        市町村コード(new RString("0016"), new RString("shichosonCode"), new RString("\"DbT1001Hiho_shichosonCode\"")),
        /**
         * 境界層該当申請日
         */
        境界層該当申請日(new RString("0117"), new RString("listLower_4"), new RString("\"DbT1013Kyo_shinseiYMD\"")),
        /**
         * 境界層該当開始日
         */
        境界層該当開始日(new RString("0118"), new RString("listLower_5"), new RString("\"DbT1006Kyo_tekiyoKaishiYMD\""));
        private final RString 項目ID;
        private final RString フォームフィールド名;
        private final RString myBatis項目名;

        private ShutsuryokujunEnum(RString 項目ID, RString フォームフィールド名, RString myBatis項目名) {
            this.項目ID = 項目ID;
            this.フォームフィールド名 = フォームフィールド名;
            this.myBatis項目名 = myBatis項目名;
        }

        @Override
        public RString get項目ID() {
            return 項目ID;
        }

        @Override
        public RString getフォームフィールド名() {
            return フォームフィールド名;
        }

        @Override
        public RString getMyBatis項目名() {
            return myBatis項目名;
        }
    }

    /**
     * @param parameter KyokaisoGaitoshaProcessParameter
     * @return 出力条件
     */
    public List<RString> contribute(KyokaisoGaitoshaProcessParameter parameter) {
        List<RString> 出力条件 = new ArrayList<>();
        RStringBuilder nituliki = new RStringBuilder();
        if (取得モード_1.equals(parameter.toKyokaisoGaitoshaMybatisParameter().getMode())) {
            nituliki.append(出力条件_基準日);
            if (parameter.toKyokaisoGaitoshaMybatisParameter().getDate_FROM() != null) {
                nituliki.append(parameter.toKyokaisoGaitoshaMybatisParameter().getDate_FROM()
                        .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                        separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
            } else {
                nituliki.append(RString.EMPTY);
            }
            nituliki.append(時点での境界層登録者);
            出力条件.add(nituliki.toRString());
        }
        if ((取得モード_2).equals(parameter.toKyokaisoGaitoshaMybatisParameter().getMode())) {
            nituliki = new RStringBuilder();
            nituliki.append((出力条件_範囲));
            if ((境界層該当申請日名称).equals(parameter.toKyokaisoGaitoshaMybatisParameter().getRange())) {
                nituliki.append(境界層該当申請日);
            }
            if ((境界層該当開始日名称).equals(parameter.toKyokaisoGaitoshaMybatisParameter().getRange())) {
                nituliki.append(境界層該当開始日);
            }
            if ((境界層該当終了日名称).equals(parameter.toKyokaisoGaitoshaMybatisParameter().getRange())) {
                nituliki.append(境界層該当終了日);
            }
            nituliki.append((出力条件_が));
            if (parameter.toKyokaisoGaitoshaMybatisParameter().getDate_FROM() != null) {
                nituliki.append(parameter.toKyokaisoGaitoshaMybatisParameter().getDate_FROM()
                        .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                        separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
            } else {
                nituliki.append(RString.EMPTY);
            }
            nituliki.append((出力条件_));
            if (parameter.toKyokaisoGaitoshaMybatisParameter().getDate_TO() != null) {
                nituliki.append(parameter.toKyokaisoGaitoshaMybatisParameter().getDate_TO()
                        .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                        separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
                出力条件.add(nituliki.toRString());
            } else {
                nituliki.append(RString.EMPTY);
                出力条件.add(nituliki.toRString());
            }

        }
        if ((取得モード_3).equals(parameter.toKyokaisoGaitoshaMybatisParameter().getMode())) {
            nituliki = new RStringBuilder();
            nituliki.append((出力条件_指定無し));
            出力条件.add(nituliki.toRString());
        }
        if ((登録されて).equals(parameter.toKyokaisoGaitoshaMybatisParameter().getIshokenFlag())) {
            出力条件.add((給付額減額記載解除));
        }
        if ((登録されて).equals(parameter.toKyokaisoGaitoshaMybatisParameter().getIshyojunFutanFlag())) {
            出力条件.add((標準負担額));
        }
        if ((登録されて).equals(parameter.toKyokaisoGaitoshaMybatisParameter().getIskogakuFlag())) {
            出力条件.add((特定介護サービス居住費));
        }
        if ((登録されて).equals(parameter.toKyokaisoGaitoshaMybatisParameter().getIskyojuhinadoFutangFlag())) {
            出力条件.add((特定介護サービス食費負));
        }
        if ((登録されて).equals(parameter.toKyokaisoGaitoshaMybatisParameter().getIskyuufugakuFlag())) {
            出力条件.add((高額介護サービス費世帯));
        }
        if ((登録されて).equals(parameter.toKyokaisoGaitoshaMybatisParameter().getIsshokuhiKeiFlag())) {
            出力条件.add((保険料額));
        }
        出力条件.set(1, 境界層該当内容.concat(出力条件.get(1)));
        return 出力条件;
    }
}
