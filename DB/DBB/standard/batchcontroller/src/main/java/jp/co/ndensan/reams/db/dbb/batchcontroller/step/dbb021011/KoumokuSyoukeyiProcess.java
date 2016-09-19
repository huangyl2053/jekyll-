/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb021011;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.createtsukibetsusuiihyo.CreateTsukibetsuSuiihyoMyBatisParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.createtsukibetsusuiihyo.CreateTsukibetsuSuiihyoProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.createtsukibetsusuiihyo.GemmenJyoho;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.createtsukibetsusuiihyo.KoumokuSyoukeyi;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.createtsukibetsusuiihyo.NinsuKinkaku;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.createtsukibetsusuiihyo.ICreateTsukibetsuSuiihyoMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 項目小計一時テーブルProcessクラスです。
 *
 * @reamsid_L DBB-0760-030 lishengli
 */
public class KoumokuSyoukeyiProcess extends BatchProcessBase<NinsuKinkaku> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate."
            + "createtsukibetsusuiihyo.ICreateTsukibetsuSuiihyoMapper.get減免部分の人数と金額");
    private static final RString 四月 = new RString("04");
    private static final RString 五月 = new RString("05");
    private static final RString 六月 = new RString("06");
    private static final RString 七月 = new RString("07");
    private static final RString 八月 = new RString("08");
    private static final RString 九月 = new RString("09");
    private static final RString 十月 = new RString("10");
    private static final RString 十一月 = new RString("11");
    private static final RString 十二月 = new RString("12");
    private static final RString 一月 = new RString("01");
    private static final RString 二月 = new RString("02");
    private static final RString 三月 = new RString("03");
    private static final RString TABLE_減免情報一時テーブル = new RString("TmpGemmenJyoho_Ichi");
    private static final RString TABLE_項目小計一時テーブル = new RString("TmpKoumokuSyoukeyi_Ichi");
    private List<NinsuKinkaku> ninsuKinkakuList;
    private CreateTsukibetsuSuiihyoProcessParameter processPrm;
    private CreateTsukibetsuSuiihyoMyBatisParameter mybatisPrm;
    private ICreateTsukibetsuSuiihyoMapper iCreateTsukibetsuSuiihyoMapper;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 減免情報一時テーブル;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 項目小計一時テーブル;

    @Override
    protected void initialize() {
        mybatisPrm = processPrm.toCreateTsukibetsuSuiihyoMyBatisParameter();
        iCreateTsukibetsuSuiihyoMapper = getMapper(ICreateTsukibetsuSuiihyoMapper.class);
        ninsuKinkakuList = new ArrayList<>();
    }

    @Override
    protected IBatchReader createReader() {
        CreateTsukibetsuSuiihyoMyBatisParameter parameter = CreateTsukibetsuSuiihyoMyBatisParameter
                .create_過年度人数と金額の取得(mybatisPrm.getChoteiNendo());
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter);
    }

    @Override
    protected void createWriter() {
        減免情報一時テーブル = new BatchEntityCreatedTempTableWriter(TABLE_減免情報一時テーブル,
                GemmenJyoho.class);
        項目小計一時テーブル = new BatchEntityCreatedTempTableWriter(TABLE_項目小計一時テーブル,
                KoumokuSyoukeyi.class);
    }

    @Override
    protected void process(NinsuKinkaku ninsuKinkaku) {
        ninsuKinkakuList.add(ninsuKinkaku);
    }

    @Override
    protected void afterExecute() {
        set項目小計();
        減免部分の人数と金額の計算();
    }

    private List<NinsuKinkaku> get4月の人数金額の取得() {
        CreateTsukibetsuSuiihyoMyBatisParameter parameter = CreateTsukibetsuSuiihyoMyBatisParameter
                .create_4月人数と金額の取得(mybatisPrm.getChoteiNendo());
        return iCreateTsukibetsuSuiihyoMapper.get4月の人数金額(parameter);
    }

    private List<NinsuKinkaku> get5月の人数金額の取得() {
        CreateTsukibetsuSuiihyoMyBatisParameter parameter = CreateTsukibetsuSuiihyoMyBatisParameter
                .create_4月人数と金額の取得(mybatisPrm.getChoteiNendo());
        return iCreateTsukibetsuSuiihyoMapper.get5月の人数金額(parameter);
    }

    private List<NinsuKinkaku> get6月の人数金額の取得() {
        CreateTsukibetsuSuiihyoMyBatisParameter parameter = CreateTsukibetsuSuiihyoMyBatisParameter
                .create_4月人数と金額の取得(mybatisPrm.getChoteiNendo());
        return iCreateTsukibetsuSuiihyoMapper.get6月の人数金額(parameter);
    }

    private List<NinsuKinkaku> get7月の人数金額の取得() {
        CreateTsukibetsuSuiihyoMyBatisParameter parameter = CreateTsukibetsuSuiihyoMyBatisParameter
                .create_4月人数と金額の取得(mybatisPrm.getChoteiNendo());
        return iCreateTsukibetsuSuiihyoMapper.get7月の人数金額(parameter);
    }

    private List<NinsuKinkaku> get8月の人数金額の取得() {
        CreateTsukibetsuSuiihyoMyBatisParameter parameter = CreateTsukibetsuSuiihyoMyBatisParameter
                .create_4月人数と金額の取得(mybatisPrm.getChoteiNendo());
        return iCreateTsukibetsuSuiihyoMapper.get8月の人数金額(parameter);
    }

    private List<NinsuKinkaku> get9月の人数金額の取得() {
        CreateTsukibetsuSuiihyoMyBatisParameter parameter = CreateTsukibetsuSuiihyoMyBatisParameter
                .create_4月人数と金額の取得(mybatisPrm.getChoteiNendo());
        return iCreateTsukibetsuSuiihyoMapper.get9月の人数金額(parameter);
    }

    private List<NinsuKinkaku> get10月の人数金額の取得() {
        CreateTsukibetsuSuiihyoMyBatisParameter parameter = CreateTsukibetsuSuiihyoMyBatisParameter
                .create_4月人数と金額の取得(mybatisPrm.getChoteiNendo());
        return iCreateTsukibetsuSuiihyoMapper.get10月の人数金額(parameter);
    }

    private List<NinsuKinkaku> get11月の人数金額の取得() {
        CreateTsukibetsuSuiihyoMyBatisParameter parameter = CreateTsukibetsuSuiihyoMyBatisParameter
                .create_4月人数と金額の取得(mybatisPrm.getChoteiNendo());
        return iCreateTsukibetsuSuiihyoMapper.get11月の人数金額(parameter);
    }

    private List<NinsuKinkaku> get12月の人数金額の取得() {
        CreateTsukibetsuSuiihyoMyBatisParameter parameter = CreateTsukibetsuSuiihyoMyBatisParameter
                .create_4月人数と金額の取得(mybatisPrm.getChoteiNendo());
        return iCreateTsukibetsuSuiihyoMapper.get12月の人数金額(parameter);
    }

    private List<NinsuKinkaku> get1月の人数金額の取得() {
        CreateTsukibetsuSuiihyoMyBatisParameter parameter = CreateTsukibetsuSuiihyoMyBatisParameter
                .create_4月人数と金額の取得(mybatisPrm.getChoteiNendo());
        return iCreateTsukibetsuSuiihyoMapper.get1月の人数金額(parameter);
    }

    private List<NinsuKinkaku> get2月の人数金額の取得() {
        CreateTsukibetsuSuiihyoMyBatisParameter parameter = CreateTsukibetsuSuiihyoMyBatisParameter
                .create_4月人数と金額の取得(mybatisPrm.getChoteiNendo());
        return iCreateTsukibetsuSuiihyoMapper.get2月の人数金額(parameter);
    }

    private List<NinsuKinkaku> get3月の人数金額の取得() {
        CreateTsukibetsuSuiihyoMyBatisParameter parameter = CreateTsukibetsuSuiihyoMyBatisParameter
                .create_4月人数と金額の取得(mybatisPrm.getChoteiNendo());
        return iCreateTsukibetsuSuiihyoMapper.get3月の人数金額(parameter);
    }

    private List<NinsuKinkaku> get現年随時の人数金額の取得() {
        CreateTsukibetsuSuiihyoMyBatisParameter parameter = CreateTsukibetsuSuiihyoMyBatisParameter
                .create_4月人数と金額の取得(mybatisPrm.getChoteiNendo());
        return iCreateTsukibetsuSuiihyoMapper.get現年随時の人数金額(parameter);
    }

    private List<NinsuKinkaku> get過年度の人数金額の取得() {
        CreateTsukibetsuSuiihyoMyBatisParameter parameter = CreateTsukibetsuSuiihyoMyBatisParameter
                .create_過年度人数と金額の取得(mybatisPrm.getChoteiNendo());
        return iCreateTsukibetsuSuiihyoMapper.get過年度の人数金額(parameter);
    }

    private List<NinsuKinkaku> get特別徴収歳出還付の人数金額の取得() {
        CreateTsukibetsuSuiihyoMyBatisParameter parameter = CreateTsukibetsuSuiihyoMyBatisParameter
                .create_4月人数と金額の取得(mybatisPrm.getChoteiNendo());
        return iCreateTsukibetsuSuiihyoMapper.get特別徴収歳出還付の人数金額(parameter);
    }

    private List<NinsuKinkaku> get普通徴収歳出還付の人数金額の取得() {
        CreateTsukibetsuSuiihyoMyBatisParameter parameter = CreateTsukibetsuSuiihyoMyBatisParameter
                .create_4月人数と金額の取得(mybatisPrm.getChoteiNendo());
        return iCreateTsukibetsuSuiihyoMapper.get普通徴収歳出還付の人数金額(parameter);
    }

    private List<NinsuKinkaku> get不明の人数金額の取得() {
        CreateTsukibetsuSuiihyoMyBatisParameter parameter = CreateTsukibetsuSuiihyoMyBatisParameter
                .create_4月人数と金額の取得(mybatisPrm.getChoteiNendo());
        return iCreateTsukibetsuSuiihyoMapper.get不明の人数と金額(parameter);
    }

    private List<NinsuKinkaku> get減免部分合計の人数と金額の取得() {
        CreateTsukibetsuSuiihyoMyBatisParameter parameter = CreateTsukibetsuSuiihyoMyBatisParameter
                .create_過年度人数と金額の取得(mybatisPrm.getChoteiNendo());
        return iCreateTsukibetsuSuiihyoMapper.get減免部分合計の人数と金額(parameter);
    }

    private void 減免部分の人数と金額の計算() {
        Map map1 = new HashMap();
        for (NinsuKinkaku ninsuKinkak : ninsuKinkakuList) {
            GemmenJyoho gemmenJyoho = new GemmenJyoho();
            gemmenJyoho.setChoteiNendo(ninsuKinkak.getChoteiNendo());
            gemmenJyoho.setFukaNendo(ninsuKinkak.getFukaNendo());
            gemmenJyoho.setHokenryoDankai(ninsuKinkak.getHokenryoDankai());
            gemmenJyoho.setHokenryoDankaiKanendoNinsu(getNinsuOrKinkakul(ninsuKinkak.getKanendoNinsu()));
            gemmenJyoho.setHoDankaiKanendoGemmenGaku(getNinsuOrKinkakul(ninsuKinkak.getKanendoGemmenGaku()));
            map1.put(getMapKey(ninsuKinkak), gemmenJyoho);
        }
        List<NinsuKinkaku> ninsuKinkakulist = get減免部分合計の人数と金額の取得();
        for (NinsuKinkaku ninsuKinkak : ninsuKinkakulist) {
            RString key = getMapKey(ninsuKinkak);
            if (map1.containsKey(key)) {
                GemmenJyoho gemmenJyoho = (GemmenJyoho) map1.get(key);
                gemmenJyoho.setHoDankaiKanendoNinsuGoukeyi(getNinsuOrKinkakul(ninsuKinkak.getKanendoNinsuGoukeyi()));
                gemmenJyoho.setHoDankaiKanendoGemenGakuGoukei(getNinsuOrKinkakul(ninsuKinkak.getKanendoGemmenGakuGokeyi()));
                map1.put(key, gemmenJyoho);
            } else {
                GemmenJyoho gemmenJyoho = new GemmenJyoho();
                gemmenJyoho.setChoteiNendo(ninsuKinkak.getChoteiNendo());
                gemmenJyoho.setFukaNendo(ninsuKinkak.getFukaNendo());
                gemmenJyoho.setHokenryoDankai(ninsuKinkak.getHokenryoDankai());
                gemmenJyoho.setHoDankaiKanendoNinsuGoukeyi(getNinsuOrKinkakul(ninsuKinkak.getKanendoNinsuGoukeyi()));
                gemmenJyoho.setHoDankaiKanendoGemenGakuGoukei(getNinsuOrKinkakul(ninsuKinkak.getKanendoGemmenGakuGokeyi()));
                map1.put(key, gemmenJyoho);
            }
        }
        for (Object value : map1.values()) {
            GemmenJyoho gemmenJyoho = (GemmenJyoho) value;
            減免情報一時テーブル.insert(gemmenJyoho);
        }
    }

    private void set項目小計() {
        KoumokuSyoukeyi koumokuSyoukeyi = new KoumokuSyoukeyi();
        Map map = new HashMap();
        map = setすべて月の人数金額(map);
        for (Object value : map.values()) {
            NinsuKinkaku kinkaku = (NinsuKinkaku) value;
            koumokuSyoukeyi.setChoteiNendo(kinkaku.getChoteiNendo());
            koumokuSyoukeyi.setFukaNendo(kinkaku.getFukaNendo());
            koumokuSyoukeyi.setChoshuHouhou(kinkaku.getChoshuHouhou());
            koumokuSyoukeyi.setHokenryoDankai(kinkaku.getHokenryoDankai());
            koumokuSyoukeyi.setYoGetuNinsu(kinkaku.getYoGetuNinsu());
            koumokuSyoukeyi.setYoGetuKinkaku(kinkaku.getYoGetuKinkaku());
            koumokuSyoukeyi.setGoGetuNinsu(getNinsuOrKinkakul(kinkaku.getGoGetuNinsu()));
            koumokuSyoukeyi.setGoGetuKinkaku(getNinsuOrKinkakul(kinkaku.getGoGetuKinkaku()));
            koumokuSyoukeyi.setRokuGetuNinsu(getNinsuOrKinkakul(kinkaku.getRokuGetuNinsu()));
            koumokuSyoukeyi.setRokuGetuKinkaku(getNinsuOrKinkakul(kinkaku.getRokuGetuKinkaku()));
            koumokuSyoukeyi.setNanaGetuNinsu(getNinsuOrKinkakul(kinkaku.getNanaGetuNinsu()));
            koumokuSyoukeyi.setNanaGetuKinkaku(getNinsuOrKinkakul(kinkaku.getNanaGetuKinkaku()));
            koumokuSyoukeyi.setHatiGetuNinsu(getNinsuOrKinkakul(kinkaku.getHatiGetuNinsu()));
            koumokuSyoukeyi.setHatiGetuKinkaku(getNinsuOrKinkakul(kinkaku.getHatiGetuKinkaku()));
            koumokuSyoukeyi.setKyuGetuNinsu(getNinsuOrKinkakul(kinkaku.getKyuGetuNinsu()));
            koumokuSyoukeyi.setKyuGetuKinkaku(getNinsuOrKinkakul(kinkaku.getKyuGetuKinkaku()));
            koumokuSyoukeyi.setJyuGetuNinsu(getNinsuOrKinkakul(kinkaku.getJyuGetuNinsu()));
            koumokuSyoukeyi.setJyuGetuKinkaku(getNinsuOrKinkakul(kinkaku.getJyuGetuKinkaku()));
            koumokuSyoukeyi.setJyuitiGetuNinsu(getNinsuOrKinkakul(kinkaku.getJyuitiGetuNinsu()));
            koumokuSyoukeyi.setJyuitiGetuKinkaku(getNinsuOrKinkakul(kinkaku.getJyuitiGetuKinkaku()));
            koumokuSyoukeyi.setJyuniGetuNinsu(getNinsuOrKinkakul(kinkaku.getJyuniGetuNinsu()));
            koumokuSyoukeyi.setJyuniGetuKinkaku(getNinsuOrKinkakul(kinkaku.getJyuniGetuKinkaku()));
            koumokuSyoukeyi.setItiGetuNinsu(getNinsuOrKinkakul(kinkaku.getItiGetuNinsu()));
            koumokuSyoukeyi.setItiGetuKinkaku(getNinsuOrKinkakul(kinkaku.getItiGetuKinkaku()));
            koumokuSyoukeyi.setNiGetuNinsu(getNinsuOrKinkakul(kinkaku.getNiGetuNinsu()));
            koumokuSyoukeyi.setNiGetuKinkaku(getNinsuOrKinkakul(kinkaku.getNiGetuKinkaku()));
            koumokuSyoukeyi.setSanGetuNinsu(getNinsuOrKinkakul(kinkaku.getSanGetuNinsu()));
            koumokuSyoukeyi.setSanGetuKinkaku(getNinsuOrKinkakul(kinkaku.getSanGetuKinkaku()));
            koumokuSyoukeyi.setGennenSuyijiNinsu(getNinsuOrKinkakul(kinkaku.getGennenSuyijiNinsu()));
            koumokuSyoukeyi.setGennenSuyijiKinkaku(getNinsuOrKinkakul(kinkaku.getGennenSuyijiKinkaku()));
            koumokuSyoukeyi.setKanendoNinsu(getNinsuOrKinkakul(kinkaku.getKanendoNinsu()));
            koumokuSyoukeyi.setKanendoKinkaku(getNinsuOrKinkakul(kinkaku.getKanendoKinkaku()));
            koumokuSyoukeyi.setSayisyutuKanpuNinsu(getNinsuOrKinkakul(kinkaku.getSayisyutuKanpuNinsu()));
            koumokuSyoukeyi.setSayisyutuKanpuKinkaku(getNinsuOrKinkakul(kinkaku.getSayisyutuKanpuKinkaku()));
            項目小計一時テーブル.insert(koumokuSyoukeyi);
        }
    }

    private Map setすべて月の人数金額(Map map) {
        for (int i = 0; i < get4月の人数金額の取得().size(); i++) {
            map.put(getMapKey(get4月の人数金額の取得().get(i)), get4月の人数金額の取得().get(i));
        }
        for (int i = 0; i < get5月の人数金額の取得().size(); i++) {
            RString key = getMapKey(get5月の人数金額の取得().get(i));
            if (map.containsKey(key)) {
                NinsuKinkaku ninsuKinkaku = (NinsuKinkaku) map.get(key);
                ninsuKinkaku.setGoGetuNinsu(getNinsuOrKinkakul(get5月の人数金額の取得().get(i).getGoGetuNinsu()));
                ninsuKinkaku.setGoGetuKinkaku(getNinsuOrKinkakul(get5月の人数金額の取得().get(i).getGoGetuKinkaku()));
                map.put(key, ninsuKinkaku);
            } else {
                map.put(key, get5月の人数金額の取得().get(i));
            }
        }
        for (int i = 0; i < get6月の人数金額の取得().size(); i++) {
            RString key = getMapKey(get6月の人数金額の取得().get(i));
            if (map.containsKey(key)) {
                NinsuKinkaku ninsuKinkaku = (NinsuKinkaku) map.get(key);
                ninsuKinkaku.setRokuGetuNinsu(getNinsuOrKinkakul(get6月の人数金額の取得().get(i).getRokuGetuNinsu()));
                ninsuKinkaku.setRokuGetuKinkaku(getNinsuOrKinkakul(get6月の人数金額の取得().get(i).getRokuGetuKinkaku()));
                map.put(key, ninsuKinkaku);
            } else {
                map.put(key, get6月の人数金額の取得().get(i));
            }
        }
        map = set7_3月の人数金額(map);
        for (int i = 0; i < get現年随時の人数金額の取得().size(); i++) {
            RString key = getMapKey(get現年随時の人数金額の取得().get(i));
            if (map.containsKey(key)) {
                NinsuKinkaku ninsuKinkaku = (NinsuKinkaku) map.get(key);
                ninsuKinkaku.setGennenSuyijiNinsu(getNinsuOrKinkakul(get現年随時の人数金額の取得().get(i).getGennenSuyijiNinsu()));
                ninsuKinkaku.setGennenSuyijiKinkaku(getNinsuOrKinkakul(get現年随時の人数金額の取得().get(i).getGennenSuyijiKinkaku()));
                map.put(key, ninsuKinkaku);
            } else {
                map.put(key, get現年随時の人数金額の取得().get(i));
            }
        }
        for (int i = 0; i < get過年度の人数金額の取得().size(); i++) {
            RString key = getMapKey(get過年度の人数金額の取得().get(i));
            if (map.containsKey(key)) {
                NinsuKinkaku ninsuKinkaku = (NinsuKinkaku) map.get(key);
                ninsuKinkaku.setKanendoNinsu(getNinsuOrKinkakul(get過年度の人数金額の取得().get(i).getKanendoNinsu()));
                ninsuKinkaku.setKanendoKinkaku(getNinsuOrKinkakul(get過年度の人数金額の取得().get(i).getKanendoKinkaku()));
                map.put(key, ninsuKinkaku);
            } else {
                map.put(key, get過年度の人数金額の取得().get(i));
            }
        }
        map = set歳出還付と不明の人数金額(map);
        return map;
    }

    private Map set7_3月の人数金額(Map map) {
        for (int i = 0; i < get7月の人数金額の取得().size(); i++) {
            RString key = getMapKey(get7月の人数金額の取得().get(i));
            if (map.containsKey(key)) {
                NinsuKinkaku ninsuKinkaku = (NinsuKinkaku) map.get(key);
                ninsuKinkaku.setNanaGetuNinsu(getNinsuOrKinkakul(get7月の人数金額の取得().get(i).getNanaGetuNinsu()));
                ninsuKinkaku.setNanaGetuKinkaku(getNinsuOrKinkakul(get7月の人数金額の取得().get(i).getNanaGetuKinkaku()));
                map.put(key, ninsuKinkaku);
            } else {
                map.put(key, get7月の人数金額の取得().get(i));
            }
        }
        for (int i = 0; i < get8月の人数金額の取得().size(); i++) {
            RString key = getMapKey(get8月の人数金額の取得().get(i));
            if (map.containsKey(key)) {
                NinsuKinkaku ninsuKinkaku = (NinsuKinkaku) map.get(key);
                ninsuKinkaku.setHatiGetuNinsu(getNinsuOrKinkakul(get8月の人数金額の取得().get(i).getHatiGetuNinsu()));
                ninsuKinkaku.setHatiGetuKinkaku(getNinsuOrKinkakul(get8月の人数金額の取得().get(i).getHatiGetuKinkaku()));
                map.put(key, ninsuKinkaku);
            } else {
                map.put(key, get8月の人数金額の取得().get(i));
            }
        }
        for (int i = 0; i < get9月の人数金額の取得().size(); i++) {
            RString key = getMapKey(get9月の人数金額の取得().get(i));
            if (map.containsKey(key)) {
                NinsuKinkaku ninsuKinkaku = (NinsuKinkaku) map.get(key);
                ninsuKinkaku.setKyuGetuNinsu(getNinsuOrKinkakul(get9月の人数金額の取得().get(i).getKyuGetuNinsu()));
                ninsuKinkaku.setKyuGetuKinkaku(getNinsuOrKinkakul(get9月の人数金額の取得().get(i).getKyuGetuKinkaku()));
                map.put(key, ninsuKinkaku);
            } else {
                map.put(key, get9月の人数金額の取得().get(i));
            }
        }
        for (int i = 0; i < get10月の人数金額の取得().size(); i++) {
            RString key = getMapKey(get10月の人数金額の取得().get(i));
            if (map.containsKey(key)) {
                NinsuKinkaku ninsuKinkaku = (NinsuKinkaku) map.get(key);
                ninsuKinkaku.setJyuGetuNinsu(getNinsuOrKinkakul(get10月の人数金額の取得().get(i).getJyuGetuNinsu()));
                ninsuKinkaku.setJyuGetuKinkaku(getNinsuOrKinkakul(get10月の人数金額の取得().get(i).getJyuGetuKinkaku()));
                map.put(key, ninsuKinkaku);
            } else {
                map.put(key, get10月の人数金額の取得().get(i));
            }
        }
        for (int i = 0; i < get11月の人数金額の取得().size(); i++) {
            RString key = getMapKey(get11月の人数金額の取得().get(i));
            if (map.containsKey(key)) {
                NinsuKinkaku ninsuKinkaku = (NinsuKinkaku) map.get(key);
                ninsuKinkaku.setJyuitiGetuNinsu(getNinsuOrKinkakul(get11月の人数金額の取得().get(i).getJyuitiGetuNinsu()));
                ninsuKinkaku.setJyuitiGetuKinkaku(getNinsuOrKinkakul(get11月の人数金額の取得().get(i).getJyuitiGetuKinkaku()));
                map.put(key, ninsuKinkaku);
            } else {
                map.put(key, get11月の人数金額の取得().get(i));
            }
        }
        for (int i = 0; i < get12月の人数金額の取得().size(); i++) {
            RString key = getMapKey(get12月の人数金額の取得().get(i));
            if (map.containsKey(key)) {
                NinsuKinkaku ninsuKinkaku = (NinsuKinkaku) map.get(key);
                ninsuKinkaku.setJyuniGetuNinsu(getNinsuOrKinkakul(get12月の人数金額の取得().get(i).getJyuniGetuNinsu()));
                ninsuKinkaku.setJyuniGetuKinkaku(getNinsuOrKinkakul(get12月の人数金額の取得().get(i).getJyuniGetuKinkaku()));
                map.put(key, ninsuKinkaku);
            } else {
                map.put(key, get12月の人数金額の取得().get(i));
            }
        }
        for (int i = 0; i < get1月の人数金額の取得().size(); i++) {
            RString key = getMapKey(get1月の人数金額の取得().get(i));
            if (map.containsKey(key)) {
                NinsuKinkaku ninsuKinkaku = (NinsuKinkaku) map.get(key);
                ninsuKinkaku.setItiGetuNinsu(getNinsuOrKinkakul(get1月の人数金額の取得().get(i).getItiGetuNinsu()));
                ninsuKinkaku.setItiGetuKinkaku(getNinsuOrKinkakul(get1月の人数金額の取得().get(i).getItiGetuKinkaku()));
                map.put(key, ninsuKinkaku);
            } else {
                map.put(key, get1月の人数金額の取得().get(i));
            }
        }
        for (int i = 0; i < get2月の人数金額の取得().size(); i++) {
            RString key = getMapKey(get2月の人数金額の取得().get(i));
            if (map.containsKey(key)) {
                NinsuKinkaku ninsuKinkaku = (NinsuKinkaku) map.get(key);
                ninsuKinkaku.setNiGetuNinsu(getNinsuOrKinkakul(get2月の人数金額の取得().get(i).getNiGetuNinsu()));
                ninsuKinkaku.setNiGetuKinkaku(getNinsuOrKinkakul(get2月の人数金額の取得().get(i).getNiGetuKinkaku()));
                map.put(key, ninsuKinkaku);
            } else {
                map.put(key, get2月の人数金額の取得().get(i));
            }
        }
        for (int i = 0; i < get3月の人数金額の取得().size(); i++) {
            RString key = getMapKey(get3月の人数金額の取得().get(i));
            if (map.containsKey(key)) {
                NinsuKinkaku ninsuKinkaku = (NinsuKinkaku) map.get(key);
                ninsuKinkaku.setSanGetuNinsu(getNinsuOrKinkakul(get3月の人数金額の取得().get(i).getSanGetuNinsu()));
                ninsuKinkaku.setSanGetuKinkaku(getNinsuOrKinkakul(get3月の人数金額の取得().get(i).getSanGetuKinkaku()));
                map.put(key, ninsuKinkaku);
            } else {
                map.put(key, get3月の人数金額の取得().get(i));
            }
        }
        return map;
    }

    private Map set歳出還付と不明の人数金額(Map map) {
        for (int i = 0; i < get特別徴収歳出還付の人数金額の取得().size(); i++) {
            RString key = getMapKey(get特別徴収歳出還付の人数金額の取得().get(i));
            if (map.containsKey(key)) {
                NinsuKinkaku ninsuKinkaku = (NinsuKinkaku) map.get(key);
                ninsuKinkaku.setSayisyutuKanpuNinsu(getNinsuOrKinkakul(get特別徴収歳出還付の人数金額の取得().get(i).getSayisyutuKanpuNinsu()));
                ninsuKinkaku.setSayisyutuKanpuKinkaku(getNinsuOrKinkakul(get特別徴収歳出還付の人数金額の取得().get(i).getSayisyutuKanpuKinkaku()));
                map.put(key, ninsuKinkaku);
            } else {
                map.put(key, get特別徴収歳出還付の人数金額の取得().get(i));
            }
        }
        for (int i = 0; i < get普通徴収歳出還付の人数金額の取得().size(); i++) {
            RString key = getMapKey(get普通徴収歳出還付の人数金額の取得().get(i));
            if (map.containsKey(key)) {
                NinsuKinkaku ninsuKinkaku = (NinsuKinkaku) map.get(key);
                ninsuKinkaku.setSayisyutuKanpuNinsu(getNinsuOrKinkakul(get普通徴収歳出還付の人数金額の取得().get(i).getSayisyutuKanpuNinsu()));
                ninsuKinkaku.setSayisyutuKanpuKinkaku(getNinsuOrKinkakul(get普通徴収歳出還付の人数金額の取得().get(i).getSayisyutuKanpuKinkaku()));
                map.put(key, ninsuKinkaku);
            } else {
                map.put(key, get普通徴収歳出還付の人数金額の取得().get(i));
            }
        }
        NinsuKinkaku ninsuKinkaku = new NinsuKinkaku();
        for (int i = 0; i < get不明の人数金額の取得().size(); i++) {
            ninsuKinkaku.setChoteiNendo(get不明の人数金額の取得().get(i).getChoteiNendo());
            ninsuKinkaku.setFukaNendo(get不明の人数金額の取得().get(i).getFukaNendo());
            ninsuKinkaku.setChoshuHouhou(get不明の人数金額の取得().get(i).getChoshuHouhou());
            ninsuKinkaku.setHokenryoDankai(new RString("不明"));
            if (四月.equals(get不明の人数金額の取得().get(i).getGetu())) {
                ninsuKinkaku.setYoGetuNinsu(getNinsuOrKinkakul(get不明の人数金額の取得().get(i).getFumeNinsu()));
                ninsuKinkaku.setYoGetuKinkaku(getNinsuOrKinkakul(get不明の人数金額の取得().get(i).getFumeKinkaku()));
            } else if (五月.equals(get不明の人数金額の取得().get(i).getGetu())) {
                ninsuKinkaku.setGoGetuNinsu(getNinsuOrKinkakul(get不明の人数金額の取得().get(i).getFumeNinsu()));
                ninsuKinkaku.setGoGetuKinkaku(getNinsuOrKinkakul(get不明の人数金額の取得().get(i).getFumeKinkaku()));
            } else if (六月.equals(get不明の人数金額の取得().get(i).getGetu())) {
                ninsuKinkaku.setRokuGetuNinsu(getNinsuOrKinkakul(get不明の人数金額の取得().get(i).getFumeNinsu()));
                ninsuKinkaku.setRokuGetuKinkaku(getNinsuOrKinkakul(get不明の人数金額の取得().get(i).getFumeKinkaku()));
            } else if (七月.equals(get不明の人数金額の取得().get(i).getGetu())) {
                ninsuKinkaku.setNanaGetuNinsu(getNinsuOrKinkakul(get不明の人数金額の取得().get(i).getFumeNinsu()));
                ninsuKinkaku.setNanaGetuKinkaku(getNinsuOrKinkakul(get不明の人数金額の取得().get(i).getFumeKinkaku()));
            } else if (八月.equals(get不明の人数金額の取得().get(i).getGetu())) {
                ninsuKinkaku.setHatiGetuNinsu(getNinsuOrKinkakul(get不明の人数金額の取得().get(i).getFumeNinsu()));
                ninsuKinkaku.setHatiGetuKinkaku(getNinsuOrKinkakul(get不明の人数金額の取得().get(i).getFumeKinkaku()));
            } else if (九月.equals(get不明の人数金額の取得().get(i).getGetu())) {
                ninsuKinkaku.setKyuGetuNinsu(getNinsuOrKinkakul(get不明の人数金額の取得().get(i).getFumeNinsu()));
                ninsuKinkaku.setKyuGetuKinkaku(getNinsuOrKinkakul(get不明の人数金額の取得().get(i).getFumeKinkaku()));
            } else if (十月.equals(get不明の人数金額の取得().get(i).getGetu())) {
                ninsuKinkaku.setJyuGetuNinsu(getNinsuOrKinkakul(get不明の人数金額の取得().get(i).getFumeNinsu()));
                ninsuKinkaku.setJyuGetuKinkaku(getNinsuOrKinkakul(get不明の人数金額の取得().get(i).getFumeKinkaku()));
            } else if (十一月.equals(get不明の人数金額の取得().get(i).getGetu())) {
                ninsuKinkaku.setJyuitiGetuNinsu(getNinsuOrKinkakul(get不明の人数金額の取得().get(i).getFumeNinsu()));
                ninsuKinkaku.setJyuitiGetuKinkaku(getNinsuOrKinkakul(get不明の人数金額の取得().get(i).getFumeKinkaku()));
            } else if (十二月.equals(get不明の人数金額の取得().get(i).getGetu())) {
                ninsuKinkaku.setJyuniGetuNinsu(getNinsuOrKinkakul(get不明の人数金額の取得().get(i).getFumeNinsu()));
                ninsuKinkaku.setJyuniGetuKinkaku(getNinsuOrKinkakul(get不明の人数金額の取得().get(i).getFumeKinkaku()));
            } else if (一月.equals(get不明の人数金額の取得().get(i).getGetu())) {
                ninsuKinkaku.setItiGetuNinsu(getNinsuOrKinkakul(get不明の人数金額の取得().get(i).getFumeNinsu()));
                ninsuKinkaku.setItiGetuKinkaku(getNinsuOrKinkakul(get不明の人数金額の取得().get(i).getFumeKinkaku()));
            } else if (二月.equals(get不明の人数金額の取得().get(i).getGetu())) {
                ninsuKinkaku.setNiGetuNinsu(getNinsuOrKinkakul(get不明の人数金額の取得().get(i).getFumeNinsu()));
                ninsuKinkaku.setNiGetuKinkaku(getNinsuOrKinkakul(get不明の人数金額の取得().get(i).getFumeKinkaku()));
            } else if (三月.equals(get不明の人数金額の取得().get(i).getGetu())) {
                ninsuKinkaku.setSanGetuNinsu(getNinsuOrKinkakul(get不明の人数金額の取得().get(i).getFumeNinsu()));
                ninsuKinkaku.setSanGetuKinkaku(getNinsuOrKinkakul(get不明の人数金額の取得().get(i).getFumeKinkaku()));
            }
        }
        map.put(getMapKey(ninsuKinkaku), ninsuKinkaku);
        return map;
    }

    private Decimal getNinsuOrKinkakul(Decimal ninsuOrKinkaku) {
        return ninsuOrKinkaku == null ? new Decimal(0) : ninsuOrKinkaku;
    }

    private RString getMapKey(NinsuKinkaku ninsuKinkaku) {
        StringBuilder key = new StringBuilder();
        key.append(ninsuKinkaku.getChoteiNendo());
        key.append(ninsuKinkaku.getFukaNendo());
        key.append(ninsuKinkaku.getChoshuHouhou());
        key.append(ninsuKinkaku.getHokenryoDankai());
        return new RString(key.toString());
    }
}
