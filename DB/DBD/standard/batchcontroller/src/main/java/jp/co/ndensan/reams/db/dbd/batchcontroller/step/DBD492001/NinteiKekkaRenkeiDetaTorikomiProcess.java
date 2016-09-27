/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD492001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd492001.RendingJieguoLianxieProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd492001.ErrorRecord;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd492001.HenKouData;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチパラメータ．データリストより、変更したいデータを取得する_process処理クラスです。
 *
 * @reamsid_L DBD-1510-020 x_xuliang
 */
public class NinteiKekkaRenkeiDetaTorikomiProcess extends BatchProcessBase<HenKouData> {

    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate."
            + "yokaigoninteikekkarenkeidetatorikomi.INinteiKekkaRenkeiDetaTorikomiMapper.get変更したいデータを取得する");

    private static final RString 一時デーブル_日次進捗 = new RString("日次進捗");
    private static final RString 一時デーブル_認定結果 = new RString("認定結果");

    private final RString いち = new RString("1");
    private final RString ゼロいち = new RString("01");
    private final RString に = new RString("2");
    private final RString よっ = new RString("4");
    private final RString じゅうに = new RString("12");
    private final RString じゅうさん = new RString("13");
    private final RString にじゅういち = new RString("21");
    private final RString にじゅうに = new RString("22");
    private final RString にじゅうみ = new RString("23");
    private final RString にじゅうよっ = new RString("25");
    private final RString にじゅうご = new RString("25");

    private List<ErrorRecord> errorRecordList;
    private List<HenKouData> henKouDataList;
    private RString 一時デーブル;
    private final int 項目数 = 328;

    private RendingJieguoLianxieProcessParameter processParameter;

    @Override
    protected IBatchReader createReader() {
        if (一時デーブル_日次進捗.equals(processParameter.get取込みデータ区分())) {
            一時デーブル = new RString("1");
        } else if (一時デーブル_認定結果.equals(processParameter.get取込みデータ区分())) {
            一時デーブル = new RString("2");
        }
        return new BatchDbReader(MAPPERPATH, processParameter.toRendingJieguoLianxieMybatisParameter(一時デーブル));
    }

    @Override
    protected void initialize() {
        errorRecordList = new ArrayList<>();
        henKouDataList = new ArrayList<>();
    }

    @Override
    protected void process(HenKouData entity) {
        ErrorRecord error = new ErrorRecord();
        if (henKouDataList.size() != 項目数) {
            データチェック(error, entity);
        } else {
            if (!いち.equals(entity.get取下区分コード().value())
                    || !に.equals(entity.get取下区分コード().value())
                    || !よっ.equals(entity.get取下区分コード().value())) {
                データチェック(error, entity);
            } else {
                if (!ゼロいち.equals(entity.get二次判定結果())
                        || !じゅうに.equals(entity.get二次判定結果())
                        || !じゅうさん.equals(entity.get二次判定結果())
                        || !にじゅういち.equals(entity.get二次判定結果())
                        || !にじゅうに.equals(entity.get二次判定結果())
                        || !にじゅうみ.equals(entity.get二次判定結果())
                        || !にじゅうよっ.equals(entity.get二次判定結果())
                        || !にじゅうご.equals(entity.get二次判定結果())) {
                    データチェック(error, entity);
                }
            }
        }
    }

    private void データチェック(ErrorRecord error, HenKouData entity) {
        error.setShikibetsukodo(entity.get識別コード());
        error.setHokenshabango(entity.get保険者番号());
        error.setHihokenjabango(entity.get被保険者番号());
        error.setNinteishinseibi(entity.get認定申請日());
        error.setEdaban(entity.get枝番());
        error.setShinseikubunhorei(entity.get申請区分_法令コード());
        error.setShinseikubunshinseiji(entity.get申請区分_申請時コード());
        error.setTorisakubunkodo(entity.get取下区分コード());
        error.setHihokenjakubun(entity.get被保険者区分コード());
        error.setShinseidaikokubun(entity.get申請代行区分コード());
        error.setSeinengappi(entity.get生年月日());
        error.setNenrei(entity.get年齢());
        error.setSeibetsukodo(entity.get性別コード());
        error.setHihokenjakanashimei(entity.get被保険者ｶﾅ氏名());
        error.setHihokenjakanjishimei(entity.get被保険者漢字氏名());
        error.setYubenbango(entity.get郵便番号());
        error.setJusho(entity.get住所());
        error.setTenwabango(entity.get電話番号());
        error.setByoinshisetsutonomeisho(entity.get病院施設等の名称());
        error.setByoinshisetsutonoshozaichi(entity.get病院施設等の所在地());
        errorRecordList.add(error);
    }
}
