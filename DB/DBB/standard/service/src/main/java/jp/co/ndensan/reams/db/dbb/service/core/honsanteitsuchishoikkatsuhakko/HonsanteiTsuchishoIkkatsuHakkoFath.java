/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.honsanteitsuchishoikkatsuhakko;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jp.co.ndensan.reams.db.dbb.business.core.fukaatena.FukaAtena;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJoho;
import jp.co.ndensan.reams.db.dbb.business.core.honsanteitsuchishoikkatsuhakko.HonsanteiTsuchishoTempResult;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.ShunyuJoho;
import jp.co.ndensan.reams.db.dbb.definition.core.choshuhoho.ChoshuHohoKibetsu;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.NotsuKozaShutsuryokuTaisho;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2015KeisangoJohoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajoho.fukajoho.FukaJohoRelateEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajoho.kibetsu.KibetsuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.honsanteitsuchishoikkatsuhakko.HonsanteiTsuchishoTempEntity;
import jp.co.ndensan.reams.db.dbx.business.core.choshuhoho.ChoshuHoho;
import jp.co.ndensan.reams.db.dbx.business.core.fuka.Fuka;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2003KibetsuEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.UrT0705ChoteiKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7065ChohyoSeigyoKyotsuEntity;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.AtesakiFactory;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ua.uax.business.core.koza.Koza;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ue.uex.business.core.NenkinTokuchoKaifuJoho;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.report.daikoprint.DaikoPrintItem;
import jp.co.ndensan.reams.ur.urz.service.report.daikoprint.DaikoPrintFactory;
import jp.co.ndensan.reams.ur.urz.service.report.daikoprint.IDaikoPrint;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 本算定通知書一括発行（バッチ）クラスです。
 *
 * @reamsid_L DBB-0780-060 xicongwang
 */
public class HonsanteiTsuchishoIkkatsuHakkoFath {

    private static final int INT_1 = 1;
    private static final int INT_5 = 5;
    private static final int INT_7 = 7;
    private static final int INT_14 = 14;
    private static final RString 定数_抽出条件 = new RString("抽出条件");
    private static final RString 定数_詳細設定 = new RString("詳細設定");
    private static final RString 定数_賦課年度 = new RString("賦課年度");
    private static final RString 定数_調定年度 = new RString("調定年度");
    private static final RString 定数_発行日 = new RString("発行日");
    private static final RString 定数_出力期 = new RString("出力期");
    private static final RString 定数_対象者 = new RString("対象者");
    private static final RString 定数_生活保護対象者をまとめて先頭に出力 = new RString("生活保護対象者をまとめて先頭に出力");
    private static final RString 定数_ページごとに山分け = new RString("ページごとに山分け");
    private static final RString 定数_特徴方法 = new RString("getTkKibetsuGaku");
    private static final RString 定数_普徴方法 = new RString("getFuKibetsuGaku");
    private static final RString ジョブ番号 = new RString("【ジョブ番号】");
    private static final RString 代行プリント送付票_処理名 = new RString("本算定通知書一括発行");
    private static final RString 代行プリント送付票_帳票名 = new RString("保険料納入通知書（本算定）");
    private static final RString FORMAT_LEFT = new RString("【");
    private static final RString FORMAT_RIGHT = new RString("】");
    private static final RString 定値区分_0 = new RString("0");
    private static final RString 定値区分_1 = new RString("1");
    private static final RString 定値_する = new RString("する");
    private static final RString 定値_しない = new RString("しない");

    /**
     * コンストラクタです。
     */
    public HonsanteiTsuchishoIkkatsuHakkoFath() {
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link HonsanteiTsuchishoIkkatsuHakkoFath}のインスタンスを返します。
     *
     * @return HonsanteiTsuchishoIkkatsuHakkoFath
     */
    public static HonsanteiTsuchishoIkkatsuHakkoFath createInstance() {
        return InstanceProvider.create(HonsanteiTsuchishoIkkatsuHakkoFath.class);
    }

    /**
     * 代行プリント送付票を出力するメソッドです。
     *
     * @param 調定年度 FlexibleYear
     * @param 賦課年度 FlexibleYear
     * @param 帳票ID ReportId
     * @param 発行日 RDate
     * @param 出力期 RString
     * @param 納入通知書対象者 RString
     * @param 生活保護者先頭出力区分 RString
     * @param 山分け区分 RString
     * @param 帳票制御共通情報 DbT7065ChohyoSeigyoKyotsuEntity
     * @param 地方公共団体 Association
     * @param outputOrder IOutputOrder
     * @param 通知書ページ数 Decimal
     */
    public void load代行プリント送付票(FlexibleYear 調定年度, FlexibleYear 賦課年度, ReportId 帳票ID, RDate 発行日,
            RString 出力期, RString 納入通知書対象者, RString 生活保護者先頭出力区分,
            RString 山分け区分, DbT7065ChohyoSeigyoKyotsuEntity 帳票制御共通情報,
            Association 地方公共団体, IOutputOrder outputOrder, Decimal 通知書ページ数) {

        if (帳票制御共通情報 == null || !帳票制御共通情報.getDaikoPrintUmu()) {
            return;
        }

        List<RString> 出力順項目List = new ArrayList<>();
        List<RString> 改ページ項目List = new ArrayList<>();
        set出力順_改頁(outputOrder, 出力順項目List, 改ページ項目List);
        List<Decimal> ページ数List = new ArrayList<>();
        ページ数List.add(通知書ページ数);
        List<RString> 抽出条件List = new ArrayList<>();
        RStringBuilder builder = new RStringBuilder();
        builder.append(定数_抽出条件);
        抽出条件List.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(FORMAT_LEFT.concat(定数_賦課年度).concat(FORMAT_RIGHT).concat(RString.FULL_SPACE).concat(賦課年度.wareki().toDateString()));
        抽出条件List.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(FORMAT_LEFT.concat(定数_調定年度).concat(FORMAT_RIGHT).concat(RString.FULL_SPACE).concat(調定年度.wareki().toDateString()));
        抽出条件List.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(FORMAT_LEFT.concat(定数_対象者).concat(FORMAT_RIGHT).concat(RString.FULL_SPACE)
                .concat(NotsuKozaShutsuryokuTaisho.toValue(納入通知書対象者).get名称()));
        抽出条件List.add(builder.toRString());

        List<RString> 帳票名List = new ArrayList<>();
        帳票名List.add(代行プリント送付票_帳票名);

        List<RString> 詳細設定List = new ArrayList<>();
        RStringBuilder 詳細設定builder = new RStringBuilder();
        詳細設定builder.append(定数_詳細設定);
        詳細設定List.add(詳細設定builder.toRString());
        詳細設定builder = new RStringBuilder();
        詳細設定builder.append(FORMAT_LEFT.concat(定数_発行日).concat(FORMAT_RIGHT).concat(RString.FULL_SPACE)
                .concat(発行日.wareki().toDateString()));
        詳細設定List.add(詳細設定builder.toRString());
        詳細設定builder = new RStringBuilder();
        詳細設定builder.append(FORMAT_LEFT.concat(定数_出力期).concat(FORMAT_RIGHT).concat(RString.FULL_SPACE)
                .concat(RString.isNullOrEmpty(出力期) ? RString.EMPTY : 出力期));
        詳細設定List.add(詳細設定builder.toRString());
        詳細設定builder = new RStringBuilder();
        if (定値区分_0.equals(生活保護者先頭出力区分)) {
            詳細設定builder.append(FORMAT_LEFT.concat(定数_生活保護対象者をまとめて先頭に出力).concat(FORMAT_RIGHT)
                    .concat(RString.FULL_SPACE).concat(定値_する));
        } else if (定値区分_1.equals(生活保護者先頭出力区分)) {
            詳細設定builder.append(FORMAT_LEFT.concat(定数_生活保護対象者をまとめて先頭に出力).concat(FORMAT_RIGHT)
                    .concat(RString.FULL_SPACE).concat(定値_しない));
        }
        詳細設定List.add(詳細設定builder.toRString());
        詳細設定builder = new RStringBuilder();
        if (定値区分_0.equals(山分け区分)) {
            詳細設定builder.append(FORMAT_LEFT.concat(定数_ページごとに山分け).concat(FORMAT_RIGHT)
                    .concat(RString.FULL_SPACE).concat(定値_する));
        } else if (定値区分_1.equals(山分け区分)) {
            詳細設定builder.append(FORMAT_LEFT.concat(定数_ページごとに山分け).concat(FORMAT_RIGHT)
                    .concat(RString.FULL_SPACE).concat(定値_しない));
        }
        詳細設定List.add(詳細設定builder.toRString());

        DaikoPrintItem daikoPrintItem = new DaikoPrintItem(SubGyomuCode.DBB介護賦課,
                地方公共団体.getLasdecCode_(), 地方公共団体.get市町村名(),
                ジョブ番号.concat(RString.FULL_SPACE).concat(new RString(String.valueOf(JobContextHolder.getJobId()))),
                代行プリント送付票_処理名, 帳票ID.getColumnValue(), 帳票名List, ページ数List, 抽出条件List,
                出力順項目List, 改ページ項目List, 詳細設定List);
        IDaikoPrint daikoPrint = DaikoPrintFactory.createInstance(daikoPrintItem);
        daikoPrint.print();
    }

    /**
     * 賦課情報を取得するメソッドです。
     *
     * @param entity HonsanteiTsuchishoTempEntity
     * @return HonsanteiTsuchishoTempResult 賦課情報
     * @throws java.lang.reflect.InvocationTargetException 賦課の情報_更正前後が取得できない場合、Exception
     */
    public HonsanteiTsuchishoTempResult get賦課情報(HonsanteiTsuchishoTempEntity entity) throws InvocationTargetException {

        HonsanteiTsuchishoTempResult result = new HonsanteiTsuchishoTempResult();
        result.set計算後情報_更正後(entity.get計算後情報_更正後());
        result.set計算後情報_更正前(entity.get計算後情報_更正前());
        result.set賦課の情報_更正前(get賦課の情報_更正前後(entity, false));
        result.set賦課の情報_更正後(get賦課の情報_更正前後(entity, true));
        result.set納組情報(entity.get納組());
        if (entity.get宛先() != null && entity.get宛先().getShikibetsuCode() != null) {
            IAtesaki 宛先 = AtesakiFactory.createInstance(entity.get宛先());
            result.set宛先情報(宛先);
        }

        if (entity.get特定口座() != null && entity.get特定口座().getUaT0310KozaEntity().getKozaId() != 0) {
            result.set口座情報(new Koza(entity.get特定口座()));
        }

        result.set徴収方法情報_更正前(get徴収方法情報_更正前後(entity, false));
        result.set徴収方法情報_更正後(get徴収方法情報_更正前後(entity, true));
        if (entity.get対象者_追加含む_情報_更正前() != null) {
            result.set対象者_追加含む_情報_更正前(new NenkinTokuchoKaifuJoho(entity.get対象者_追加含む_情報_更正前()));
        }
        if (entity.get対象者_追加含む_情報_更正後() != null) {
            result.set対象者_追加含む_情報_更正後(new NenkinTokuchoKaifuJoho(entity.get対象者_追加含む_情報_更正後()));
        }
        result.set収入情報(get収入情報(entity));
        return result;
    }

    private ShunyuJoho get収入情報(HonsanteiTsuchishoTempEntity entity) {

        DbT2015KeisangoJohoEntity 計算後情報_更正後 = entity.get計算後情報_更正後();
        if (計算後情報_更正後 == null) {
            return null;
        }
        ShunyuJoho 収入情報 = new ShunyuJoho();
        収入情報.set調定年度(計算後情報_更正後.getChoteiNendo());
        収入情報.set賦課年度(計算後情報_更正後.getFukaNendo());
        収入情報.set通知書番号(計算後情報_更正後.getTsuchishoNo());
        収入情報.set普徴収入額01(計算後情報_更正後.getFuShunyuGaku01());
        収入情報.set普徴収入額02(計算後情報_更正後.getFuShunyuGaku02());
        収入情報.set普徴収入額03(計算後情報_更正後.getFuShunyuGaku03());
        収入情報.set普徴収入額04(計算後情報_更正後.getFuShunyuGaku04());
        収入情報.set普徴収入額05(計算後情報_更正後.getFuShunyuGaku05());
        収入情報.set普徴収入額06(計算後情報_更正後.getFuShunyuGaku06());
        収入情報.set普徴収入額07(計算後情報_更正後.getFuShunyuGaku07());
        収入情報.set普徴収入額08(計算後情報_更正後.getFuShunyuGaku08());
        収入情報.set普徴収入額09(計算後情報_更正後.getFuShunyuGaku09());
        収入情報.set普徴収入額10(計算後情報_更正後.getFuShunyuGaku10());
        収入情報.set普徴収入額11(計算後情報_更正後.getFuShunyuGaku11());
        収入情報.set普徴収入額12(計算後情報_更正後.getFuShunyuGaku12());
        収入情報.set普徴収入額13(計算後情報_更正後.getFuShunyuGaku13());
        収入情報.set普徴収入額14(計算後情報_更正後.getFuShunyuGaku14());
        収入情報.set特徴収入額01(計算後情報_更正後.getTkShunyuGaku01());
        収入情報.set特徴収入額02(計算後情報_更正後.getTkShunyuGaku02());
        収入情報.set特徴収入額03(計算後情報_更正後.getTkShunyuGaku03());
        収入情報.set特徴収入額04(計算後情報_更正後.getTkShunyuGaku04());
        収入情報.set特徴収入額05(計算後情報_更正後.getTkShunyuGaku05());
        収入情報.set特徴収入額06(計算後情報_更正後.getTkShunyuGaku06());
        return 収入情報;
    }

    private ChoshuHoho get徴収方法情報_更正前後(HonsanteiTsuchishoTempEntity entity, boolean 前後区分) {

        DbT2015KeisangoJohoEntity 計算後情報_更正前後;
        if (前後区分) {
            計算後情報_更正前後 = entity.get計算後情報_更正後();
        } else {
            計算後情報_更正前後 = entity.get計算後情報_更正前();
        }
        if (計算後情報_更正前後 == null || 計算後情報_更正前後.getFukaNendo() == null || 計算後情報_更正前後.getFukaNendo().isEmpty()
                || 計算後情報_更正前後.getHihokenshaNo() == null || 計算後情報_更正前後.getHihokenshaNo().isEmpty()) {
            return null;
        }
        ChoshuHoho 徴収方法情報 = new ChoshuHoho(計算後情報_更正前後.getFukaNendo(),
                計算後情報_更正前後.getHihokenshaNo(), 計算後情報_更正前後.getChoshuHohoRirekiNo());
        徴収方法情報 = 徴収方法情報.createBuilderForEdit().set徴収方法4月(計算後情報_更正前後.getChoshuHoho4gatsu())
                .set徴収方法5月(計算後情報_更正前後.getChoshuHoho5gatsu()).set徴収方法6月(計算後情報_更正前後.getChoshuHoho6gatsu())
                .set徴収方法7月(計算後情報_更正前後.getChoshuHoho7gatsu()).set徴収方法8月(計算後情報_更正前後.getChoshuHoho8gatsu())
                .set徴収方法9月(計算後情報_更正前後.getChoshuHoho9gatsu()).set徴収方法10月(計算後情報_更正前後.getChoshuHoho10gatsu())
                .set徴収方法11月(計算後情報_更正前後.getChoshuHoho11gatsu()).set徴収方法12月(計算後情報_更正前後.getChoshuHoho12gatsu())
                .set徴収方法1月(計算後情報_更正前後.getChoshuHoho1gatsu()).set徴収方法2月(計算後情報_更正前後.getChoshuHoho2gatsu())
                .set徴収方法3月(計算後情報_更正前後.getChoshuHoho3gatsu()).set徴収方法翌4月(計算後情報_更正前後.getChoshuHohoYoku4gatsu())
                .set徴収方法翌5月(計算後情報_更正前後.getChoshuHohoYoku5gatsu()).set徴収方法翌6月(計算後情報_更正前後.getChoshuHohoYoku6gatsu())
                .set徴収方法翌7月(計算後情報_更正前後.getChoshuHohoYoku7gatsu()).set徴収方法翌8月(計算後情報_更正前後.getChoshuHohoYoku8gatsu())
                .set徴収方法翌9月(計算後情報_更正前後.getChoshuHohoYoku9gatsu()).set仮徴収_基礎年金番号(計算後情報_更正前後.getKariNenkinNo())
                .set仮徴収_年金コード(計算後情報_更正前後.getKariNenkinCode()).set仮徴収_捕捉月(計算後情報_更正前後.getKariHosokuM())
                .set本徴収_基礎年金番号(計算後情報_更正前後.getHonNenkinNo()).set本徴収_年金コード(計算後情報_更正前後.getHonNenkinCode())
                .set本徴収_捕捉月(計算後情報_更正前後.getHonHosokuM()).set翌年度仮徴収_基礎年金番号(計算後情報_更正前後.getYokunendoKariNenkinNo())
                .set翌年度仮徴収_年金コード(計算後情報_更正前後.getYokunendoKariNenkinCode())
                .set翌年度仮徴収_捕捉月(計算後情報_更正前後.getYokunendoKariHosokuM())
                .set依頼情報送付済みフラグ(計算後情報_更正前後.getIraiSohuzumiFlag())
                .set追加依頼情報送付済みフラグ(計算後情報_更正前後.getTsuikaIraiSohuzumiFlag())
                .set特別徴収停止日時(計算後情報_更正前後.getTokuchoTeishiNichiji())
                .set特別徴収停止事由コード(計算後情報_更正前後.getTokuchoTeishiJiyuCode()).build();
        return 徴収方法情報;
    }

    private FukaAtena get賦課の情報_更正前後(HonsanteiTsuchishoTempEntity entity, boolean 前後区分) throws InvocationTargetException {

        FukaAtena fukaAtena = new FukaAtena();
        DbT2015KeisangoJohoEntity 計算後情報_更正前後;
        if (前後区分) {
            計算後情報_更正前後 = entity.get計算後情報_更正後();
        } else {
            計算後情報_更正前後 = entity.get計算後情報_更正前();
        }
        if (計算後情報_更正前後 == null || 計算後情報_更正前後.getChoteiNendo() == null || 計算後情報_更正前後.getChoteiNendo().isEmpty()
                || 計算後情報_更正前後.getFukaNendo() == null || 計算後情報_更正前後.getFukaNendo().isEmpty()
                || 計算後情報_更正前後.getTsuchishoNo() == null || 計算後情報_更正前後.getTsuchishoNo().isEmpty()) {
            return null;
        }
        Fuka fuka = new Fuka(計算後情報_更正前後.getChoteiNendo(), 計算後情報_更正前後.getFukaNendo(),
                計算後情報_更正前後.getTsuchishoNo(), 計算後情報_更正前後.getFukaRirekiNo());
        fuka = fuka.createBuilderForEdit().set被保険者番号(計算後情報_更正前後.getHihokenshaNo())
                .set識別コード(計算後情報_更正前後.getShikibetsuCode())
                .set世帯コード(計算後情報_更正前後.getSetaiCode()).set世帯員数(計算後情報_更正前後.getSetaiInsu())
                .set資格取得日(計算後情報_更正前後.getShikakuShutokuYMD()).set資格取得事由(計算後情報_更正前後.getShikakuShutokuJiyu())
                .set資格喪失日(計算後情報_更正前後.getShikakuSoshitsuYMD()).set資格喪失事由(計算後情報_更正前後.getShikakuSoshitsuJiyu())
                .set生活保護扶助種類(計算後情報_更正前後.getSeihofujoShurui()).set生保開始日(計算後情報_更正前後.getSeihoKaishiYMD())
                .set生保廃止日(計算後情報_更正前後.getSeihoHaishiYMD()).set老年開始日(計算後情報_更正前後.getRonenKaishiYMD())
                .set老年廃止日(計算後情報_更正前後.getRonenHaishiYMD()).set賦課期日(計算後情報_更正前後.getFukaYMD())
                .set課税区分(計算後情報_更正前後.getKazeiKubun()).set世帯課税区分(計算後情報_更正前後.getSetaikazeiKubun())
                .set合計所得金額(計算後情報_更正前後.getGokeiShotokuGaku()).set公的年金収入額(計算後情報_更正前後.getNenkinShunyuGaku())
                .set保険料段階(計算後情報_更正前後.getHokenryoDankai()).set保険料算定段階1(計算後情報_更正前後.getHokenryoDankai1())
                .set算定年額保険料1(計算後情報_更正前後.getNengakuHokenryo1()).set保険料算定段階2(計算後情報_更正前後.getHokenryoDankai2())
                .set算定年額保険料2(計算後情報_更正前後.getNengakuHokenryo2()).set調定日時(計算後情報_更正前後.getChoteiNichiji())
                .set調定事由1(計算後情報_更正前後.getChoteiJiyu1()).set調定事由2(計算後情報_更正前後.getChoteiJiyu2())
                .set調定事由3(計算後情報_更正前後.getChoteiJiyu3()).set調定事由4(計算後情報_更正前後.getChoteiJiyu4())
                .set更正月(計算後情報_更正前後.getKoseiM()).set減免前介護保険料_年額(計算後情報_更正前後.getGemmenMaeHokenryo())
                .set減免額(計算後情報_更正前後.getGemmenGaku()).set確定介護保険料_年額(計算後情報_更正前後.getKakuteiHokenryo())
                .set保険料段階_仮算定時(計算後情報_更正前後.getHokenryoDankaiKarisanntei())
                .set徴収方法履歴番号(計算後情報_更正前後.getChoshuHohoRirekiNo())
                .set異動基準日時(計算後情報_更正前後.getIdoKijunNichiji()).set口座区分(計算後情報_更正前後.getKozaKubun())
                .set境界層区分(計算後情報_更正前後.getKyokaisoKubun()).set職権区分(計算後情報_更正前後.getShokkenKubun())
                .set賦課市町村コード(計算後情報_更正前後.getFukaShichosonCode()).set特徴歳出還付額(計算後情報_更正前後.getTkSaishutsuKampuGaku())
                .set普徴歳出還付額(計算後情報_更正前後.getFuSaishutsuKampuGaku()).set月割開始年月1(計算後情報_更正前後.getTsukiwariStartYM1())
                .set月割終了年月1(計算後情報_更正前後.getTsukiwariEndYM1()).set月割開始年月2(計算後情報_更正前後.getTsukiwariStartYM2())
                .set月割終了年月2(計算後情報_更正前後.getTsukiwariEndYM2()).build();

        FukaJohoRelateEntity fukaJohoRelateEntity = new FukaJohoRelateEntity();
        fukaJohoRelateEntity.set介護賦課Entity(fuka.toEntity());
        List<KibetsuEntity> 介護期別RelateEntity = new ArrayList<>();
        for (int index = INT_1; index < INT_7; index++) {
            KibetsuEntity 介護期別Relate = new KibetsuEntity();
            DbT2003KibetsuEntity 介護期別Entity = new DbT2003KibetsuEntity();
            介護期別Entity.setChoteiNendo(計算後情報_更正前後.getChoteiNendo());
            介護期別Entity.setFukaNendo(計算後情報_更正前後.getFukaNendo());
            介護期別Entity.setTsuchishoNo(計算後情報_更正前後.getTsuchishoNo());
            介護期別Entity.setRirekiNo(計算後情報_更正前後.getFukaRirekiNo());
            介護期別Entity.setChoteiId(new Decimal(index));
            介護期別Entity.setChoshuHouhou(ChoshuHohoKibetsu.特別徴収.getコード());
            介護期別Entity.setKi(index);
            List<UrT0705ChoteiKyotsuEntity> 調定共通EntityList = new ArrayList<>();
            UrT0705ChoteiKyotsuEntity 調定共通Entity = new UrT0705ChoteiKyotsuEntity();
            調定共通Entity.setChoteiId(new Decimal(index).longValue());
            調定共通Entity.setChoteigaku(get特徴調定額(計算後情報_更正前後, index));
            調定共通EntityList.add(調定共通Entity);
            介護期別Relate.set介護期別Entity(介護期別Entity);
            介護期別Relate.set調定共通Entity(調定共通EntityList);
            介護期別RelateEntity.add(介護期別Relate);
        }
        for (int index = INT_1; index <= INT_14; index++) {
            KibetsuEntity 介護期別Relate = new KibetsuEntity();
            DbT2003KibetsuEntity 介護期別Entity = new DbT2003KibetsuEntity();
            介護期別Entity.setChoteiNendo(計算後情報_更正前後.getChoteiNendo());
            介護期別Entity.setFukaNendo(計算後情報_更正前後.getFukaNendo());
            介護期別Entity.setTsuchishoNo(計算後情報_更正前後.getTsuchishoNo());
            介護期別Entity.setRirekiNo(計算後情報_更正前後.getFukaRirekiNo());
            介護期別Entity.setChoteiId(new Decimal(index).add(Decimal.TEN));
            介護期別Entity.setChoshuHouhou(ChoshuHohoKibetsu.普通徴収.getコード());
            介護期別Entity.setKi(index);
            List<UrT0705ChoteiKyotsuEntity> 調定共通EntityList = new ArrayList<>();
            UrT0705ChoteiKyotsuEntity 調定共通Entity = new UrT0705ChoteiKyotsuEntity();
            調定共通Entity.setChoteiId(new Decimal(index).add(Decimal.TEN).longValue());
            調定共通Entity.setChoteigaku(get普通調定額(計算後情報_更正前後, index));
            調定共通EntityList.add(調定共通Entity);
            介護期別Relate.set介護期別Entity(介護期別Entity);
            介護期別Relate.set調定共通Entity(調定共通EntityList);
            介護期別RelateEntity.add(介護期別Relate);
        }
        fukaJohoRelateEntity.set介護期別RelateEntity(介護期別RelateEntity);
        FukaJoho 賦課情報 = new FukaJoho(fukaJohoRelateEntity);
        fukaAtena.set賦課情報(賦課情報);
        IKojin 宛名 = ShikibetsuTaishoFactory.createKojin(entity.get宛名());
        fukaAtena.set宛名(宛名);
        return fukaAtena;
    }

    private Decimal get特徴調定額(DbT2015KeisangoJohoEntity entity, int index) throws InvocationTargetException {
        Decimal 特徴調定額 = Decimal.ZERO;
        if (entity == null) {
            return null;
        }
        RStringBuilder sb = new RStringBuilder(定数_特徴方法.toString());
        sb.append(new RString(index).padZeroToLeft(2));
        Class clazz = entity.getClass();
        try {
            Method getMethod = clazz.getDeclaredMethod(sb.toString());
            特徴調定額 = (Decimal) getMethod.invoke(entity);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException ex) {
            Logger.getLogger(HonsanteiTsuchishoIkkatsuHakkoFath.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 特徴調定額;
    }

    private Decimal get普通調定額(DbT2015KeisangoJohoEntity entity, int index) {
        Decimal 普通調定額 = Decimal.ZERO;
        if (entity == null) {
            return null;
        }
        RStringBuilder sb = new RStringBuilder(定数_普徴方法.toString());
        sb.append(new RString(index).padZeroToLeft(2));
        Class clazz = entity.getClass();
        try {
            Method getMethod = clazz.getDeclaredMethod(sb.toString());
            普通調定額 = (Decimal) getMethod.invoke(entity);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException ex) {
            Logger.getLogger(HonsanteiTsuchishoIkkatsuHakkoFath.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 普通調定額;
    }

    private void set出力順_改頁(IOutputOrder outputOrder, List<RString> 出力順項目List, List<RString> 改ページ項目List) {

        if (outputOrder == null || outputOrder.get設定項目リスト() == null) {
            return;
        }
        int i = 1;
        for (ISetSortItem setSortItem : outputOrder.get設定項目リスト()) {
            if (i <= INT_5) {
                出力順項目List.add(setSortItem.get項目名());
                if (setSortItem.is改頁項目()) {
                    改ページ項目List.add(setSortItem.get項目名());
                }
            }
            i = i + 1;
        }
    }

    /**
     * nullの判断するメソッドです。
     *
     * @param 項目 Object
     * @return boolean 項目がnullの場合、falseを返し
     */
    public boolean isNull(Object 項目) {
        return 項目 == null;
    }

}
