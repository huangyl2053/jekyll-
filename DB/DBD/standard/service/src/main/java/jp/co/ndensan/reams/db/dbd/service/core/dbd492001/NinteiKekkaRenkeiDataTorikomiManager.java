/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.dbd492001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.dbd492001.Csvfileeditbusiness;
import jp.co.ndensan.reams.db.dbd.business.core.dbd492001.ErrordataIchijiTeburubusiness;
import jp.co.ndensan.reams.db.dbd.business.core.dbd492001.FairuYishiteburubusiness;
import jp.co.ndensan.reams.db.dbd.business.core.dbd492001.FairudetaIchijiTeburubusiness;
import jp.co.ndensan.reams.db.dbd.business.core.dbd492001.Jinbunobusiness;
import jp.co.ndensan.reams.db.dbd.business.core.dbd492001.NinteiKekkaRenkeiDataTorikomi;
import jp.co.ndensan.reams.db.dbd.business.core.dbd492001.YokaigoninteiIntafesebusiness;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd492001.RendingJieguoLianxieProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd492001.HenKouData;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd492001.OutFile;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd492001.OutFilekekka;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd492001.ShinchokuNoTorikomiRisutoFairuCSVEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd492001.TorikomiErarisutofairuCSVEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd492001.ichijiteburu.ErrordataIchijiTeburuEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd492001.ichijiteburu.FairudetaIchijiTeburuEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd492001.ichijiteburu.JinbunoQurirumirisutofairuYishiteburuEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd492001.ichijiteburu.NichijiShinchokuIchijiTeburuEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4003YokaigoNinteiInterfaceEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.EucFileOutputJokenhyoItem;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 出力ファイルのデータの編集クラスです．
 *
 * @reamsid_L DBD-1510-030 x_xuliang
 */
public class NinteiKekkaRenkeiDataTorikomiManager {

    private static final RString 一時デーブル_日次進捗 = new RString("1");
    private static final RString 一時デーブル_認定結果 = new RString("2");
    private final RString 進捗の取込みリストファイル = new RString("進捗の取込みリストファイル");
    private final RString 結果の取込みリストファイル = new RString("結果の取込みリストファイル");
    private final RString 英数字_進捗の取込みリストファイル = new RString("SinchokuNoTorikomiList.CSV");
    private final RString 英数字_結果の取込みリストファイル = new RString("KekkaNoTorikomiList.CSV");
    private final RString 進捗の取込みエラーリストファイル = new RString("進捗の取込みエラーリストファイル");
    private final RString 結果の取込みエラーリストファイル = new RString("結果の取込みエラーリストファイル");
    private final RString 英数字_進捗の取込みエラーリストファイル = new RString("SinchokuNoTorikomiErrList.CSV");
    private final RString 英数字_結果の取込みエラーリストファイル = new RString("KekkaNoTorikomiErrList.CSV");
    private final RString 市町村コード = new RString("【市町村コード】");
    private final RString 市町村名称 = new RString("【市町村名称】");
    private final RString 証記載保険者番号 = new RString("【証記載保険者番号】");
    private final RString 保険者区分 = new RString("【保険者区分】");

    /**
     * NinteiKekkaRenkeiDataTorikomiManagerのインスタンス化
     *
     * @return NinteiKekkaRenkeiDataTorikomiManager
     */
    public static NinteiKekkaRenkeiDataTorikomiManager createInstance() {
        return InstanceProvider.create(NinteiKekkaRenkeiDataTorikomiManager.class);
    }

    /**
     * 項目設定
     *
     * @param t t
     * @param out out
     */
    public void 項目設定(OutFile t, OutFilekekka out) {
        NinteiKekkaRenkeiDataTorikomi but = new NinteiKekkaRenkeiDataTorikomi();
        but.ninteiKekkaRenkeiDataTorikomiBusiness(t, out);
    }

    /**
     * 進捗の取込みエラー項目設定
     *
     * @param errormessage RString
     * @param list List<RString>
     * @param entity ErrordataIchijiTeburuEntity
     */
    public void 進捗の取込みエラー項目設定(RString errormessage, List<RString> list, ErrordataIchijiTeburuEntity entity) {
        ErrordataIchijiTeburubusiness but = new ErrordataIchijiTeburubusiness();
        but.editErrordata(errormessage, list, entity);
    }

    /**
     * エラー項目設定
     *
     * @param errormessage RString
     * @param henkouentity HenKouData
     * @param entity ErrordataIchijiTeburuEntity
     */
    public void エラー項目設定(RString errormessage, HenKouData henkouentity, ErrordataIchijiTeburuEntity entity) {
        ErrordataIchijiTeburubusiness but = new ErrordataIchijiTeburubusiness();
        but.editErrordatabyHenKou(errormessage, henkouentity, entity);
    }

    /**
     * 日次進捗一時項目設定
     *
     * @param list List<RString>
     * @param entity NichijiShinchokuIchijiTeburuEntity
     */
    public void 日次進捗一時項目設定(List<RString> list, NichijiShinchokuIchijiTeburuEntity entity) {
        FairudetaIchijiTeburubusiness but = new FairudetaIchijiTeburubusiness();
        but.editFairudeta(list, entity);
    }

    /**
     * ファイルデータ一時テーブル
     *
     * @param entity HenKouData
     * @param fairu FairudetaIchijiTeburuEntity
     */
    public void ファイルデータ一時テーブル(HenKouData entity, FairudetaIchijiTeburuEntity fairu) {
        FairuYishiteburubusiness but = new FairuYishiteburubusiness();
        but.editteburu(entity, fairu);
    }

    /**
     * 進捗の取込みリストファイル一時テーブル
     *
     * @param entity JinbunoQurirumirisutofairuYishiteburuEntity
     * @param kekka OutFilekekka
     */
    public void 進捗の取込みリストファイル一時テーブル(JinbunoQurirumirisutofairuYishiteburuEntity entity, OutFilekekka kekka) {
        Jinbunobusiness but = new Jinbunobusiness();
        but.editjinbun(entity, kekka);
    }

    /**
     * 進捗の取込みリストファイル一時テーブル
     *
     * @param f FairudetaIchijiTeburuEntity
     * @param entity DbT4003YokaigoNinteiInterfaceEntity
     */
    public void create要介護認定インターフェースマスタル(FairudetaIchijiTeburuEntity f, DbT4003YokaigoNinteiInterfaceEntity entity) {
        YokaigoninteiIntafesebusiness but = new YokaigoninteiIntafesebusiness();
        but.editDbT4003Yokaigo(f, entity);
    }

    /**
     * ファイル出力進捗の取込みリストファイル
     *
     * @param csventity ShinchokuNoTorikomiRisutoFairuCSVEntity
     * @param entity JinbunoQurirumirisutofairuYishiteburuEntity
     */
    public void ファイル出力進捗の取込みリストファイル(ShinchokuNoTorikomiRisutoFairuCSVEntity csventity,
            JinbunoQurirumirisutofairuYishiteburuEntity entity) {
        Csvfileeditbusiness but = new Csvfileeditbusiness();
        but.editFairuCSV(csventity, entity);
    }

    /**
     * ファイル出力進捗の取込みエラーリストファイル
     *
     * @param csventity TorikomiErarisutofairuCSVEntity
     * @param entity ErrordataIchijiTeburuEntity
     */
    public void ファイル出力進捗の取込みエラーリストファイル(TorikomiErarisutofairuCSVEntity csventity, ErrordataIchijiTeburuEntity entity) {
        Csvfileeditbusiness but = new Csvfileeditbusiness();
        but.editErarCsv(csventity, entity);
    }

    /**
     * ファイルバッチ出力条件リストの出力
     *
     * @param association Association
     * @param processParameter RendingJieguoLianxieProcessParameter
     * @param count int
     * @return EucFileOutputJokenhyoItem
     *
     */
    public EucFileOutputJokenhyoItem ファイルバッチ出力条件リストの出力(Association association,
            RendingJieguoLianxieProcessParameter processParameter, long count) {
        RString 導入団体コード = association.getLasdecCode_().value();
        RString 市町村名 = association.get市町村名();
        RString ジョブ番号 = new RString(String.valueOf(JobContextHolder.getJobId()));
        RString eUCエンティティID = new RString("-");
        RString 出力件数 = new RString(String.valueOf(count));
        List<RString> 出力条件 = new ArrayList<>();
        出力条件.add(市町村コード.concat(processParameter.get市町村コード()));
        出力条件.add(市町村名称.concat(processParameter.get市町村名称()));
        出力条件.add(証記載保険者番号.concat(processParameter.get証記載保険者番号()));
        出力条件.add(保険者区分.concat(processParameter.get保険者区分()));
        if (一時デーブル_日次進捗.equals(processParameter.get取込みデータ区分())) {
            EucFileOutputJokenhyoItem item = new EucFileOutputJokenhyoItem(
                    進捗の取込みリストファイル,
                    導入団体コード,
                    市町村名,
                    ジョブ番号,
                    英数字_進捗の取込みリストファイル,
                    eUCエンティティID,
                    出力件数,
                    出力条件);
            return item;
        } else if (一時デーブル_認定結果.equals(processParameter.get取込みデータ区分())) {
            EucFileOutputJokenhyoItem item = new EucFileOutputJokenhyoItem(
                    結果の取込みリストファイル,
                    導入団体コード,
                    市町村名,
                    ジョブ番号,
                    英数字_結果の取込みリストファイル,
                    eUCエンティティID,
                    出力件数,
                    出力条件);
            return item;
        }
        return null;
    }

    /**
     * ファイルバッチ出力条件リストの出力
     *
     * @param association Association
     * @param processParameter RendingJieguoLianxieProcessParameter
     * @param count int
     * @return EucFileOutputJokenhyoItem
     *
     */
    public EucFileOutputJokenhyoItem エラーバッチ出力条件リストの出力(Association association,
            RendingJieguoLianxieProcessParameter processParameter, long count) {
        RString 導入団体コード = association.getLasdecCode_().value();
        RString 市町村名 = association.get市町村名();
        RString ジョブ番号 = new RString(String.valueOf(JobContextHolder.getJobId()));
        RString eUCエンティティID = new RString("-");
        RString 出力件数 = new RString(String.valueOf(count));
        List<RString> 出力条件 = new ArrayList<>();
        出力条件.add(市町村コード.concat(processParameter.get市町村コード()));
        出力条件.add(市町村名称.concat(processParameter.get市町村名称()));
        出力条件.add(証記載保険者番号.concat(processParameter.get証記載保険者番号()));
        出力条件.add(保険者区分.concat(processParameter.get保険者区分()));

        if (一時デーブル_日次進捗.equals(processParameter.get取込みデータ区分())) {
            EucFileOutputJokenhyoItem item = new EucFileOutputJokenhyoItem(
                    進捗の取込みエラーリストファイル,
                    導入団体コード,
                    市町村名,
                    ジョブ番号,
                    英数字_進捗の取込みエラーリストファイル,
                    eUCエンティティID,
                    出力件数,
                    出力条件);
            return item;
        } else if (一時デーブル_認定結果.equals(processParameter.get取込みデータ区分())) {
            EucFileOutputJokenhyoItem item = new EucFileOutputJokenhyoItem(
                    結果の取込みエラーリストファイル,
                    導入団体コード,
                    市町村名,
                    ジョブ番号,
                    英数字_結果の取込みエラーリストファイル,
                    eUCエンティティID,
                    出力件数,
                    出力条件);
            return item;
        }
        return null;
    }
}
