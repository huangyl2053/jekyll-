/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD207012;

import jp.co.ndensan.reams.db.dbd.definition.core.shiharaihohokanrilist.ShiharaiHohoKanriListData;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd207010.ShiharaiHohoHenkoHaakuOneProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd207010.ShiharaiHohoHenkoKanrFiveProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd207010.ShiharaiHohoHenkoKanriProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.processprm.shiharaihohohenkolist.CreateTaishoshaJohoTempTableProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 支払方法変更管理リスト作成バッチ用のパラメータです。
 *
 * @reamsid_L DBD-3630-040 zhulx
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBD207012_ShiharaiHohoHenkoKanriListParameter extends BatchParameterBase {

    private static final String KIJUNYMD = "kijunYMD";
    private static final String TOUROKUSYASENNTAKU = "tourokuSyaSenntaku";
    private static final String SASHITOMEYOKOKU = "sashitomeYokoku";
    private static final String SASHITOME = "sashitome";
    private static final String SHOUKANNYOKOKU = "shoukannYokoku";
    private static final String SHOUKANNKETTEI = "shoukannKettei";
    private static final String SHOUKANNKETTEISASHITOME = "shoukannKetteiSashitome";
    private static final String SHOUKANNKETTEIHOKENNRYOU = "shoukannKetteiHokennryou";
    private static final String CHANGEPAGEOUTPUTJUNNID = "changePageOutputJunnId";
    private static final String REPORTBUNNRUIID = "reportBunnruiId";
    private static final String REPORTID = "reportId";
    private static final String REPORTCREATEDATETIME = "reportCreateDateTime";

    @BatchParameter(key = KIJUNYMD, name = "基準日")
    private FlexibleDate 基準日;
    @BatchParameter(key = TOUROKUSYASENNTAKU, name = "登録者選択")
    private RString 登録者選択;
    @BatchParameter(key = SASHITOMEYOKOKU, name = "差止予告登録者の選択")
    private RString 差止予告登録者の選択;
    @BatchParameter(key = SASHITOME, name = "差止登録者の選択")
    private RString 差止登録者の選択;
    @BatchParameter(key = SHOUKANNYOKOKU, name = "償還予告登録者の選択")
    private RString 償還予告登録者の選択;
    @BatchParameter(key = SHOUKANNKETTEI, name = "償還決定登録者の選択")
    private RString 償還決定登録者の選択;
    @BatchParameter(key = SHOUKANNKETTEISASHITOME, name = "償還決定登録者1の選択")
    private RString 償還決定登録者1の選択;
    @BatchParameter(key = SHOUKANNKETTEIHOKENNRYOU, name = "償還決定登録者2の選択")
    private RString 償還決定登録者2の選択;
    @BatchParameter(key = CHANGEPAGEOUTPUTJUNNID, name = "改頁出力順ID")
    private Long 改頁出力順ID;
    @BatchParameter(key = REPORTBUNNRUIID, name = "帳票分類ID")
    private ReportId 帳票分類ID;
    @BatchParameter(key = REPORTID, name = "帳票ID")
    private ReportId 帳票ID;
    @BatchParameter(key = REPORTCREATEDATETIME, name = "帳票作成日時")
    private RDateTime 帳票作成日時;

    /**
     * 画面からのパラメータを作成します。
     *
     * @param tempData 画面データ
     */
    public void toDbd207010BatchParameter(ShiharaiHohoKanriListData tempData) {
        this.基準日 = tempData.get基準日();
        this.登録者選択 = tempData.get登録者選択();
        this.差止予告登録者の選択 = tempData.get差止予告登録者の選択();
        this.差止登録者の選択 = tempData.get差止登録者の選択();
        this.償還予告登録者の選択 = tempData.get償還予告登録者の選択();
        this.償還決定登録者の選択 = tempData.get償還決定登録者の選択();
        this.償還決定登録者1の選択 = tempData.get償還決定登録者1の選択();
        this.償還決定登録者2の選択 = tempData.get償還決定登録者2の選択();
        this.改頁出力順ID = tempData.get改頁出力順ID();
        this.帳票ID = tempData.get帳票ID();
        this.帳票分類ID = tempData.get帳票分類ID();
        this.帳票作成日時 = tempData.get帳票作成日時();
    }

    /**
     * processのパラメータを生成します。
     *
     * @return processパラメータ
     */
    public CreateTaishoshaJohoTempTableProcessParameter toShiharaiHohoKanriListProcessParameter() {
        return new CreateTaishoshaJohoTempTableProcessParameter(
                this.基準日,
                this.登録者選択,
                this.差止予告登録者の選択,
                this.差止登録者の選択,
                this.償還予告登録者の選択,
                this.償還決定登録者の選択,
                this.償還決定登録者1の選択,
                this.償還決定登録者2の選択,
                this.改頁出力順ID,
                this.帳票ID.value());
    }

    /**
     * 支払方法変更管理_Processパラメター
     *
     * @return 支払方法変更管理_Processパラメター
     */
    public ShiharaiHohoHenkoKanriProcessParameter toShiharaiHohoHenkoKanriProcessParameter() {
        return new ShiharaiHohoHenkoKanriProcessParameter(基準日,
                登録者選択,
                差止予告登録者の選択,
                差止登録者の選択,
                償還予告登録者の選択,
                償還決定登録者の選択,
                償還決定登録者1の選択,
                償還決定登録者2の選択,
                改頁出力順ID,
                帳票分類ID,
                帳票ID,
                帳票作成日時);
    }

    /**
     * バッチプロセス１パラメターを取得します．
     *
     * @return バッチプロセス１
     */
    public ShiharaiHohoHenkoHaakuOneProcessParameter toShiharaiHohoHenkoHaakuOneProcessParameter() {
        return new ShiharaiHohoHenkoHaakuOneProcessParameter(基準日);
    }

    /**
     * バッチプロセス5パラメターを取得します．
     *
     * @return バッチプロセス5
     */
    public ShiharaiHohoHenkoKanrFiveProcessParameter toShiharaiHohoHenkoHaakuFiveProcessParameter() {
        return new ShiharaiHohoHenkoKanrFiveProcessParameter(基準日,
                登録者選択,
                差止予告登録者の選択,
                差止登録者の選択,
                償還予告登録者の選択,
                償還決定登録者の選択,
                償還決定登録者1の選択,
                償還決定登録者2の選択,
                改頁出力順ID,
                帳票分類ID,
                帳票ID,
                帳票作成日時);
    }
}
