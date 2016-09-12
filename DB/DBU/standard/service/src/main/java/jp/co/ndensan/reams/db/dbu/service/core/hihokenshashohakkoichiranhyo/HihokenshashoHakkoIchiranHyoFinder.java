/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.service.core.hihokenshashohakkoichiranhyo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.hihokenshasho.IkkatsuHakkoRelateEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.hihokenshashohakkoichiranhyo.IchiranyoShohakkoshaEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBACodeShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7060KaigoJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7060KaigoJigyoshaDac;
import jp.co.ndensan.reams.db.dbz.definition.core.chohyo.kyotsu.JushoHenshuChoikiHenshuHoho;
import jp.co.ndensan.reams.db.dbz.definition.core.chohyo.kyotsu.JushoHenshuKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.shisetsushurui.ShisetsuType;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun99;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1005KaigoJogaiTokureiTaishoShisetsuEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7065ChohyoSeigyoKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1005KaigoJogaiTokureiTaishoShisetsuDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7065ChohyoSeigyoKyotsuDac;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.AgeCalculator;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.IDateOfBirth;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth._DateOfBirth;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.AgeArrivalDay;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.definition.core.jusho.KannaiKangaiKubunType;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMasterNoOption;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 被保険者証発行一覧表のビジネスクラスです。
 *
 * @reamsid_L DBU-0420-050 wangchao
 */
public class HihokenshashoHakkoIchiranHyoFinder {

    private static final FlexibleDate 有効期間2009年04月 = new FlexibleDate(2009, 4, 1);
    private static final FlexibleDate 有効期間2006年04月 = new FlexibleDate(2006, 4, 1);
    private static final FlexibleDate 有効期間2002年04月 = new FlexibleDate(2002, 4, 1);
    private static final FlexibleDate 有効期間2000年04月 = new FlexibleDate(2000, 4, 1);
    private static final RString タイトル = new RString("介護保険　被保険者証一覧表");
    private static final RString 作成 = new RString("作成");
    private static final RString 分割線 = new RString("～");
    private static final RString 半角スペース = new RString(" ");
    private static final RString 全角スペース = new RString("　");
    private static final RString 計画事業所名_自己作成 = new RString("自己作成");
    private static final RString 交付事由_非交付理由タイトル_交付事由 = new RString("交付事由");
    private static final RString 交付事由_非交付理由タイトル_非交付事由 = new RString("非交付事由");
    private static final RString 括弧右 = new RString(")");
    private static final RString 括弧左 = new RString("(");
    private static final RString 住所_番地 = new RString("1");
    private static final RString 行政区_番地 = new RString("2");
    private static final RString 住所_番地_行政区 = new RString("3");
    private static final RString 番地のみ = new RString("4");
    private static final RString 表示無し_住所は印字しない = new RString("5");
    private static final RString 帳票ID_被保険者証 = new RString("DBA100001_Hihokenshasho");
    private static final RString 受給者台帳 = new RString("1");
    private static final RString 総合事業対象者 = new RString("2");
    private static final int INDEX_0 = 0;
    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 3;

    /**
     * コンストラクタのクラスです。
     *
     */
    public HihokenshashoHakkoIchiranHyoFinder() {
    }

    /**
     * 被保険者証発行一覧表Entity作成
     *
     * @param 交付日 交付日
     * @param inEntityList List<被保険者証一覧表Entity>
     * @param 出力順Map 出力順Map
     * @param 改頁Map 改頁Map
     * @return 被保険者証一覧表編集クラス
     */
    public List<IchiranyoShohakkoshaEntity> createHihokenshashoHakkoIchiranHyo(FlexibleDate 交付日,
            List<IkkatsuHakkoRelateEntity> inEntityList, Map<Integer, ISetSortItem> 出力順Map, Map<Integer, RString> 改頁Map) {
        List<IchiranyoShohakkoshaEntity> outEntitylist = new ArrayList<>();

        if (!inEntityList.isEmpty()) {
            outEntitylist = createHihokenshashoHakkoIchiranHyoDataあり(交付日, inEntityList, 出力順Map, 改頁Map);
            if (outEntitylist.isEmpty()) {
                outEntitylist.add(createHihokenshashoHakkoIchiranHyoDataなし(出力順Map));
            }
        } else {
            outEntitylist.add(createHihokenshashoHakkoIchiranHyoDataなし(出力順Map));
        }
        return outEntitylist;
    }

    private List<IchiranyoShohakkoshaEntity> createHihokenshashoHakkoIchiranHyoDataあり(FlexibleDate 交付日,
            List<IkkatsuHakkoRelateEntity> inEntityList, Map<Integer, ISetSortItem> 出力順Map,
            Map<Integer, RString> 改頁Map) {
        List<IchiranyoShohakkoshaEntity> outEntitylist = new ArrayList<>();
        for (int i = 0; i < inEntityList.size(); i++) {
            IchiranyoShohakkoshaEntity ichiranyoShohakkoshaEntity = new IchiranyoShohakkoshaEntity();
            IkkatsuHakkoRelateEntity ikkatsuHakkoRelateEntity = inEntityList.get(i);
            RString システム年日日 = new RString(RDate.getNowDateTime().getDate().wareki().eraType(EraType.KANJI).firstYear(
                    FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString().toString());
            RString システム時分秒 = RDate.getNowDateTime().getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒);

            ichiranyoShohakkoshaEntity.set作成日付(システム年日日.concat(システム時分秒).concat(作成));
            ichiranyoShohakkoshaEntity.setタイトル部分(タイトル);
            ichiranyoShohakkoshaEntity.set保険者番号(DbBusinessConfig.get(
                    ConfigNameDBU.保険者情報_保険者番号, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告));
            IAssociationFinder finder = AssociationFinderFactory.createInstance();
            Association association = finder.getAssociation();
            if (association != null) {
                ichiranyoShohakkoshaEntity.set保険者名(association.get市町村名());
            }
            setソート順と改頁キー(ichiranyoShohakkoshaEntity, 出力順Map, 改頁Map);
            if (!ikkatsuHakkoRelateEntity.isShisetyuJotaiFlag()) {
                ichiranyoShohakkoshaEntity.set帳票連番(new RString(Integer.valueOf(i + 1).toString()));
            } else {
                ichiranyoShohakkoshaEntity.set帳票連番(RString.EMPTY);
            }
            if (ikkatsuHakkoRelateEntity.getHihokenshaNo() != null && ikkatsuHakkoRelateEntity.getHihokenshaNo().isEmpty()) {
                ichiranyoShohakkoshaEntity.set被保険者番号(HihokenshaNo.EMPTY);
            } else {
                ichiranyoShohakkoshaEntity.set被保険者番号(ikkatsuHakkoRelateEntity.getHihokenshaNo());
            }
            if (ikkatsuHakkoRelateEntity.getMeisho() != null && !ikkatsuHakkoRelateEntity.getMeisho().isEmpty()) {
                ichiranyoShohakkoshaEntity.set氏名(new RString(ikkatsuHakkoRelateEntity.getMeisho().toString()));
            } else {
                ichiranyoShohakkoshaEntity.set氏名(RString.EMPTY);
            }
            if (ikkatsuHakkoRelateEntity.getSeinengappiYMD() != null) {
                ichiranyoShohakkoshaEntity.set生年月日_年齢(set生年月日_年齢(交付日, ikkatsuHakkoRelateEntity));
            } else {
                ichiranyoShohakkoshaEntity.set生年月日_年齢(RString.EMPTY);
            }
            ichiranyoShohakkoshaEntity.set送付先住所(set送付先住所(ikkatsuHakkoRelateEntity));
            ichiranyoShohakkoshaEntity.set要介護(set要介護(ikkatsuHakkoRelateEntity));
            ichiranyoShohakkoshaEntity.set認定開始日_認定終了日(set認定開始日_認定終了日(ikkatsuHakkoRelateEntity));
            DbT7060KaigoJigyoshaDac dbT7060Dac = InstanceProvider.create(DbT7060KaigoJigyoshaDac.class);
            if (ShisetsuType.介護保険施設.getコード().equals(ikkatsuHakkoRelateEntity.getNyushoShisetsuShurui())) {
                List<DbT7060KaigoJigyoshaEntity> dbT7060EntityList = new ArrayList<>();
                if (!ikkatsuHakkoRelateEntity.getNyushoShisetsuCode().isEmpty()) {
                    dbT7060EntityList = dbT7060Dac.select事業者名称(ikkatsuHakkoRelateEntity.getNyushoShisetsuCode());
                }
                if (!dbT7060EntityList.isEmpty()) {
                    ichiranyoShohakkoshaEntity.set施設名(new RString(dbT7060EntityList.get(0).getJigyoshaName().toString()));
                }
            }
            if (ShisetsuType.住所地特例対象施設.getコード().equals(ikkatsuHakkoRelateEntity.getNyushoShisetsuShurui())) {
                List<DbT1005KaigoJogaiTokureiTaishoShisetsuEntity> dbT1005EntityList = new ArrayList<>();
                if (!ikkatsuHakkoRelateEntity.getNyushoShisetsuCode().isEmpty()) {
                    DbT1005KaigoJogaiTokureiTaishoShisetsuDac dbT1005Dac = InstanceProvider.create(DbT1005KaigoJogaiTokureiTaishoShisetsuDac.class);
                    dbT1005EntityList = dbT1005Dac.select事業者名称(ikkatsuHakkoRelateEntity.getNyushoShisetsuCode());
                }
                if (!dbT1005EntityList.isEmpty()) {
                    ichiranyoShohakkoshaEntity.set施設名(new RString(dbT1005EntityList.get(0).getJigyoshaMeisho().toString()));
                }
            }
            if (null != ikkatsuHakkoRelateEntity.getKeikakuJigyoshaNo()) {
                List<DbT7060KaigoJigyoshaEntity> dbT7060EntityList
                        = dbT7060Dac.select事業者名称(ikkatsuHakkoRelateEntity.getKeikakuJigyoshaNo());
                if (!dbT7060EntityList.isEmpty()) {
                    ichiranyoShohakkoshaEntity.set計画事業所名(new RString(dbT7060EntityList.get(0).getJigyoshaName().toString()));
                }
            } else {
                ichiranyoShohakkoshaEntity.set計画事業所名(計画事業所名_自己作成);
            }
            set交付事由(ichiranyoShohakkoshaEntity, ikkatsuHakkoRelateEntity);
            outEntitylist.add(ichiranyoShohakkoshaEntity);
        }
        return outEntitylist;
    }

    private void set交付事由(IchiranyoShohakkoshaEntity ichiranyoShohakkoshaEntity, IkkatsuHakkoRelateEntity ikkatsuHakkoRelateEntity) {
        if (!ikkatsuHakkoRelateEntity.isShisetyuJotaiFlag()) {
            is申請中状態フラグ(ichiranyoShohakkoshaEntity, ikkatsuHakkoRelateEntity);
        } else {
            ichiranyoShohakkoshaEntity.set交付事由_非交付理由タイトル(交付事由_非交付理由タイトル_非交付事由);
            ichiranyoShohakkoshaEntity.set交付_非交付事由(new RString("申請中"));
        }
    }

    private void is申請中状態フラグ(IchiranyoShohakkoshaEntity ichiranyoShohakkoshaEntity, IkkatsuHakkoRelateEntity ikkatsuHakkoRelateEntity) {
        ichiranyoShohakkoshaEntity.set交付事由_非交付理由タイトル(交付事由_非交付理由タイトル_交付事由);
        if (new RString("1").equals(ikkatsuHakkoRelateEntity.getJukyuKubun())) {
            RString 交付事由 = CodeMasterNoOption.getCodeMeisho(
                    SubGyomuCode.DBA介護資格, new CodeShubetsu("0002"), new Code("02"), new FlexibleDate(RDate.getNowDate().toString()));
            if (交付事由.isEmpty()) {
                交付事由 = new RString("02");
            }
            ichiranyoShohakkoshaEntity.set交付_非交付事由(交付事由);
        } else if ((new RString("2").equals(ikkatsuHakkoRelateEntity.getHihokennshaKubunCode())
                && (!RString.isNullOrEmpty(new RString(ikkatsuHakkoRelateEntity.getShikakuShutokuYMD().toString())))
                && (!RString.isNullOrEmpty(new RString(ikkatsuHakkoRelateEntity.getShikakuSoshitsuYMD().toString()))))
                || (RString.isNullOrEmpty(ikkatsuHakkoRelateEntity.getHihokenshaNo().getColumnValue()))) {
            RString 交付事由 = CodeMasterNoOption.getCodeRyakusho(SubGyomuCode.DBA介護資格, DBACodeShubetsu.被保険者証交付事由.getコード(),
                    new Code("01"), new FlexibleDate(RDate.getNowDate().toString()));
            if (交付事由.isEmpty()) {
                交付事由 = new RString("01");
            }
            ichiranyoShohakkoshaEntity.set交付_非交付事由(交付事由);
        } else {
            Code 被保険者証交付事由 = Code.EMPTY;
            if (!RString.isNullOrEmpty(ikkatsuHakkoRelateEntity.getIdoJiyuCode())) {
                被保険者証交付事由 = new Code(ikkatsuHakkoRelateEntity.getIdoJiyuCode());
            }
            RString 交付事由 = CodeMasterNoOption.getCodeRyakusho(SubGyomuCode.DBA介護資格, DBACodeShubetsu.被保険者証交付事由.getコード(),
                    被保険者証交付事由, new FlexibleDate(RDate.getNowDate().toString()));
            if (交付事由.isEmpty()) {
                交付事由 = ikkatsuHakkoRelateEntity.getIdoJiyuCode();
            }
            ichiranyoShohakkoshaEntity.set交付_非交付事由(交付事由);
        }
    }

    private void setソート順と改頁キー(IchiranyoShohakkoshaEntity ichiranyoShohakkoshaEntity,
            Map<Integer, ISetSortItem> 出力順Map, Map<Integer, RString> 改頁Map) {
        ichiranyoShohakkoshaEntity.setソート順１(RString.EMPTY);
        ichiranyoShohakkoshaEntity.setソート順２(RString.EMPTY);
        ichiranyoShohakkoshaEntity.setソート順３(RString.EMPTY);
        ichiranyoShohakkoshaEntity.setソート順４(RString.EMPTY);
        ichiranyoShohakkoshaEntity.setソート順５(RString.EMPTY);
        if (出力順Map.get(INDEX_0) != null) {
            ichiranyoShohakkoshaEntity.setソート順１(出力順Map.get(INDEX_0).get項目名());
        }
        if (出力順Map.get(INDEX_1) != null) {
            ichiranyoShohakkoshaEntity.setソート順２(出力順Map.get(INDEX_1).get項目名());
        }
        if (出力順Map.get(INDEX_2) != null) {
            ichiranyoShohakkoshaEntity.setソート順３(出力順Map.get(INDEX_2).get項目名());
        }
        if (出力順Map.get(INDEX_3) != null) {
            ichiranyoShohakkoshaEntity.setソート順４(出力順Map.get(INDEX_3).get項目名());
        }
        if (出力順Map.get(INDEX_4) != null) {
            ichiranyoShohakkoshaEntity.setソート順５(出力順Map.get(INDEX_4).get項目名());
        }
        ichiranyoShohakkoshaEntity.set改頁１(改頁Map.get(INDEX_0));
        ichiranyoShohakkoshaEntity.set改頁２(改頁Map.get(INDEX_1));
        ichiranyoShohakkoshaEntity.set改頁３(改頁Map.get(INDEX_2));
        ichiranyoShohakkoshaEntity.set改頁４(改頁Map.get(INDEX_3));
        ichiranyoShohakkoshaEntity.set改頁５(改頁Map.get(INDEX_4));
    }

    private RString set生年月日_年齢(FlexibleDate 交付日, IkkatsuHakkoRelateEntity ikkatsuHakkoRelateEntity) {

        RString 生年月日_年齢 = RString.EMPTY;
        IDateOfBirth dateOfBirth = new _DateOfBirth(new FlexibleDate(ikkatsuHakkoRelateEntity.getSeinengappiYMD().toString()));
        AgeCalculator agecalculator = new AgeCalculator(dateOfBirth, JuminJotai.toValue(ikkatsuHakkoRelateEntity.getJuminJotaiCode()),
                FlexibleDate.MAX, AgeArrivalDay.前日, 交付日);
        RString 年齢 = agecalculator.get年齢();
        if (null != 年齢 && !年齢.isEmpty()) {
            if (1 == 年齢.length()) {
                年齢 = 半角スペース.concat(半角スペース).concat(年齢);
            } else if (2 == 年齢.length()) {
                年齢 = 半角スペース.concat(年齢);
            }

            if (JuminShubetsu.日本人.getCode().equals(ikkatsuHakkoRelateEntity.getKannaiKangaiKubun())
                    || JuminShubetsu.住登外個人_日本人.getCode().equals(ikkatsuHakkoRelateEntity.getKannaiKangaiKubun())) {
                RString 生年月日 = new FlexibleDate(ikkatsuHakkoRelateEntity.getSeinengappiYMD().toString()).wareki().eraType(
                        EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
                生年月日_年齢 = 生年月日.concat(半角スペース.concat(年齢));

            } else if (JuminShubetsu.外国人.getCode().equals(ikkatsuHakkoRelateEntity.getKannaiKangaiKubun())
                    || JuminShubetsu.住登外個人_外国人.getCode().equals(ikkatsuHakkoRelateEntity.getKannaiKangaiKubun())) {
                RString 生年月日 = new FlexibleDate(ikkatsuHakkoRelateEntity.getSeinengappiYMD().toString()).seireki().separator(
                        Separator.PERIOD).fillType(FillType.BLANK).toDateString();
                生年月日_年齢 = 生年月日.concat(半角スペース.concat(年齢));
            }
        }
        return 生年月日_年齢;
    }

    private RString set送付先住所(IkkatsuHakkoRelateEntity ikkatsuHakkoRelateEntity) {

        RString 送付先住所 = RString.EMPTY;
        RString 住所 = RString.EMPTY;
        RString 番地 = RString.EMPTY;
        RString 方書 = RString.EMPTY;
        RString 行政区名 = RString.EMPTY;
        if (ikkatsuHakkoRelateEntity.getJuminJotaiCode() != null && !ikkatsuHakkoRelateEntity.getJuminJotaiCode().isEmpty()) {
            住所 = new RString(ikkatsuHakkoRelateEntity.getJuminJotaiCode().toString());
        }
        if (ikkatsuHakkoRelateEntity.getJuminShubetsuCode() != null && !ikkatsuHakkoRelateEntity.getJuminShubetsuCode().isEmpty()) {
            番地 = new RString(ikkatsuHakkoRelateEntity.getJuminShubetsuCode().toString());
        }
        if (ikkatsuHakkoRelateEntity.getKatagaki() != null && !ikkatsuHakkoRelateEntity.getKatagaki().isEmpty()) {
            方書 = new RString(ikkatsuHakkoRelateEntity.getKatagaki().toString());
        }
        if (ikkatsuHakkoRelateEntity.getJuminShubetsuCode() != null && !ikkatsuHakkoRelateEntity.getJuminShubetsuCode().isEmpty()) {
            行政区名 = new RString(ikkatsuHakkoRelateEntity.getJuminShubetsuCode().toString());
        }
        if (KannaiKangaiKubunType.管外.code().equals(ikkatsuHakkoRelateEntity.getKannaiKangaiKubun())) {
            送付先住所 = 住所.concat(番地).concat(全角スペース).concat(方書);

        } else if (KannaiKangaiKubunType.管内.code().equals(ikkatsuHakkoRelateEntity.getKannaiKangaiKubun())) {
            DbT7065ChohyoSeigyoKyotsuDac dbT7065Dac = InstanceProvider.create(DbT7065ChohyoSeigyoKyotsuDac.class
            );
            DbT7065ChohyoSeigyoKyotsuEntity dbT7065Entity = dbT7065Dac.selectByKey(SubGyomuCode.DBA介護資格, new ReportId(帳票ID_被保険者証));
            if (dbT7065Entity
                    != null) {
                送付先住所 = set送付先住所の管内(dbT7065Entity, 住所, 番地, 方書, 行政区名);
            }
        }
        return 送付先住所;
    }

    private RString set送付先住所の管内(DbT7065ChohyoSeigyoKyotsuEntity dbT7065Entity, RString 住所, RString 番地, RString 方書, RString 行政区名) {
        RString 送付先住所 = RString.EMPTY;
        IAssociationFinder finder = AssociationFinderFactory.createInstance();
        Association association = finder.getAssociation();
        RString 都道府県名 = association.get都道府県名();
        RString 郡名 = association.get郡名();
        RString 市町村名 = association.get市町村名();

        if (JushoHenshuKubun.帳票独自.getコード().equals(dbT7065Entity.getJushoHenshuKubun())) {
            set送付先住所の管内の帳票独自(dbT7065Entity, 住所, 番地, 方書, 都道府県名, 郡名, 市町村名, 行政区名);
        } else if (JushoHenshuKubun.市町村共通.getコード().equals(dbT7065Entity.getJushoHenshuKubun())) {
            set送付先住所の管内の市町村共通(住所, 番地, 方書, 都道府県名, 郡名, 市町村名, 行政区名);
        }
        return 送付先住所;
    }

    private RString set送付先住所の管内の帳票独自(DbT7065ChohyoSeigyoKyotsuEntity dbT7065Entity,
            RString 住所, RString 番地, RString 方書, RString 都道府県名, RString 郡名, RString 市町村名, RString 行政区名) {

        RString 送付先住所 = RString.EMPTY;
        if (dbT7065Entity.getJushoHenshuTodoufukenMeiHyojiUmu()) {
            送付先住所 = 送付先住所.concat(都道府県名);
        }
        if (dbT7065Entity.getJushoHenshuGunMeiHyojiUmu()) {
            送付先住所 = 送付先住所.concat(郡名);
        }
        if (dbT7065Entity.getJushoHenshuShichosonMeiHyojiUmu()) {
            送付先住所 = 送付先住所.concat(市町村名);
        }
        if (JushoHenshuChoikiHenshuHoho.住所足す番地.getコード().equals(dbT7065Entity.getJushoHenshuChoikiHenshuHoho())) {
            送付先住所 = 送付先住所.concat(住所.concat(番地));
        } else if (JushoHenshuChoikiHenshuHoho.行政区足す番地.getコード().equals(dbT7065Entity.getJushoHenshuChoikiHenshuHoho())) {
            送付先住所 = 送付先住所.concat(行政区名.concat(番地));
        } else if (JushoHenshuChoikiHenshuHoho.住所足す番地_行政区.getコード().equals(dbT7065Entity.getJushoHenshuChoikiHenshuHoho())) {
            送付先住所 = 送付先住所.concat(住所).concat(番地).concat(括弧左).concat(行政区名).concat(括弧右);
        } else if (JushoHenshuChoikiHenshuHoho.番地のみ.getコード().equals(dbT7065Entity.getJushoHenshuChoikiHenshuHoho())) {
            送付先住所 = 送付先住所.concat(番地);
        } else if (JushoHenshuChoikiHenshuHoho.表示なし_住所は印字しない.getコード().equals(dbT7065Entity.getJushoHenshuChoikiHenshuHoho())) {
            送付先住所 = 送付先住所.concat(RString.EMPTY);
        }
        if (dbT7065Entity.getJushoHenshuKatagakiHyojiUmu()
                && !JushoHenshuChoikiHenshuHoho.表示なし_住所は印字しない.getコード().equals(dbT7065Entity.getJushoHenshuChoikiHenshuHoho())) {
            送付先住所 = 送付先住所.concat(全角スペース.concat(方書));
        }
        return 送付先住所;
    }

    private RString set送付先住所の管内の市町村共通(RString 住所, RString 番地, RString 方書,
            RString 都道府県名, RString 郡名, RString 市町村名, RString 行政区名) {
        RString 送付先住所 = RString.EMPTY;
        if (new RString("1").equals(DbBusinessConfig.get(
                ConfigNameDBU.帳票共通住所編集方法_管内住所編集_都道府県名付与有無, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告))) {
            送付先住所 = 送付先住所.concat(都道府県名);
        }

        if (new RString("1").equals(DbBusinessConfig.get(
                ConfigNameDBU.帳票共通住所編集方法_管内住所編集_郡名付与有無, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告))) {
            送付先住所 = 送付先住所.concat(郡名);
        }

        if (new RString("1").equals(DbBusinessConfig.get(
                ConfigNameDBU.帳票共通住所編集方法_管内住所編集_市町村名付与有無, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告))) {
            送付先住所 = 送付先住所.concat(市町村名);
        }

        if (住所_番地.equals(DbBusinessConfig.get(
                ConfigNameDBU.帳票共通住所編集方法_管内住所編集_編集方法, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告))) {
            送付先住所 = 送付先住所.concat(住所.concat(番地));
        } else if (行政区_番地.equals(DbBusinessConfig.get(
                ConfigNameDBU.帳票共通住所編集方法_管内住所編集_編集方法, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告))) {
            送付先住所 = 送付先住所.concat(行政区名.concat(番地));
        } else if (住所_番地_行政区.equals(
                DbBusinessConfig.get(ConfigNameDBU.帳票共通住所編集方法_管内住所編集_編集方法, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告))) {
            送付先住所 = 送付先住所.concat(住所.concat(番地).concat(括弧左).concat(行政区名).concat(括弧右));
        } else if (番地のみ.equals(DbBusinessConfig.get(
                ConfigNameDBU.帳票共通住所編集方法_管内住所編集_編集方法, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告))) {
            送付先住所 = 送付先住所.concat(番地);
        } else if (表示無し_住所は印字しない.equals(
                DbBusinessConfig.get(ConfigNameDBU.帳票共通住所編集方法_管内住所編集_編集方法, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告))) {
            送付先住所 = 送付先住所.concat(RString.EMPTY);
        }

        if (new RString("1").equals(DbBusinessConfig.get(
                ConfigNameDBU.帳票共通住所編集方法_住所編集_方書表示有無, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告))
                && !表示無し_住所は印字しない.equals(DbBusinessConfig.get(
                                ConfigNameDBU.帳票共通住所編集方法_管内住所編集_編集方法, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告))) {
            送付先住所 = 送付先住所.concat(全角スペース.concat(方書));
        }

        return 送付先住所;
    }

    private RString set認定開始日_認定終了日(IkkatsuHakkoRelateEntity ikkatsuHakkoRelateEntity) {
        RString 認定開始日_認定終了日 = RString.EMPTY;

        FlexibleDate 認定有効期間開始年月日 = ikkatsuHakkoRelateEntity.getNinteiYukoKikanKaishiYMD();
        FlexibleDate 認定有効期間終了年月日 = ikkatsuHakkoRelateEntity.getNinteiYukoKikanShuryoYMD();
        if (null == 認定有効期間開始年月日 && null == 認定有効期間終了年月日) {
            認定開始日_認定終了日 = RString.EMPTY;
        } else if (null == 認定有効期間開始年月日 && null != 認定有効期間終了年月日) {
            RString 終了年月日 = 認定有効期間終了年月日.wareki().eraType(EraType.KANJI_RYAKU).firstYear(
                    FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
            認定開始日_認定終了日 = new RString("          ").concat(分割線).concat(終了年月日);
        } else if (null != 認定有効期間開始年月日 && null == 認定有効期間終了年月日) {
            RString 開始年月日 = 認定有効期間開始年月日.wareki().eraType(EraType.KANJI_RYAKU).firstYear(
                    FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
            認定開始日_認定終了日 = 開始年月日.concat(分割線).concat(new RString("          "));
        } else if ((null != 認定有効期間開始年月日 && null != 認定有効期間終了年月日)) {
            RString 開始年月日 = 認定有効期間開始年月日.wareki().eraType(EraType.KANJI_RYAKU).firstYear(
                    FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
            RString 終了年月日 = 認定有効期間終了年月日.wareki().eraType(EraType.KANJI_RYAKU).firstYear(
                    FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
            認定開始日_認定終了日 = 開始年月日.concat(分割線).concat(終了年月日);
        }

        return 認定開始日_認定終了日;
    }

    private RString set要介護(IkkatsuHakkoRelateEntity ikkatsuHakkoRelateEntity) {
        RString 要介護 = RString.EMPTY;
        if (受給者台帳.equals(ikkatsuHakkoRelateEntity.getTaisyoKubun())) {
            FlexibleDate 認定有効期間開始年月日 = ikkatsuHakkoRelateEntity.getNinteiYukoKikanKaishiYMD();
            FlexibleDate 認定有効期間終了年月日 = ikkatsuHakkoRelateEntity.getNinteiYukoKikanShuryoYMD();
            要介護 = get要介護状態区分コード(認定有効期間終了年月日, ikkatsuHakkoRelateEntity.getYokaigoJotaiKubunCode());
            if (null == 認定有効期間開始年月日 && null == 認定有効期間終了年月日) {
                要介護 = RString.EMPTY;
            }
        } else if (総合事業対象者.equals(ikkatsuHakkoRelateEntity.getTaisyoKubun())) {
            要介護 = new RString("事業対象者");
        }
        return 要介護;
    }

    private IchiranyoShohakkoshaEntity createHihokenshashoHakkoIchiranHyoDataなし(
            Map<Integer, ISetSortItem> 出力順Map) {
        IchiranyoShohakkoshaEntity ichiranyoShohakkoshaEntity = new IchiranyoShohakkoshaEntity();

        ichiranyoShohakkoshaEntity.set作成日付(new RString(RDate.getNowDateTime().getDate().wareki().eraType(EraType.KANJI).firstYear(
                FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString().toString()).concat(作成));

        ichiranyoShohakkoshaEntity.setタイトル部分(タイトル);
        ichiranyoShohakkoshaEntity.set保険者番号(DbBusinessConfig.get(
                ConfigNameDBU.保険者情報_保険者番号, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告));
        IAssociationFinder finder = AssociationFinderFactory.createInstance();
        Association association = finder.getAssociation();
        if (association != null) {
            ichiranyoShohakkoshaEntity.set保険者名(association.get市町村名());
        } else {
            ichiranyoShohakkoshaEntity.set保険者名(RString.EMPTY);
        }

        if (出力順Map.get(INDEX_0) != null) {
            ichiranyoShohakkoshaEntity.setソート順１(出力順Map.get(INDEX_0).get項目名());
        }
        if (出力順Map.get(INDEX_1) != null) {
            ichiranyoShohakkoshaEntity.setソート順２(出力順Map.get(INDEX_1).get項目名());
        }
        if (出力順Map.get(INDEX_2) != null) {
            ichiranyoShohakkoshaEntity.setソート順３(出力順Map.get(INDEX_2).get項目名());
        }
        if (出力順Map.get(INDEX_3) != null) {
            ichiranyoShohakkoshaEntity.setソート順４(出力順Map.get(INDEX_3).get項目名());
        }
        if (出力順Map.get(INDEX_4) != null) {
            ichiranyoShohakkoshaEntity.setソート順５(出力順Map.get(INDEX_4).get項目名());
        }
        ichiranyoShohakkoshaEntity.set送付先住所(new RString("該当データはありません"));
        ichiranyoShohakkoshaEntity.setページ数(RString.EMPTY);
        ichiranyoShohakkoshaEntity.set改頁１(RString.EMPTY);
        ichiranyoShohakkoshaEntity.set改頁２(RString.EMPTY);
        ichiranyoShohakkoshaEntity.set改頁３(RString.EMPTY);
        ichiranyoShohakkoshaEntity.set改頁４(RString.EMPTY);
        ichiranyoShohakkoshaEntity.set改頁５(RString.EMPTY);
        ichiranyoShohakkoshaEntity.set帳票連番(RString.EMPTY);
        ichiranyoShohakkoshaEntity.set被保険者番号(HihokenshaNo.EMPTY);
        ichiranyoShohakkoshaEntity.set氏名(RString.EMPTY);
        ichiranyoShohakkoshaEntity.set生年月日_年齢(RString.EMPTY);
        ichiranyoShohakkoshaEntity.set要介護(RString.EMPTY);
        ichiranyoShohakkoshaEntity.set認定開始日_認定終了日(RString.EMPTY);
        ichiranyoShohakkoshaEntity.set施設名(RString.EMPTY);
        ichiranyoShohakkoshaEntity.set計画事業所名(RString.EMPTY);
        ichiranyoShohakkoshaEntity.set交付事由_非交付理由タイトル(RString.EMPTY);
        ichiranyoShohakkoshaEntity.set交付_非交付事由(RString.EMPTY);
        return ichiranyoShohakkoshaEntity;
    }

    private RString get要介護状態区分コード(FlexibleDate 認定有効期間終了年月日, Code 要介護認定状態区分コード) {
        if (認定有効期間終了年月日 == null || 認定有効期間終了年月日.isBefore(有効期間2000年04月)) {
            return RString.EMPTY;
        }
        if (認定有効期間終了年月日.isBefore(有効期間2002年04月)) {
            return YokaigoJotaiKubun99.toValue(要介護認定状態区分コード.getColumnValue()).get名称();
        }
        if (認定有効期間終了年月日.isBefore(有効期間2006年04月)) {
            return YokaigoJotaiKubun02.toValue(要介護認定状態区分コード.getColumnValue()).get名称();
        }
        if (認定有効期間終了年月日.isBefore(有効期間2009年04月)) {
            return YokaigoJotaiKubun06.toValue(要介護認定状態区分コード.getColumnValue()).get名称();
        }
        return YokaigoJotaiKubun09.toValue(要介護認定状態区分コード.getColumnValue()).get名称();
    }
}
