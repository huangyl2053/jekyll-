/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.relate.kyodoshoriyojukyushaidorenrakuhyoerrorteisei;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.jukyusyaidoujohorirek.JukyusyaIdouJohoRirekEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kyodoshoriyojukyushaidorenrakuhyoerrorteisei.KyodoshoriyoJukyushaIdoRenrakuhyoErrorTeiseiCSVEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvListReader;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 共同処理用受給者異動連絡票エラー訂正のクラスです。
 *
 * @reamsid_L DBC-2770-070 jinjue
 */
public class KyodoshoriyoJukyushaIdoRenrakuhyoErrorTeisei {

    private static final RString カンマ = new RString(",");
    private static final RString スラッシュ = new RString("／");
    private static final RString 読点 = new RString("、");
    private static final Integer INDEX_ZERO = 0;
    private static final Integer INDEX_FOUR = 4;
    private static final Integer INDEX_FIVE = 5;
    private static final Integer INDEX_SIX = 6;
    private static final Integer INDEX_SEVEN = 7;
    private static final Integer INDEX_TWENTY_TWO = 22;
    private static final Integer INDEX_THIRTY_SEVEN = 37;
    private static final Integer NUM_TEN = 10;
    private static final Integer NUM_NINE = 9;

    /**
     * コンストラクタです。
     */
    KyodoshoriyoJukyushaIdoRenrakuhyoErrorTeisei() {
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KyodoshoriyoJukyushaIdoRenrakuhyoErrorTeisei}のインスタンスを返します。
     *
     * @return KyodoshoriyoJukyushaIdoRenrakuhyoErrorTeisei
     */
    public static KyodoshoriyoJukyushaIdoRenrakuhyoErrorTeisei createInstance() {
        return InstanceProvider.create(KyodoshoriyoJukyushaIdoRenrakuhyoErrorTeisei.class);
    }

    /**
     * 履歴訂正リスト（CSV）より、履歴訂正内容を取得します。
     *
     * @param file 履歴訂正リストCSV
     * @return 履歴訂正Entity
     */
    public List<JukyusyaIdouJohoRirekEntity> getRirekiTeiseiJoho(File file) {
        JukyusyaIdouJohoRirekEntity 履歴訂正Entity;
        List<JukyusyaIdouJohoRirekEntity> list = new ArrayList<>();
        try (CsvListReader csvReader = new CsvListReader.InstanceBuilder(new RString(file.getAbsolutePath()))
                .setDelimiter(カンマ).setEncode(Encode.UTF_8)
                .hasHeader(true).setNewLine(NewLine.CRLF).build()) {
            while (true) {
                List<RString> data = csvReader.readLine();
                履歴訂正Entity = new JukyusyaIdouJohoRirekEntity();
                if (data != null && !data.isEmpty()) {
                    履歴訂正Entity.set被保番号(new HihokenshaNo(data.get(INDEX_FOUR)));
                    履歴訂正Entity.setかな氏名(data.get(INDEX_FIVE));
                    履歴訂正Entity.set異動日(new FlexibleDate(data.get(INDEX_SIX)));
                    List<RString> 訂正情報の項目List = new ArrayList<>();
                    List<RString> 訂正情報の送付済内容List = new ArrayList<>();
                    List<RString> 訂正情報の訂正内容List = new ArrayList<>();
                    for (Integer i = INDEX_SEVEN; i < INDEX_SEVEN + NUM_TEN; i++) {
                        訂正情報の項目List.add(data.get(i));
                    }
                    for (Integer j = INDEX_TWENTY_TWO; j < INDEX_TWENTY_TWO + NUM_TEN; j++) {
                        訂正情報の送付済内容List.add(data.get(j));
                    }
                    for (Integer k = INDEX_THIRTY_SEVEN; k < INDEX_THIRTY_SEVEN + NUM_TEN; k++) {
                        訂正情報の訂正内容List.add(data.get(k));
                    }
                    RString 項目 = RString.EMPTY;
                    for (Integer i = INDEX_ZERO; i < NUM_TEN; i++) {
                        項目 = 項目.concat(訂正情報の項目List.get(i)).concat(スラッシュ)
                                .concat(訂正情報の送付済内容List.get(i)).concat(スラッシュ).concat(訂正情報の訂正内容List.get(i));
                        if (i < NUM_NINE) {
                            項目 = 項目.concat(読点);
                        }
                    }
                    履歴訂正Entity.set項目(項目);
                    list.add(履歴訂正Entity);
                } else {
                    break;
                }
            }
            csvReader.close();
        }
        return list;
    }

    /**
     * 履歴訂正リスト（CSV）ファイルより指定データを削除します。
     *
     * @param file ファイル
     * @param 被保険者番号 被保険者番号
     * @param 異動日 異動日
     */
    public void deleteRirekiTeiseiJoho(File file, HihokenshaNo 被保険者番号, FlexibleDate 異動日) {

        List<JukyusyaIdouJohoRirekEntity> list = this.getRirekiTeiseiJoho(file);
        KyodoshoriyoJukyushaIdoRenrakuhyoErrorTeiseiCSVEntity csvEntity = new KyodoshoriyoJukyushaIdoRenrakuhyoErrorTeiseiCSVEntity();
        try (CsvWriter<KyodoshoriyoJukyushaIdoRenrakuhyoErrorTeiseiCSVEntity> csvWriter = new CsvWriter.InstanceBuilder(
                new RString(file.getAbsolutePath())).
                setDelimiter(カンマ).
                setEncode(Encode.UTF_8withBOM).
                hasHeader(false).
                build()) {
            for (JukyusyaIdouJohoRirekEntity entity : list) {
                if (!異動日.equals(entity.get異動日()) || !被保険者番号.equals(entity.get被保番号())) {
                    csvEntity.setかな氏名(entity.getかな氏名());
                    csvEntity.set異動日(entity.get異動日());
                    csvEntity.set被保番号(entity.get被保番号().getColumnValue());
                    csvEntity.set項目(entity.get項目());
                    csvWriter.writeLine(csvEntity);
                }
            }
        }
    }
}
