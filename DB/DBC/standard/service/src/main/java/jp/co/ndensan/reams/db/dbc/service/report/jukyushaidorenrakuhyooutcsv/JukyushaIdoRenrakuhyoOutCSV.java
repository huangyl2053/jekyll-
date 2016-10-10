/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.report.jukyushaidorenrakuhyooutcsv;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.csv.jukyushaidorenrakuhyoout.JukyushaIdoRenrakuhyoOutCSVBEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.jukyushaidorenrakuhyoout.JukyushaIdoRenrakuhyoOutCSVCEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.jukyushaidorenrakuhyoout.JukyushaIdoRenrakuhyoOutCSVDEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.jukyushaidorenrakuhyoout.JukyushaIdoRenrakuhyoOutCSVEEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.jukyushaidorenrakuhyoout.JukyushaIdoRenrakuhyoOutCSVAEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.honnsanteifuka.KyodoShoriKihonSofuTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.honnsanteifuka.KyodoShoriKooGakuTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.honnsanteifuka.KyodoShoriShouKannTempEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 共同処理用受給者異動連絡票（CSV）のクラスです。
 *
 * @reamsid_L DBC-2770-080 jinjue
 */
public class JukyushaIdoRenrakuhyoOutCSV {

    private static final RString カンマ = new RString(",");
    private static final RString ダブルクォート = new RString("\"");
    private static final RString 出力ファイル名 = new RString("kydjk0.csv");
    private static final RString 定数_ZERO = new RString("0");
    private static final RString 定数_ONE = new RString("1");
    private static final RString 定数_TWO = new RString("2");
    private static final RString 定数_THREE = new RString("3");
    private static final RString 定数_FOUR = new RString("4");
    private static final RString 定数_FIVE = new RString("5");
    private static final RString 改行 = new RString("0x0D0A");
    private static final RString 定数5C1 = new RString("5C1");
    private static final RString 定数5C11 = new RString("5C11");
    private static final RString 定数5D11 = new RString("5D11");
    private static final RString 定数5E11 = new RString("5E11");
    private static final int 定数_1 = 1;
    private CsvWriter csvWriter;
    private RString filePath;

    /**
     * {@link InstanceProvider#create}にて生成した{@link JukyushaIdoRenrakuhyoOutCSV}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link JukyushaIdoRenrakuhyoOutCSV}のインスタンス
     */
    public static JukyushaIdoRenrakuhyoOutCSV createInstance() {
        return InstanceProvider.create(JukyushaIdoRenrakuhyoOutCSV.class);
    }

    /**
     * csvの出力
     *
     * @param entityList1 データレコード基本送付
     * @param entityList2 データレコード償還送付
     * @param entityList3 データレコード高額送付
     */
    public void csvの出力(List<KyodoShoriKihonSofuTempEntity> entityList1, List<KyodoShoriShouKannTempEntity> entityList2,
            List<KyodoShoriKooGakuTempEntity> entityList3) {
        RString spoolWorkPath = Path.getTmpDirectoryPath();
        filePath = Path.combinePath(spoolWorkPath, 出力ファイル名);
        csvWriter = new CsvWriter.InstanceBuilder(filePath)
                .setDelimiter(カンマ)
                .setEnclosure(ダブルクォート)
                .setEncode(Encode.SJIS)
                .setNewLine(NewLine.CRLF)
                .hasHeader(false).build();
        csvWriter.writeLine(コントロールレド());
        for (KyodoShoriKihonSofuTempEntity entity : entityList1) {
            csvWriter.writeLine(データレコード基本送付(entity));
        }
        for (KyodoShoriShouKannTempEntity entity : entityList2) {
            csvWriter.writeLine(データレコード償還送付(entity));
        }
        for (KyodoShoriKooGakuTempEntity entity : entityList3) {
            csvWriter.writeLine(データレコード高額送付(entity));
        }
        csvWriter.writeLine(エンドレコード());
        csvWriter.close();
    }

    private JukyushaIdoRenrakuhyoOutCSVAEntity コントロールレド() {
        RString 国保連送付媒体_受給異動Ｆ_媒体区分 = DbBusinessConfig.get(ConfigNameDBC.国保連送付媒体_受給異動Ｆ_媒体区分,
                RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        RString 保険者番号 = DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者番号,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        RString 処理対象年月 = RDateTime.now().format西暦("YYYYMM");
        JukyushaIdoRenrakuhyoOutCSVAEntity csvEntity = new JukyushaIdoRenrakuhyoOutCSVAEntity(
                定数_ONE, 定数_ONE, 定数_ZERO, 定数_1, 定数5C1, 定数_ZERO,
                保険者番号, 定数_ZERO, 定数_ZERO, 国保連送付媒体_受給異動Ｆ_媒体区分, 処理対象年月, 定数_ONE, 改行);
        return csvEntity;
    }

    private JukyushaIdoRenrakuhyoOutCSVBEntity データレコード基本送付(KyodoShoriKihonSofuTempEntity entity) {
        JukyushaIdoRenrakuhyoOutCSVBEntity csvEntity = new JukyushaIdoRenrakuhyoOutCSVBEntity(定数_TWO, 定数_TWO, 定数5C11,
                set西暦(entity.get異動年月日()), entity.get異動区分コード(),
                entity.get受給者異動事由(), entity.get証記載保険者番号(),
                entity.get被保険者番号(), entity.get被保険者氏名(),
                entity.get郵便番号(), entity.get住所カナ(), entity.get住所(),
                entity.get電話番号(), entity.get帳票出力順序コード(), 改行);
        return csvEntity;
    }

    private JukyushaIdoRenrakuhyoOutCSVCEntity データレコード償還送付(KyodoShoriShouKannTempEntity entity) {
        JukyushaIdoRenrakuhyoOutCSVCEntity csvEntity = new JukyushaIdoRenrakuhyoOutCSVCEntity(定数_TWO, 定数_THREE, 定数5D11,
                set西暦(entity.get異動年月日()), entity.get異動区分コード(), entity.get受給者異動事由(),
                entity.get証記載保険者番号(), entity.get被保険者番号(),
                set西暦(entity.get保険給付支払一時差止開始年月日()), set西暦(entity.get保険給付支払一時差止終了年月日()),
                entity.get保険給付支払一時差止区分コード(), entity.get保険給付支払一時差止金額(), 改行);
        return csvEntity;
    }

    private JukyushaIdoRenrakuhyoOutCSVDEntity データレコード高額送付(KyodoShoriKooGakuTempEntity entity) {
        JukyushaIdoRenrakuhyoOutCSVDEntity csvEntity = new JukyushaIdoRenrakuhyoOutCSVDEntity(定数_TWO, 定数_FOUR, 定数5E11,
                set西暦(entity.get異動年月日()), entity.get異動区分コード(), entity.get受給者異動事由(), entity.get証記載保険者番号(),
                entity.get被保険者番号(), entity.get世帯集約番号(), entity.get世帯所得区分コード(),
                entity.get世帯所得区分コード(), entity.is老齢福祉年金受給有フラグ(),
                entity.is利用者負担第２段階有フラグ(), entity.is支給申請書出力有フラグ(), 改行);
        return csvEntity;
    }

    private JukyushaIdoRenrakuhyoOutCSVEEntity エンドレコード() {
        JukyushaIdoRenrakuhyoOutCSVEEntity csvEndEntity = new JukyushaIdoRenrakuhyoOutCSVEEntity(定数_THREE, 定数_FIVE, 改行);
        return csvEndEntity;
    }

    private RString set西暦(FlexibleDate date) {
        if (date != null) {
            return date.seireki().separator(Separator.NONE).fillType(FillType.ZERO).toDateString();
        }
        return RString.EMPTY;
    }
}
