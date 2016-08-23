/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.processprm.jizenshinsakekka;

import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.jizenshinsakekka.JizenShinsakekkaMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * 事前審査結果登録データ作成Process用パラメータクラスです。
 *
 * @reamsid_L DBE-1630-020 xuyongchao
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class JizenShinsakekkaProcessParameter implements IBatchProcessParameter {

    private final RString shinsakaiKaisaiNo;
    private final FlexibleDate shinsakaiKaisaiYoteiYMD;
    private final RString shinsakaiKaishiYoteiTime;
    private final RString shinsakaiKaisaiBashoName;
    private final int gogitaiNo;
    private final RString gogitaiMei;
    private final RString syuturyokuJun;
    private final RString syuturyokuStyle;
    private final RString insatuHouhou;
    private final RString sakuseiJyoken;
    private final RString kaishisiyoBangou;
    private final RString shuryosiyoBangou;
    private final RString iinyoFusuu;
    private final boolean tuutiFlag;
    private final boolean tokkiJikouFlag;
    private final boolean itiHenteiKekkaFlag;
    private final boolean tokkiPlusItiFlag;
    private final boolean ikensyoFlag;
    private final boolean yobiHenteiFlag;

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
    public JizenShinsakekkaProcessParameter(RString shinsakaiKaisaiNo,
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
            boolean tuutiFlag,
            boolean tokkiJikouFlag,
            boolean itiHenteiKekkaFlag,
            boolean tokkiPlusItiFlag,
            boolean ikensyoFlag,
            boolean yobiHenteiFlag) {
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
     * Mybatisのパラメータを作成します。
     *
     * @return JIzenShinsakekkaMybatisParameter
     */
    public JizenShinsakekkaMybatisParameter toJizenShinsakekkaMybatisParameter() {
        return JizenShinsakekkaMybatisParameter.createParam(shinsakaiKaisaiNo);
    }
}
