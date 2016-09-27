/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD492001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.DBD492001.ErrorRecord;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.DBD492001.HenKouData;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.DBD492001.HokenShaKodochekkuEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 保険者コードチェックデータ検索_process処理クラスです。
 *
 * @reamsid_L DBD-1510-020 x_xuliang
 */
public class HokenShaKodochekkuProcess extends BatchProcessBase<HokenShaKodochekkuEntity> {

    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate."
            + "yokaigoninteikekkarenkeidetatorikomi.IHokenShaKodochekkuMapper.get保険者コードチェックデータ検索");

    private List<ErrorRecord> errorRecordList;
    private HenKouData entity;
    private ErrorRecord error;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPERPATH);
    }

    @Override
    protected void initialize() {
        errorRecordList = new ArrayList<>();
    }

    @Override
    protected void process(HokenShaKodochekkuEntity t) {
//TODO        if (!t.getShoKisaiHokenshaNo().equals(読み込んだレコードの証記載保険者番号) {
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
//        }
    }
}
