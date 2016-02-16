/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.service.core.hihokenshashohakkoichiranhyo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbu.entity.hihokenshashohakkoichiranhyo.HihokenshashoHakkoIchiranHyoEntity;
import jp.co.ndensan.reams.db.dbu.entity.hihokenshashohakkoichiranhyo.IchiranyoShohakkoshaEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7060KaigoJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7060KaigoJigyoshaDac;
import jp.co.ndensan.reams.db.dbz.definition.core.chohyo.kyotsu.JushoHenshuChoikiHenshuHoho;
import jp.co.ndensan.reams.db.dbz.definition.core.chohyo.kyotsu.JushoHenshuKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.configkeys.ConfigNameDBU;
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
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.definition.core.jusho.KannaiKangaiKubunType;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMasterNoOption;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 *
 * 被保険者証発行一覧表のビジネスクラスです。
 */
public class HihokenshashoHakkoIchiranHyoFinder {

    private static final RDate 有効期間2009年04月 = new RDate(2009, 04);
    private static final RDate 有効期間2006年04月 = new RDate(2006, 04);
    private static final RDate 有効期間2002年04月 = new RDate(2002, 04);
    private static final RDate 有効期間2000年04月 = new RDate(2000, 04);
    private static final RString タイトル = new RString("介護保険　被保険者証一覧表");
    private static final RString TRUE = new RString("true");
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
     * @param iOutputOrder 出力順
     * @return 被保険者証一覧表編集クラス
     */
    public List<IchiranyoShohakkoshaEntity> createHihokenshashoHakkoIchiranHyo(FlexibleDate 交付日,
            List<HihokenshashoHakkoIchiranHyoEntity> inEntityList, IOutputOrder iOutputOrder) {

        List<IchiranyoShohakkoshaEntity> outEntitylist = new ArrayList<>();

        IchiranyoShohakkoshaEntity ichiranyoShohakkoshaEntity = new IchiranyoShohakkoshaEntity();
        if (!inEntityList.isEmpty() && 0 != inEntityList.size()) {
            for (int i = 0; i < inEntityList.size(); i++) {
                HihokenshashoHakkoIchiranHyoEntity hihokenshashoHakkoIchiranHyoEntity = inEntityList.get(i);
                ichiranyoShohakkoshaEntity.set作成日付(new RString(RDate.getNowDate().toDateString().toString()).concat(作成));

                ichiranyoShohakkoshaEntity.setタイトル部分(タイトル);
                ichiranyoShohakkoshaEntity.set保険者番号(BusinessConfig.get(ConfigNameDBU.保険者情報_保険者番号, SubGyomuCode.DBU介護統計報告));

                IAssociationFinder finder = AssociationFinderFactory.createInstance();
                Association association = finder.getAssociation();
                if (association != null) {
                    ichiranyoShohakkoshaEntity.set保険者名(association.get市町村名());
                }

                List<ISetSortItem> iSetSortItemList = iOutputOrder.get設定項目リスト();
                Map<Integer, RString> ソート順Map = new HashMap<>();
                List<Integer> ソート順キーList = new ArrayList<>();
                Map<Integer, RString> 改頁Map = new HashMap<>();
                List<Integer> 改頁キーList = new ArrayList<>();
                for (ISetSortItem iSetSortItem : iSetSortItemList) {
                    ソート順Map.put(iSetSortItem.get出力順位(), iSetSortItem.get項目名());
                    ソート順キーList.add(iSetSortItem.get出力順位());
                    if (iSetSortItem.is改頁項目()) {
                        改頁Map.put(iSetSortItem.get出力順位(), iSetSortItem.get項目名());
                        改頁キーList.add(iSetSortItem.get出力順位());
                    }
                }

                for (int j = 0; j <= ソート順キーList.size(); j++) {
                    if (j == 0) {
                        ichiranyoShohakkoshaEntity.setソート順１(ソート順Map.get(j));
                    } else if (j == 1) {
                        ichiranyoShohakkoshaEntity.setソート順２(ソート順Map.get(i));
                    } else if (j == 2) {
                        ichiranyoShohakkoshaEntity.setソート順３(ソート順Map.get(j));
                    } else if (j == 3) {
                        ichiranyoShohakkoshaEntity.setソート順４(ソート順Map.get(j));
                    } else if (j == 4) {
                        ichiranyoShohakkoshaEntity.setソート順５(ソート順Map.get(j));
                    }
                }
                for (int k = 0; k <= 改頁キーList.size(); k++) {
                    if (k == 0) {
                        ichiranyoShohakkoshaEntity.set改頁１(改頁Map.get(k));
                    } else if (k == 1) {
                        ichiranyoShohakkoshaEntity.set改頁２(改頁Map.get(k));
                    } else if (k == 2) {
                        ichiranyoShohakkoshaEntity.set改頁３(改頁Map.get(k));
                    } else if (k == 3) {
                        ichiranyoShohakkoshaEntity.set改頁４(改頁Map.get(k));
                    } else if (k == 4) {
                        ichiranyoShohakkoshaEntity.set改頁５(改頁Map.get(k));
                    }
                }
                if (!hihokenshashoHakkoIchiranHyoEntity.is申請中状態フラグ()) {
                    ichiranyoShohakkoshaEntity.set帳票連番(new RString(Integer.valueOf(i + 1).toString()));
                }

                ichiranyoShohakkoshaEntity.set被保険者番号(hihokenshashoHakkoIchiranHyoEntity.get被保険者番号());
                ichiranyoShohakkoshaEntity.set氏名(hihokenshashoHakkoIchiranHyoEntity.get氏名());

                ichiranyoShohakkoshaEntity.set送付先住所(set生年月日_年齢(交付日, hihokenshashoHakkoIchiranHyoEntity));
                ichiranyoShohakkoshaEntity.set送付先住所(set送付先住所(hihokenshashoHakkoIchiranHyoEntity));
                ichiranyoShohakkoshaEntity.set送付先住所(set要介護_認定開始日_認定終了日(hihokenshashoHakkoIchiranHyoEntity));
                DbT7060KaigoJigyoshaDac dbT7060Dac = InstanceProvider.create(DbT7060KaigoJigyoshaDac.class);
                if (ShisetsuType.介護保険施設.getコード().equals(hihokenshashoHakkoIchiranHyoEntity.get入所施設コード())) {
                    List<DbT7060KaigoJigyoshaEntity> dbT7060EntityList
                            = dbT7060Dac.select事業者名称(new KaigoJigyoshaNo(hihokenshashoHakkoIchiranHyoEntity.get入所施設コード()));
                    if (!dbT7060EntityList.isEmpty()) {
                        ichiranyoShohakkoshaEntity.set施設名(new RString(dbT7060EntityList.get(0).getJigyoshaName().toString()));
                    }
                }

                if (ShisetsuType.住所地特例対象施設.getコード().equals(hihokenshashoHakkoIchiranHyoEntity.get入所施設コード())) {
                    DbT1005KaigoJogaiTokureiTaishoShisetsuDac dbT1005Dac = InstanceProvider.create(DbT1005KaigoJogaiTokureiTaishoShisetsuDac.class);
                    List<DbT1005KaigoJogaiTokureiTaishoShisetsuEntity> DbT1005EntityList
                            = dbT1005Dac.select事業者名称(new JigyoshaNo(hihokenshashoHakkoIchiranHyoEntity.get入所施設コード()));
                    if (!DbT1005EntityList.isEmpty()) {
                        ichiranyoShohakkoshaEntity.set施設名(new RString(DbT1005EntityList.get(0).getJigyoshaMeisho().toString()));
                    }
                }

                if (null != hihokenshashoHakkoIchiranHyoEntity.get計画事業者番号()) {
                    List<DbT7060KaigoJigyoshaEntity> dbT7060EntityList
                            = dbT7060Dac.select事業者名称(new KaigoJigyoshaNo(hihokenshashoHakkoIchiranHyoEntity.get計画事業者番号()));
                    if (!dbT7060EntityList.isEmpty()) {
                        ichiranyoShohakkoshaEntity.set施設名(new RString(dbT7060EntityList.get(0).getJigyoshaName().toString()));
                    }
                } else {
                    ichiranyoShohakkoshaEntity.set計画事業所名(計画事業所名_自己作成);
                }

                if (!hihokenshashoHakkoIchiranHyoEntity.is申請中状態フラグ()) {
                    ichiranyoShohakkoshaEntity.set交付事由_非交付理由タイトル(交付事由_非交付理由タイトル_交付事由);
                    if (new RString("受給者").equals(hihokenshashoHakkoIchiranHyoEntity.get受給区分())) {
                        ichiranyoShohakkoshaEntity.set交付事由(CodeMasterNoOption.getCodeMeisho(new CodeShubetsu("0002"), new Code("02")));
                    }
                    if (new RString("年齢到達予定者").equals(hihokenshashoHakkoIchiranHyoEntity.get受給区分())) {
                        ichiranyoShohakkoshaEntity.set交付事由(CodeMasterNoOption.getCodeRyakusho(new CodeShubetsu("0002"), new Code("01")));
                    }
                    if (new RString("被保険者").equals(hihokenshashoHakkoIchiranHyoEntity.get受給区分())) {
                        ichiranyoShohakkoshaEntity.set交付事由(CodeMasterNoOption.getCodeRyakusho(new CodeShubetsu("0002"),
                                new Code(hihokenshashoHakkoIchiranHyoEntity.get異動事由コード())));
                    }
                } else {
                    ichiranyoShohakkoshaEntity.set交付事由_非交付理由タイトル(交付事由_非交付理由タイトル_非交付事由);
                    ichiranyoShohakkoshaEntity.set非交付事由(new RString("申請中"));
                }
                outEntitylist.add(ichiranyoShohakkoshaEntity);
            }
            if (0 == outEntitylist.size()) {
                createHihokenshashoHakkoIchiranHyoNoData();
            }
        } else {
            createHihokenshashoHakkoIchiranHyoNoData();
        }
        return outEntitylist;
    }

    /**
     * 送付先住所の設定
     *
     * @param 交付日 交付日
     * @param hihokenshashoHakkoIchiranHyoEntity 被保険者証一覧表Entity
     * @return 生年月日_年齢
     */
    private RString set生年月日_年齢(FlexibleDate 交付日, HihokenshashoHakkoIchiranHyoEntity hihokenshashoHakkoIchiranHyoEntity) {

        RString 生年月日_年齢 = RString.EMPTY;
        IDateOfBirth dateOfBirth = new _DateOfBirth(new FlexibleDate(hihokenshashoHakkoIchiranHyoEntity.get生年月日()));
        AgeCalculator agecalculator = new AgeCalculator(dateOfBirth, hihokenshashoHakkoIchiranHyoEntity.get住民状態コード(), FlexibleDate.MAX, AgeArrivalDay.前日, 交付日);
        RString 年齢 = agecalculator.get年齢();
        if (null != 年齢 && !年齢.isEmpty()) {
            if (1 == 年齢.length()) {
                年齢 = 半角スペース.concat(半角スペース).concat(年齢);
            } else if (2 == 年齢.length()) {
                年齢 = 半角スペース.concat(年齢);
            }

            if (JuminShubetsu.日本人.getCode().equals(hihokenshashoHakkoIchiranHyoEntity.get住民種別コード())
                    || JuminShubetsu.住登外個人_日本人.getCode().equals(hihokenshashoHakkoIchiranHyoEntity.get住民種別コード())) {
                RString 生年月日 = new FlexibleDate(hihokenshashoHakkoIchiranHyoEntity.get生年月日()).wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
                生年月日_年齢 = 半角スペース.concat(生年月日).concat(半角スペース.concat(年齢));

            } else if (JuminShubetsu.外国人.getCode().equals(hihokenshashoHakkoIchiranHyoEntity.get住民種別コード())
                    || JuminShubetsu.住登外個人_外国人.getCode().equals(hihokenshashoHakkoIchiranHyoEntity.get住民種別コード())) {
                RString 生年月日 = new FlexibleDate(hihokenshashoHakkoIchiranHyoEntity.get生年月日()).seireki().separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
                生年月日_年齢 = 半角スペース.concat(生年月日).concat(半角スペース.concat(年齢));
            }

        }

        return 生年月日_年齢;
    }

    /**
     * 送付先住所の設定
     *
     * @param hihokenshashoHakkoIchiranHyoEntity 被保険者証一覧表Entity
     * @return 送付先住所
     */
    private RString set送付先住所(HihokenshashoHakkoIchiranHyoEntity hihokenshashoHakkoIchiranHyoEntity) {

        RString 送付先住所 = RString.EMPTY;
        if (KannaiKangaiKubunType.管外.code().equals(hihokenshashoHakkoIchiranHyoEntity.get管内管外区分())) {
            送付先住所 = hihokenshashoHakkoIchiranHyoEntity.get住所().concat(hihokenshashoHakkoIchiranHyoEntity.get番地())
                    .concat(new RString("　")).concat(hihokenshashoHakkoIchiranHyoEntity.get方書());
        } else if (KannaiKangaiKubunType.管内.code().equals(hihokenshashoHakkoIchiranHyoEntity.get管内管外区分())) {
            IAssociationFinder finder = AssociationFinderFactory.createInstance();
            Association association = finder.getAssociation();
            RString 都道府県名 = association.get都道府県名();
            RString 郡名 = association.get郡名();
            RString 市町村名 = association.get市町村名();

            DbT7065ChohyoSeigyoKyotsuDac dbT7065Dac = InstanceProvider.create(DbT7065ChohyoSeigyoKyotsuDac.class);
            DbT7065ChohyoSeigyoKyotsuEntity dbT7065Entity = dbT7065Dac.selectByKey(SubGyomuCode.DBA介護資格, new ReportId(帳票ID_被保険者証));
            if (dbT7065Entity != null) {
                if (JushoHenshuKubun.帳票独自.getコード().equals(dbT7065Entity.getJushoHenshuKubun())) {
                    if (dbT7065Entity.getJushoHenshuTodoufukenMeiHyojiUmu()) {
                        送付先住所 = 都道府県名;
                    }
                    if (dbT7065Entity.getJushoHenshuGunMeiHyojiUmu()) {
                        送付先住所 = 郡名;
                    }
                    if (dbT7065Entity.getJushoHenshuShichosonMeiHyojiUmu()) {
                        送付先住所 = 市町村名;
                    }
                    if (JushoHenshuChoikiHenshuHoho.住所足す番地.get略称().equals(dbT7065Entity.getJushoHenshuChoikiHenshuHoho())) {
                        送付先住所 = hihokenshashoHakkoIchiranHyoEntity.get住所().concat(hihokenshashoHakkoIchiranHyoEntity.get番地());
                    } else if (JushoHenshuChoikiHenshuHoho.行政区足す番地.get略称().equals(dbT7065Entity.getJushoHenshuChoikiHenshuHoho())) {
                        送付先住所 = hihokenshashoHakkoIchiranHyoEntity.get行政区名().concat(hihokenshashoHakkoIchiranHyoEntity.get番地());
                    } else if (JushoHenshuChoikiHenshuHoho.住所足す番地_行政区.get略称().equals(dbT7065Entity.getJushoHenshuChoikiHenshuHoho())) {
                        送付先住所 = hihokenshashoHakkoIchiranHyoEntity.get住所().concat(hihokenshashoHakkoIchiranHyoEntity.get番地())
                                .concat(括弧左).concat(hihokenshashoHakkoIchiranHyoEntity.get行政区名()).concat(括弧右);
                    } else if (JushoHenshuChoikiHenshuHoho.番地のみ.get略称().equals(dbT7065Entity.getJushoHenshuChoikiHenshuHoho())) {
                        送付先住所 = hihokenshashoHakkoIchiranHyoEntity.get番地();
                    } else if (JushoHenshuChoikiHenshuHoho.表示なし_住所は印字しない.get略称().equals(dbT7065Entity.getJushoHenshuChoikiHenshuHoho())) {
                        送付先住所 = RString.EMPTY;
                    } else {
                        if (dbT7065Entity.getJushoHenshuKatagakiHyojiUmu()) {
                            送付先住所 = 全角スペース.concat(hihokenshashoHakkoIchiranHyoEntity.get方書());
                        }
                    }
                } else if (JushoHenshuKubun.市町村共通.getコード().equals(dbT7065Entity.getJushoHenshuKubun())) {
                    if (TRUE.equals(BusinessConfig.get(ConfigNameDBU.帳票共通住所編集方法_管内住所編集_都道府県名付与有無, SubGyomuCode.DBU介護統計報告))) {
                        送付先住所 = 都道府県名;
                    }

                    if (TRUE.equals(BusinessConfig.get(ConfigNameDBU.帳票共通住所編集方法_管内住所編集_郡名付与有無, SubGyomuCode.DBU介護統計報告))) {
                        送付先住所 = 郡名;
                    }

                    if (TRUE.equals(BusinessConfig.get(ConfigNameDBU.帳票共通住所編集方法_管内住所編集_市町村名付与有無, SubGyomuCode.DBU介護統計報告))) {
                        送付先住所 = 郡名;
                    }

                    if (住所_番地.equals(BusinessConfig.get(ConfigNameDBU.帳票共通住所編集方法_管内住所編集_編集方法, SubGyomuCode.DBU介護統計報告))) {
                        送付先住所 = hihokenshashoHakkoIchiranHyoEntity.get住所().concat(hihokenshashoHakkoIchiranHyoEntity.get番地());
                    } else if (行政区_番地.equals(BusinessConfig.get(ConfigNameDBU.帳票共通住所編集方法_管内住所編集_編集方法, SubGyomuCode.DBU介護統計報告))) {
                        送付先住所 = hihokenshashoHakkoIchiranHyoEntity.get行政区名().concat(hihokenshashoHakkoIchiranHyoEntity.get番地());
                    } else if (住所_番地_行政区.equals(BusinessConfig.get(ConfigNameDBU.帳票共通住所編集方法_管内住所編集_編集方法, SubGyomuCode.DBU介護統計報告))) {
                        送付先住所 = hihokenshashoHakkoIchiranHyoEntity.get住所().concat(hihokenshashoHakkoIchiranHyoEntity.get番地())
                                .concat(括弧左).concat(hihokenshashoHakkoIchiranHyoEntity.get行政区名()).concat(括弧右);
                    } else if (番地のみ.equals(BusinessConfig.get(ConfigNameDBU.帳票共通住所編集方法_管内住所編集_編集方法, SubGyomuCode.DBU介護統計報告))) {
                        送付先住所 = hihokenshashoHakkoIchiranHyoEntity.get番地();
                    } else if (表示無し_住所は印字しない.equals(BusinessConfig.get(ConfigNameDBU.帳票共通住所編集方法_管内住所編集_編集方法, SubGyomuCode.DBU介護統計報告))) {
                        送付先住所 = RString.EMPTY;
                    } else {
                        if (TRUE.equals(BusinessConfig.get(ConfigNameDBU.帳票共通住所編集方法_住所編集_方書表示有無, SubGyomuCode.DBU介護統計報告))) {
                            送付先住所 = 全角スペース.concat(hihokenshashoHakkoIchiranHyoEntity.get方書());
                        }
                    }
                }
            }
        }
        return 送付先住所;
    }

    /**
     * 送付先住所の設定
     *
     * @param hihokenshashoHakkoIchiranHyoEntity 被保険者証一覧表Entity
     * @return 要介護_認定開始日_認定終了日
     */
    private RString set要介護_認定開始日_認定終了日(HihokenshashoHakkoIchiranHyoEntity hihokenshashoHakkoIchiranHyoEntity) {
        RString 要介護_認定開始日_認定終了日 = RString.EMPTY;

        RDate 認定有効期間開始年月日 = hihokenshashoHakkoIchiranHyoEntity.get認定有効期間開始年月日();
        RDate 認定有効期間終了年月日 = hihokenshashoHakkoIchiranHyoEntity.get認定有効期間終了年月日();
        RString 要介護 = get要介護状態区分コード(認定有効期間終了年月日, hihokenshashoHakkoIchiranHyoEntity.get要介護認定状態区分コード());
        if (null == 認定有効期間開始年月日 && null == 認定有効期間終了年月日) {
            要介護_認定開始日_認定終了日 = 要介護;
        } else if (null == 認定有効期間開始年月日 && null != 認定有効期間終了年月日) {
            RString 終了年月日 = 認定有効期間終了年月日.wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
            要介護_認定開始日_認定終了日 = 要介護.concat(new RString("          ")).concat(分割線).concat(終了年月日);
        } else if (null != 認定有効期間開始年月日 && null == 認定有効期間終了年月日) {
            RString 開始年月日 = 認定有効期間開始年月日.wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
            要介護_認定開始日_認定終了日 = 要介護.concat(開始年月日.concat(分割線));
        } else if ((null != 認定有効期間開始年月日 && null != 認定有効期間終了年月日)) {
            RString 開始年月日 = 認定有効期間開始年月日.wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
            RString 終了年月日 = 認定有効期間終了年月日.wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
            要介護_認定開始日_認定終了日 = 要介護.concat(開始年月日).concat(分割線).concat(終了年月日);
        }

        return 要介護_認定開始日_認定終了日;
    }

    /**
     * 一覧表証発行者Entityの設定(入力したデータがない場合)
     *
     * @param 認定有効期間終了年月日
     * @return 一覧表証発行者Entity
     */
    private IchiranyoShohakkoshaEntity createHihokenshashoHakkoIchiranHyoNoData() {
        IchiranyoShohakkoshaEntity ichiranyoShohakkoshaEntity = new IchiranyoShohakkoshaEntity();

        ichiranyoShohakkoshaEntity.set作成日付(new RString(RDate.getNowDate().toDateString().toString()).concat(作成));

        ichiranyoShohakkoshaEntity.setタイトル部分(タイトル);
        ichiranyoShohakkoshaEntity.set保険者番号(BusinessConfig.get(ConfigNameDBU.保険者情報_保険者番号, SubGyomuCode.DBU介護統計報告));

        IAssociationFinder finder = AssociationFinderFactory.createInstance();
        Association association = finder.getAssociation();
        if (association != null) {
            ichiranyoShohakkoshaEntity.set保険者名(association.get市町村名());
        }

        ichiranyoShohakkoshaEntity.setソート順１(null);
        ichiranyoShohakkoshaEntity.setソート順１(null);
        ichiranyoShohakkoshaEntity.setソート順１(null);
        ichiranyoShohakkoshaEntity.setソート順１(null);
        ichiranyoShohakkoshaEntity.setソート順１(null);
        ichiranyoShohakkoshaEntity.set送付先住所(new RString("該当データはありません"));
        return ichiranyoShohakkoshaEntity;
    }

    /**
     * 要介護状態区分コード取得
     *
     * @param 認定有効期間終了年月日
     * @param 要介護認定状態区分コード
     * @return
     */
    private RString get要介護状態区分コード(RDate 認定有効期間終了年月日, Code 要介護認定状態区分コード) {
        if (認定有効期間終了年月日.isBefore(有効期間2000年04月)) {
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
