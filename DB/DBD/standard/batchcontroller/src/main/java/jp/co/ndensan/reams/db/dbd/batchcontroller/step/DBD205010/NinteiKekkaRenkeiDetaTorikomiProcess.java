/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD205010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.processprm.DBD205010.RendingJieguoLianxieProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.DBD205010.ErrorRecord;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.DBD205010.HenKouData;
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
        if (henKouDataList.size() != 328) {
            データチェック(error, entity);
        } else {
            if (!いち.equals(entity.getTorisakubunkodo().value())
                    || !に.equals(entity.getTorisakubunkodo().value())
                    || !よっ.equals(entity.getTorisakubunkodo().value())) {
                データチェック(error, entity);
            } else {
                if (!ゼロいち.equals(entity.getNijihanteikekka())
                        || !じゅうに.equals(entity.getNijihanteikekka())
                        || !じゅうさん.equals(entity.getNijihanteikekka())
                        || !にじゅういち.equals(entity.getNijihanteikekka())
                        || !にじゅうに.equals(entity.getNijihanteikekka())
                        || !にじゅうみ.equals(entity.getNijihanteikekka())
                        || !にじゅうよっ.equals(entity.getNijihanteikekka())
                        || !にじゅうご.equals(entity.getNijihanteikekka())) {
                    データチェック(error, entity);
                }
            }
        }
    }

    private void データチェック(ErrorRecord error, HenKouData entity) {
        error.setShikibetsukodo(entity.getShikibetsukodo());
        error.setHokenshabango(entity.getHokenshabango());
        error.setHihokenjabango(entity.getHihokenjabango());
        error.setNinteishinseibi(entity.getNinteishinseibi());
        error.setEdaban(entity.getEdaban());
        error.setShinseikubunhorei(entity.getShinseikubunhorei());
        error.setShinseikubunshinseiji(entity.getShinseikubunshinseiji());
        error.setTorisakubunkodo(entity.getTorisakubunkodo());
        error.setHihokenjakubun(entity.getHihokenjakubun());
        error.setShinseidaikokubun(entity.getShinseidaikokubun());
        error.setSeinengappi(entity.getSeinengappi());
        error.setNenrei(entity.getNenrei());
        error.setSeibetsukodo(entity.getSeibetsukodo());
        error.setHihokenjakanashimei(entity.getHihokenjakanashimei());
        error.setHihokenjakanjishimei(entity.getHihokenjakanjishimei());
        error.setYubenbango(entity.getYubenbango());
        error.setJusho(entity.getJusho());
        error.setTenwabango(entity.getTenwabango());
        error.setByoinshisetsutonomeisho(entity.getByoinshisetsutonomeisho());
        error.setByoinshisetsutonoshozaichi(entity.getByoinshisetsutonoshozaichi());
        errorRecordList.add(error);
    }
}
