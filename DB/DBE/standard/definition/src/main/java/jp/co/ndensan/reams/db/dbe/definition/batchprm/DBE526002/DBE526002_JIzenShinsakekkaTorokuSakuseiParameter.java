/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE526002;

import java.util.Map;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE517002.DBE517002_ShinsakaiShiryoIinParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.jizenshinsakekka.JizenShinsakekkaProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * 事前審査結果登録データ作成バッチ用パラメータクラスです。
 *
 * @reamsid_L DBE-1630-020 xuyongchao
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class DBE526002_JIzenShinsakekkaTorokuSakuseiParameter extends BatchParameterBase {

    private static final String SHINSAKAIKAISAINO = "shinsakaiKaisaiNo";
    private static final String SHINSAKAIKAISAIYOTEIYMD = "shinsakaiKaisaiYoteiYMD";
    private static final String SHINSAKAIKAISHIYOTEITIME = "shinsakaiKaishiYoteiTime";
    private static final String SHINSAKAIKAISAIBASHONAME = "shinsakaiKaisaiBashoName";
    private static final String GOGITAINO = "gogitaiNo";
    private static final String GOGITAIMEI = "gogitaiMei";
    private static final String SYUTURYOKUJUN = "syuturyokuJun";
    private static final String SYUTURYOKUSTYLE = "syuturyokuStyle";
    private static final String INSATUHOUHOU = "insatuHouhou";
    private static final String SAKUSEIJYOKEN = "sakuseiJyoken";
    private static final String KAISHISIYOBANGOU = "kaishisiyoBangou";
    private static final String SHURYOSIYOBANGOU = "shuryosiyoBangou";
    private static final String IINYOFUSUU = "iinyoFusuu";
    private static final String TUUTIFLAG = "tuutiFlag";
    private static final String TOKKIJIKOUFLAG = "tokkiJikouFlag";
    private static final String ITIHENTEIKEKKAFLAG = "itiHenteiKekkaFlag";
    private static final String TOKKIPLUSITIFLAG = "tokkiPlusItiFlag";
    private static final String IKENSYOFLAG = "ikensyoFlag";
    private static final String YOBIHENTEIFLAG = "yobiHenteiFlag";

    @BatchParameter(key = SHINSAKAIKAISAINO, name = "介護認定審査会開催番号")
    private RString shinsakaiKaisaiNo;
    @BatchParameter(key = SHINSAKAIKAISAIYOTEIYMD, name = "介護認定審査会開催予定年月日")
    private FlexibleDate shinsakaiKaisaiYoteiYMD;
    @BatchParameter(key = SHINSAKAIKAISHIYOTEITIME, name = "介護認定審査会開始予定時刻")
    private RString shinsakaiKaishiYoteiTime;
    @BatchParameter(key = SHINSAKAIKAISAIBASHONAME, name = "介護認定審査会開催場所名称")
    private RString shinsakaiKaisaiBashoName;
    @BatchParameter(key = GOGITAINO, name = "合議体番号")
    private int gogitaiNo;
    @BatchParameter(key = GOGITAIMEI, name = "合議体名称")
    private RString gogitaiMei;
    @BatchParameter(key = SYUTURYOKUJUN, name = "出力順")
    private RString syuturyokuJun;
    @BatchParameter(key = SYUTURYOKUSTYLE, name = "出力スタイル")
    private RString syuturyokuStyle;
    @BatchParameter(key = INSATUHOUHOU, name = "印刷方法")
    private RString insatuHouhou;
    @BatchParameter(key = SAKUSEIJYOKEN, name = "作成条件")
    private RString sakuseiJyoken;
    @BatchParameter(key = KAISHISIYOBANGOU, name = "開始資料番号")
    private RString kaishisiyoBangou;
    @BatchParameter(key = SHURYOSIYOBANGOU, name = "終了資料番号")
    private RString shuryosiyoBangou;
    @BatchParameter(key = IINYOFUSUU, name = "審査会委員用部数")
    private RString iinyoFusuu;
    @BatchParameter(key = TUUTIFLAG, name = "審査会開催通知書フラグ")
    private RString tuutiFlag;
    @BatchParameter(key = TOKKIJIKOUFLAG, name = "特記事項フラグ")
    private RString tokkiJikouFlag;
    @BatchParameter(key = ITIHENTEIKEKKAFLAG, name = "一次判定結果票フラグ")
    private RString itiHenteiKekkaFlag;
    @BatchParameter(key = TOKKIPLUSITIFLAG, name = "特記事項一次判定フラグ")
    private RString tokkiPlusItiFlag;
    @BatchParameter(key = IKENSYOFLAG, name = "主治医意見書フラグ")
    private RString ikensyoFlag;
    @BatchParameter(key = YOBIHENTEIFLAG, name = "予備判定記入表フラグ")
    private RString yobiHenteiFlag;
    private Map<RString, RString> 帳票一覧Map;

    /**
     * コンストラクタです。
     */
    public DBE526002_JIzenShinsakekkaTorokuSakuseiParameter() {

    }

    /**
     * コンストラクタです。
     *
     * @param shinsakaiKaisaiNo 介護認定審査会開催番号
     * @param shinsakaiKaisaiYoteiYMD 介護認定審査会開催予定年月日
     * @param shinsakaiKaishiYoteiTime 介護認定審査会開始予定時刻
     * @param shinsakaiKaisaiBashoName 介護認定審査会開催場所名称
     * @param gogitaiNo 合議体番号
     * @param gogitaiMei 合議体名称
     * @param syuturyokuJun 出力順
     * @param syuturyokuStyle 出力スタイル
     * @param insatuHouhou 印刷方法
     * @param sakuseiJyoken 作成条件
     * @param kaishisiyoBangou 開始資料番号
     * @param shuryosiyoBangou 終了資料番号
     * @param iinyoFusuu 審査会委員用部数
     * @param tuutiFlag 審査会開催通知書フラグ
     * @param tokkiJikouFlag 特記事項フラグ
     * @param itiHenteiKekkaFlag 一次判定結果票フラグ
     * @param tokkiPlusItiFlag 特記事項+一次判定フラグ
     * @param ikensyoFlag 主治医意見書フラグ
     * @param yobiHenteiFlag 予備判定記入表フラグ
     */
    public DBE526002_JIzenShinsakekkaTorokuSakuseiParameter(RString shinsakaiKaisaiNo,
            FlexibleDate shinsakaiKaisaiYoteiYMD,
            RString shinsakaiKaishiYoteiTime,
            RString shinsakaiKaisaiBashoName,
            int gogitaiNo,
            RString gogitaiMei,
            RString syuturyokuJun,
            RString syuturyokuStyle,
            RString insatuHouhou,
            RString sakuseiJyoken,
            RString kaishisiyoBangou,
            RString shuryosiyoBangou,
            RString iinyoFusuu,
            RString tuutiFlag,
            RString tokkiJikouFlag,
            RString itiHenteiKekkaFlag,
            RString tokkiPlusItiFlag,
            RString ikensyoFlag,
            RString yobiHenteiFlag) {
        this.shinsakaiKaisaiNo = shinsakaiKaisaiNo;
        this.shinsakaiKaisaiYoteiYMD = shinsakaiKaisaiYoteiYMD;
        this.shinsakaiKaishiYoteiTime = shinsakaiKaishiYoteiTime;
        this.shinsakaiKaisaiBashoName = shinsakaiKaisaiBashoName;
        this.gogitaiNo = gogitaiNo;
        this.gogitaiMei = gogitaiMei;
        this.syuturyokuJun = syuturyokuJun;
        this.syuturyokuStyle = syuturyokuStyle;
        this.insatuHouhou = insatuHouhou;
        this.sakuseiJyoken = sakuseiJyoken;
        this.kaishisiyoBangou = kaishisiyoBangou;
        this.shuryosiyoBangou = shuryosiyoBangou;
        this.iinyoFusuu = iinyoFusuu;
        this.tuutiFlag = tuutiFlag;
        this.tokkiJikouFlag = tokkiJikouFlag;
        this.itiHenteiKekkaFlag = itiHenteiKekkaFlag;
        this.tokkiPlusItiFlag = tokkiPlusItiFlag;
        this.ikensyoFlag = ikensyoFlag;
        this.yobiHenteiFlag = yobiHenteiFlag;
    }

    /**
     * processのパラメータを生成します。
     *
     * @return JIzenShinsakekkaProcessParameter
     */
    public JizenShinsakekkaProcessParameter toJizenShinsakekkaProcessParameter() {
        return new JizenShinsakekkaProcessParameter(shinsakaiKaisaiNo,
                shinsakaiKaisaiYoteiYMD,
                shinsakaiKaishiYoteiTime,
                shinsakaiKaisaiBashoName,
                gogitaiNo,
                gogitaiMei,
                syuturyokuJun,
                syuturyokuStyle,
                insatuHouhou,
                sakuseiJyoken,
                kaishisiyoBangou,
                shuryosiyoBangou,
                iinyoFusuu,
                tuutiFlag,
                tokkiJikouFlag,
                itiHenteiKekkaFlag,
                tokkiPlusItiFlag,
                ikensyoFlag,
                yobiHenteiFlag);
    }

    /**
     * 審査会資料一括作成（委員）のパラメータを生成します。
     *
     * @return ShiryoShinsakaiBatchParameter
     */
    public DBE517002_ShinsakaiShiryoIinParameter toShiryoShinsakaiBatchParameter() {
        int bangoStart = Integer.MIN_VALUE;
        int bangoEnd = Integer.MIN_VALUE;
        RString 作成条件 = new RString("範囲指定");
        if (作成条件.equals(sakuseiJyoken)) {
            bangoStart = Integer.valueOf(kaishisiyoBangou.toString());
            bangoEnd = Integer.valueOf(shuryosiyoBangou.toString());
        }
        return new DBE517002_ShinsakaiShiryoIinParameter(shinsakaiKaisaiNo,
                shinsakaiKaisaiYoteiYMD,
                shinsakaiKaishiYoteiTime,
                gogitaiNo,
                gogitaiMei,
                syuturyokuJun,
                syuturyokuStyle,
                insatuHouhou,
                sakuseiJyoken,
                bangoStart,
                bangoEnd,
                RString.EMPTY,
                tokkiJikouFlag,
                itiHenteiKekkaFlag,
                tokkiPlusItiFlag,
                ikensyoFlag,
                RString.EMPTY,
                tuutiFlag,
                yobiHenteiFlag,
                帳票一覧Map
        );
    }
}
