/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb021011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.createtsukibetsusuiihyo.GemmenJyoho;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.createtsukibetsusuiihyo.GokeiChi;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.createtsukibetsusuiihyo.KoumokuSyoukeyi;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.createtsukibetsusuiihyo.ICreateTsukibetsuSuiihyoMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 項目合計一時テーブルProcessクラスです。
 *
 * @reamsid_L DBB-0760-030 lishengli
 */
public class KoumokuGoukeyProcess extends BatchProcessBase<KoumokuSyoukeyi> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate."
            + "createtsukibetsusuiihyo.ICreateTsukibetsuSuiihyoMapper.get項目小計一時テーブルデータの取得");
    private static final RString TABLE_減免情報一時テーブル = new RString("TmpGemmenJyoho_Ichi");
    private static final RString TABLE_項目合計一時テーブル = new RString("TmpKoumokuGoukey_Ichi");
    private List<KoumokuSyoukeyi> koumokuSyoukeyiList;
    private ICreateTsukibetsuSuiihyoMapper iCreateTsukibetsuSuiihyoMapper;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 減免情報一時テーブル;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 項目合計一時テーブル;

    @Override
    protected void initialize() {
        koumokuSyoukeyiList = new ArrayList<>();
        iCreateTsukibetsuSuiihyoMapper = getMapper(ICreateTsukibetsuSuiihyoMapper.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        減免情報一時テーブル = new BatchEntityCreatedTempTableWriter(TABLE_減免情報一時テーブル,
                GemmenJyoho.class);
        項目合計一時テーブル = new BatchEntityCreatedTempTableWriter(TABLE_項目合計一時テーブル,
                GokeiChi.class);
    }

    @Override
    protected void process(KoumokuSyoukeyi koumokuSyoukeyi) {
        koumokuSyoukeyiList.add(koumokuSyoukeyi);
    }

    @Override
    protected void afterExecute() {
        データ合計();
        減免部分の人数と金額の計算();
    }

    private void 減免部分の人数と金額の計算() {
        List<GemmenJyoho> gemmenJyoholist = iCreateTsukibetsuSuiihyoMapper.get該当段階の過年度の人数と金額合計();
        for (GemmenJyoho gemmenJyoho : gemmenJyoholist) {
            減免情報一時テーブル.insert(gemmenJyoho);
        }
    }

    private void データ合計() {
        for (KoumokuSyoukeyi koumokuSyoukeyi : koumokuSyoukeyiList) {
            if (koumokuSyoukeyi != null) {
                GokeiChi gokeiChi = new GokeiChi();
                gokeiChi.setChoshuHouhou(koumokuSyoukeyi.getChoshuHouhou());
                gokeiChi.setHokenryoDankai(koumokuSyoukeyi.getHokenryoDankai());
                gokeiChi.setYoGetuNinsuuGoukeyi(getNinsuOrKinkakul(koumokuSyoukeyi.getYoGetuNinsu()));
                gokeiChi.setYoGetuKinkakuGoukeyi(getNinsuOrKinkakul(koumokuSyoukeyi.getYoGetuKinkaku()));
                gokeiChi.setGoGetuNinsuuGoukeyi(getNinsuOrKinkakul(koumokuSyoukeyi.getGoGetuNinsu()));
                gokeiChi.setGoGetuKinkakuGoukeyi(getNinsuOrKinkakul(koumokuSyoukeyi.getGoGetuKinkaku()));
                gokeiChi.setRokuGetuNinsuuGoukeyi(getNinsuOrKinkakul(koumokuSyoukeyi.getRokuGetuNinsu()));
                gokeiChi.setRokuGetuKinkakuGoukeyi(getNinsuOrKinkakul(koumokuSyoukeyi.getRokuGetuKinkaku()));
                gokeiChi.setNanaGetuNinsuuGoukeyi(getNinsuOrKinkakul(koumokuSyoukeyi.getNanaGetuNinsu()));
                gokeiChi.setNanaGetuKinkakuGoukeyi(getNinsuOrKinkakul(koumokuSyoukeyi.getNanaGetuKinkaku()));
                gokeiChi.setHatiGetuNinsuuGoukeyi(getNinsuOrKinkakul(koumokuSyoukeyi.getHatiGetuNinsu()));
                gokeiChi.setHatiGetuKinkakuGoukeyi(getNinsuOrKinkakul(koumokuSyoukeyi.getHatiGetuKinkaku()));
                gokeiChi.setKyuGetuNinsuuGoukeyi(getNinsuOrKinkakul(koumokuSyoukeyi.getKyuGetuNinsu()));
                gokeiChi.setKyuGetuKinkakuGoukeyi(getNinsuOrKinkakul(koumokuSyoukeyi.getKyuGetuKinkaku()));
                gokeiChi.setJyuGetuNinsuuGoukeyi(getNinsuOrKinkakul(koumokuSyoukeyi.getJyuGetuNinsu()));
                gokeiChi.setJyuGetuKinkakuGoukeyi(getNinsuOrKinkakul(koumokuSyoukeyi.getJyuGetuKinkaku()));
                gokeiChi.setJyuitiGetuNinsuuGoukeyi(getNinsuOrKinkakul(koumokuSyoukeyi.getJyuitiGetuNinsu()));
                gokeiChi.setJyuitiGetuKinkakuGoukeyi(getNinsuOrKinkakul(koumokuSyoukeyi.getJyuitiGetuKinkaku()));
                gokeiChi.setJyuniGetuNinsuuGoukeyi(getNinsuOrKinkakul(koumokuSyoukeyi.getJyuniGetuNinsu()));
                gokeiChi.setJyuniGetuKinkakuGoukeyi(getNinsuOrKinkakul(koumokuSyoukeyi.getJyuniGetuKinkaku()));
                gokeiChi.setItiGetuNinsuuGoukeyi(getNinsuOrKinkakul(koumokuSyoukeyi.getItiGetuNinsu()));
                gokeiChi.setItiGetuKinkakuGoukeyi(getNinsuOrKinkakul(koumokuSyoukeyi.getItiGetuKinkaku()));
                gokeiChi.setNiGetuNinsuuGoukeyi(getNinsuOrKinkakul(koumokuSyoukeyi.getNiGetuNinsu()));
                gokeiChi.setNiGetuKinkakuGoukeyi(getNinsuOrKinkakul(koumokuSyoukeyi.getNiGetuKinkaku()));
                gokeiChi.setSanGetuNinsuuGoukeyi(getNinsuOrKinkakul(koumokuSyoukeyi.getSanGetuNinsu()));
                gokeiChi.setSanGetuKinkakuGoukeyi(getNinsuOrKinkakul(koumokuSyoukeyi.getSanGetuKinkaku()));
                gokeiChi.set現年随時の人数合計(getNinsuOrKinkakul(koumokuSyoukeyi.getGennenSuyijiNinsu()));
                gokeiChi.set現年随時の金額合計(getNinsuOrKinkakul(koumokuSyoukeyi.getGennenSuyijiKinkaku()));
                gokeiChi.set過年度の人数合計(getNinsuOrKinkakul(koumokuSyoukeyi.getKanendoNinsu()));
                gokeiChi.set過年度の金額合計(getNinsuOrKinkakul(koumokuSyoukeyi.getKanendoKinkaku()));
                gokeiChi.set歳出還付の人数合計(getNinsuOrKinkakul(koumokuSyoukeyi.getSayisyutuKanpuNinsu()));
                gokeiChi.set歳出還付の金額合計(getNinsuOrKinkakul(koumokuSyoukeyi.getSayisyutuKanpuKinkaku()));
                gokeiChi.set該当段階の人数合計(get該当段階の人数合計(koumokuSyoukeyi));
                gokeiChi.set該当段階の金額合計(get該当段階の金額合計(koumokuSyoukeyi));
                項目合計一時テーブル.insert(gokeiChi);
            }
        }
    }

    private Decimal getNinsuOrKinkakul(Decimal ninsuOrKinkaku) {
        return ninsuOrKinkaku == null ? new Decimal(0) : ninsuOrKinkaku;
    }

    private int chickNull(Decimal ninsuOrKinkaku) {
        return ninsuOrKinkaku == null ? 0 : ninsuOrKinkaku.intValue();
    }

    private Decimal get該当段階の人数合計(KoumokuSyoukeyi koumokuSyoukeyi) {
        return new Decimal(chickNull(koumokuSyoukeyi.getYoGetuNinsu()) + chickNull(koumokuSyoukeyi.getGoGetuNinsu())
                + chickNull(koumokuSyoukeyi.getRokuGetuNinsu()) + chickNull(koumokuSyoukeyi.getNanaGetuNinsu())
                + chickNull(koumokuSyoukeyi.getHatiGetuNinsu()) + chickNull(koumokuSyoukeyi.getKyuGetuNinsu())
                + chickNull(koumokuSyoukeyi.getJyuGetuNinsu()) + chickNull(koumokuSyoukeyi.getJyuitiGetuNinsu())
                + chickNull(koumokuSyoukeyi.getJyuniGetuNinsu()) + chickNull(koumokuSyoukeyi.getItiGetuNinsu())
                + chickNull(koumokuSyoukeyi.getNiGetuNinsu()) + chickNull(koumokuSyoukeyi.getSanGetuNinsu())
                + chickNull(koumokuSyoukeyi.getGennenSuyijiNinsu()) + chickNull(koumokuSyoukeyi.getKanendoNinsu()));
    }

    private Decimal get該当段階の金額合計(KoumokuSyoukeyi koumokuSyoukeyi) {
        return new Decimal(chickNull(koumokuSyoukeyi.getYoGetuKinkaku()) + chickNull(koumokuSyoukeyi.getGoGetuKinkaku())
                + chickNull(koumokuSyoukeyi.getRokuGetuKinkaku()) + chickNull(koumokuSyoukeyi.getNanaGetuKinkaku())
                + chickNull(koumokuSyoukeyi.getHatiGetuKinkaku()) + chickNull(koumokuSyoukeyi.getKyuGetuKinkaku())
                + chickNull(koumokuSyoukeyi.getJyuGetuKinkaku()) + chickNull(koumokuSyoukeyi.getJyuitiGetuKinkaku())
                + chickNull(koumokuSyoukeyi.getJyuniGetuKinkaku()) + chickNull(koumokuSyoukeyi.getItiGetuKinkaku())
                + chickNull(koumokuSyoukeyi.getNiGetuKinkaku()) + chickNull(koumokuSyoukeyi.getSanGetuKinkaku())
                + chickNull(koumokuSyoukeyi.getGennenSuyijiKinkaku()) + chickNull(koumokuSyoukeyi.getKanendoKinkaku()));
    }
}
