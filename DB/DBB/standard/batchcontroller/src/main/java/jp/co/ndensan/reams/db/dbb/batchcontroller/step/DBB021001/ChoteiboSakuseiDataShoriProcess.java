/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB021001;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.definition.core.choshuhoho.ChoshuHohoKibetsu;
import jp.co.ndensan.reams.db.dbb.definition.core.choteibo.DanKai;
import jp.co.ndensan.reams.db.dbb.definition.core.choteibo.DankaiChoteigakuShokei;
import jp.co.ndensan.reams.db.dbb.definition.core.choteibo.DankaiGokeigo;
import jp.co.ndensan.reams.db.dbb.definition.core.choteibo.DankaiShokei;
import jp.co.ndensan.reams.db.dbb.definition.core.choteibo.Gokei;
import jp.co.ndensan.reams.db.dbb.definition.core.choteibo.Gokeigo;
import jp.co.ndensan.reams.db.dbb.definition.core.choteibo.Kibetsu;
import jp.co.ndensan.reams.db.dbb.definition.core.choteibo.KibetsuGokeigo;
import jp.co.ndensan.reams.db.dbb.definition.core.choteibo.KibetsuShokei;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.choteibo.ChoteiboShoriHizukeMyBatisParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.choteibo.ChoteiboProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.choteibo.DanKaiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.choteibo.DangatsuDankaiDataEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.choteibo.DankaiDataEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.choteibo.DankaiGokeiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.choteibo.DankaiKensuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.choteibo.DankaiShokeiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.choteibo.DankaiTksaiToFusaiKensuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.choteibo.GenmenEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.choteibo.GokeiBubunEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.choteibo.GokeiBubunSoukeiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.choteibo.KibetsuBubunDataEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.choteibo.KibetsuDataEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.choteibo.KibetsuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.choteibo.KibetsuGokeiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.choteibo.KibetsuShokeiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.choteibo.KibetsuShokeiGokeiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.choteibo.NaiheisyaKensuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.choteibo.SaishutsuKampuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.choteibo.SonotaBubunDataEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.choteibo.TokuchoKibetusDataEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.choteibo.ZengatsuDankaiDataEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.choteibo.IChoteiboSakuseiMapper;
import jp.co.ndensan.reams.db.dbb.service.core.choteibo.ChoteiboShukei;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.FuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KanendoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KitsukiList;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.Tsuki;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 調定簿作成一時テーブルのデータ処理
 *
 * @reamsid_L DBB-0770-030 zhangrui
 */
public class ChoteiboSakuseiDataShoriProcess extends SimpleBatchProcessBase {

    private static final int 第1期 = 1;
    private static final int 第2期 = 2;
    private static final int 第3期 = 3;
    private static final int 第4期 = 4;
    private static final int 第5期 = 5;
    private static final int 第6期 = 6;
    private static final int 第7期 = 7;
    private static final int 第8期 = 8;
    private static final int 第9期 = 9;
    private static final int 第10期 = 10;
    private static final int 第11期 = 11;
    private static final int 第12期 = 12;
    private static final int 第13期 = 13;
    private static final int 第14期 = 14;
    private static final int 当月 = 1;
    private static final int 前月 = 0;
    private static final RString KEY_CHOTEINENDO = new RString("choteiNendo");
    private static final RString KEY_FUKANENDO = new RString("fukaNendo");
    private static final RString KEY_CHUSHUTSUSTYMD = new RString("chushutsuStYMD");
    private static final RString KEY_CHUSHUTSUENDYMD = new RString("chushutsuEdYMD");
    private static final RString KEY_CHUSHUHOUHOU = new RString("choshuHouhou");
    private static final RString KEY_DANNENDO = new RString("danNendo");
    private static final RString KEY_ZENNENDO = new RString("zenNendo");
    private static final RString KEY_ZENZENNENDO = new RString("zenzenNendo");
    private static final RString KEY_DOGETSUFLG = new RString("dogetsuFlag");
    private static final RString KEY_KARISANFLG = new RString("karisanFlag");
    private static final RString 本算定 = new RString("0");
    private static final RString 仮算定 = new RString("1");
    private IChoteiboSakuseiMapper choteiboSakuseiMapper;
    private ChoteiboProcessParameter parameter;

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
        super.beforeExecute();
        choteiboSakuseiMapper = getMapper(IChoteiboSakuseiMapper.class);
        createTempTable();
    }

    @Override
    protected void process() {
    }

    @Override
    protected void afterExecute() {
        当年度の賦課情報の取得();
        前年度の賦課情報の取得();
        前々年度の賦課情報の取得();
        合計部分の情報の取得();
    }

    /**
     * 一時テーブルを作成します。
     */
    public void createTempTable() {
        choteiboSakuseiMapper.createTmpKibetsu();
        choteiboSakuseiMapper.createTmpDankai();
        choteiboSakuseiMapper.createTmpKibetsuShokei();
        choteiboSakuseiMapper.createTmpDankaiShokei();
        choteiboSakuseiMapper.createTmpKibetsuGokei();
        choteiboSakuseiMapper.createTmpDankaiGokei();
        choteiboSakuseiMapper.createTmpGokeiBubun();
        choteiboSakuseiMapper.createTmpGokeiBubunSoukei();
    }

    private void 当年度の賦課情報の取得() {
        create年度データ(
                parameter.getShoriNendo(),
                parameter.getShoriNendo(),
                parameter.getChushutsuStYMD(),
                parameter.getChushutsuEdYMD());
    }

    private void 前年度の賦課情報の取得() {
        create年度データ(
                parameter.getShoriNendo(),
                parameter.getShoriNendo().minusYear(1),
                parameter.getChushutsuStYMD(),
                parameter.getChushutsuEdYMD());
    }

    private void 前々年度の賦課情報の取得() {
        create年度データ(
                parameter.getShoriNendo(),
                parameter.getShoriNendo().minusYear(2),
                parameter.getChushutsuStYMD(),
                parameter.getChushutsuEdYMD());
    }

    /**
     * 年度データリストを作成します。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 開始調定日時 開始調定日時
     * @param 終了調定日時 終了調定日時
     */
    public void create年度データ(
            FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            YMDHMS 開始調定日時,
            YMDHMS 終了調定日時) {
        insert期別情報一時テーブル(調定年度, 賦課年度, 開始調定日時, 終了調定日時);
        insert段階情報一時テーブル(調定年度, 賦課年度, 開始調定日時, 終了調定日時);
        insert段階小計一時テーブル(調定年度, 賦課年度, ChoshuHohoKibetsu.特別徴収.getコード(), 当月, 仮算定);
        insert段階小計一時テーブル(調定年度, 賦課年度, ChoshuHohoKibetsu.特別徴収.getコード(), 当月, 本算定);
        insert段階小計一時テーブル(調定年度, 賦課年度, ChoshuHohoKibetsu.特別徴収.getコード(), 前月, 仮算定);
        insert段階小計一時テーブル(調定年度, 賦課年度, ChoshuHohoKibetsu.特別徴収.getコード(), 前月, 本算定);
        insert段階小計一時テーブル(調定年度, 賦課年度, ChoshuHohoKibetsu.普通徴収.getコード(), 当月, 仮算定);
        insert段階小計一時テーブル(調定年度, 賦課年度, ChoshuHohoKibetsu.普通徴収.getコード(), 当月, 本算定);
        insert段階小計一時テーブル(調定年度, 賦課年度, ChoshuHohoKibetsu.普通徴収.getコード(), 前月, 仮算定);
        insert段階小計一時テーブル(調定年度, 賦課年度, ChoshuHohoKibetsu.普通徴収.getコード(), 前月, 本算定);

        update内併徴者数(調定年度, 賦課年度, 仮算定);
        update内併徴者数(調定年度, 賦課年度, 本算定);

        update増減調定額の小計(調定年度, 賦課年度);

        insert期別小計一時テーブル(調定年度, 賦課年度);

        update調定額の小計(調定年度, 賦課年度);

        insert合計一時テーブル(調定年度, 賦課年度);

        update調定額の合計(調定年度, 賦課年度);

        update減免の件数と減免額(調定年度, 賦課年度, 開始調定日時, 終了調定日時);

        update歳出還付の件数と金額(調定年度, 賦課年度, 終了調定日時);
    }

    /**
     * 合計データリストを作成します。
     *
     * @param 当年度 当年度
     * @param 前年度 前年度
     * @param 前々年度 前々年度
     */
    private void 合計部分の情報の取得() {
        FlexibleYear 調定年度 = parameter.getShoriNendo();
        FlexibleYear 当年度 = 調定年度;
        FlexibleYear 前年度 = 調定年度.minusYear(1);
        FlexibleYear 前々年度 = 調定年度.minusYear(2);
        insert合計部分一時テーブル_特別徴収(調定年度, 当年度, 前年度, 前々年度);
        insert合計部分一時テーブル_普通徴収(調定年度, 当年度, 前年度, 前々年度);
        update当月末の段階のデータ(調定年度, 当年度, 前年度, 前々年度, 仮算定);
        update当月末の段階のデータ(調定年度, 当年度, 前年度, 前々年度, 本算定);
        update前月末の段階のデータ(調定年度, 当年度, 前年度, 前々年度, 仮算定);
        update前月末の段階のデータ(調定年度, 当年度, 前年度, 前々年度, 本算定);

        update段階の特徴と普徴者数(調定年度, 当年度, 前年度, 前々年度, 仮算定);
        update段階の特徴と普徴者数(調定年度, 当年度, 前年度, 前々年度, 本算定);

        insert合計部分総計一時テーブル(調定年度, 当年度, 前年度, 前々年度);
        updateその他部分のデータ(調定年度, 当年度, 前年度, 前々年度);
    }

    /**
     * 期別情報一時テーブルに登録します。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 開始調定日時 開始調定日時
     * @param 終了調定日時 終了調定日時
     */
    private void insert期別情報一時テーブル(
            FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            YMDHMS 開始調定日時,
            YMDHMS 終了調定日時) {
        Map<String, Object> param = new HashMap<>();
        param.put(KEY_CHOTEINENDO.toString(), 調定年度);
        param.put(KEY_FUKANENDO.toString(), 賦課年度);
        param.put(KEY_CHUSHUTSUSTYMD.toString(), 開始調定日時);
        param.put(KEY_CHUSHUTSUENDYMD.toString(), 終了調定日時);
        List<KibetsuDataEntity> kibetsuData = choteiboSakuseiMapper.select期別のデータ(param);
        for (KibetsuDataEntity entity : kibetsuData) {
            KibetsuEntity kibetsuEntity = new KibetsuEntity();
            kibetsuEntity.setChoteiNendo(entity.getChoteiNendo());
            kibetsuEntity.setFukaNendo(entity.getFukaNendo());
            kibetsuEntity.setTsuchishoNo(entity.getTsuchishoNo());
            kibetsuEntity.setRirekiNo(entity.getRirekiNo());
            kibetsuEntity.setHihokenshaNo(entity.getHihokenshaNo());
            kibetsuEntity.setChoshuHouhou(entity.getChoshuHouhou());
            kibetsuEntity.setKi(entity.getKi());
            kibetsuEntity.setChoteiId(entity.getChoteiId());
            switch (entity.getKi()) {
                case 第1期:
                    kibetsuEntity.setDai1kiChoteiGaku(entity.getChoteigaku());
                    break;
                case 第2期:
                    kibetsuEntity.setDai2kiChoteiGaku(entity.getChoteigaku());
                    break;
                case 第3期:
                    kibetsuEntity.setDai3kiChoteiGaku(entity.getChoteigaku());
                    break;
                case 第4期:
                    kibetsuEntity.setDai4kiChoteiGaku(entity.getChoteigaku());
                    break;
                case 第5期:
                    kibetsuEntity.setDai5kiChoteiGaku(entity.getChoteigaku());
                    break;
                case 第6期:
                    kibetsuEntity.setDai6kiChoteiGaku(entity.getChoteigaku());
                    break;
                case 第7期:
                    kibetsuEntity.setDai7kiChoteiGaku(entity.getChoteigaku());
                    break;
                case 第8期:
                    kibetsuEntity.setDai8kiChoteiGaku(entity.getChoteigaku());
                    break;
                case 第9期:
                    kibetsuEntity.setDai9kiChoteiGaku(entity.getChoteigaku());
                    break;
                case 第10期:
                    kibetsuEntity.setDai10kiChoteiGaku(entity.getChoteigaku());
                    break;
                case 第11期:
                    kibetsuEntity.setDai11kiChoteiGaku(entity.getChoteigaku());
                    break;
                case 第12期:
                    kibetsuEntity.setDai12kiChoteiGaku(entity.getChoteigaku());
                    break;
                case 第13期:
                    kibetsuEntity.setDai13kiChoteiGaku(entity.getChoteigaku());
                    break;
                case 第14期:
                    kibetsuEntity.setDai14kiChoteiGaku(entity.getChoteigaku());
                    break;
                default:
                    break;
            }
            choteiboSakuseiMapper.insertTmpKibetsu(kibetsuEntity);
        }
    }

    /**
     * 段階情報一時テーブルに登録します。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 開始調定日時 開始調定日時
     * @param 終了調定日時 終了調定日時
     */
    private void insert段階情報一時テーブル(FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            YMDHMS 開始調定日時,
            YMDHMS 終了調定日時) {
        Map<String, Object> param = new HashMap<>();
        param.put(KEY_CHOTEINENDO.toString(), 調定年度);
        param.put(KEY_FUKANENDO.toString(), 賦課年度);
        param.put(KEY_CHUSHUTSUSTYMD.toString(), 開始調定日時);
        param.put(KEY_CHUSHUTSUENDYMD.toString(), 終了調定日時);
        ChoteiboShoriHizukeMyBatisParameter myBatisParameter = new ChoteiboShoriHizukeMyBatisParameter(
                SubGyomuCode.DBB介護賦課, ShoriName.本算定賦課.get名称(), 調定年度);
        DbT7022ShoriDateKanriEntity shoriDateKanriData = choteiboSakuseiMapper.select処理日付(myBatisParameter);

        insert当月末の段階(param, shoriDateKanriData, 調定年度, 賦課年度);
        insert前月末の段階(param, shoriDateKanriData, 調定年度, 賦課年度);
    }

    private void insert当月末の段階(Map<String, Object> param, DbT7022ShoriDateKanriEntity shoriDateKanriData,
            FlexibleYear 調定年度,
            FlexibleYear 賦課年度) {
        List<DankaiDataEntity> dogetsudankaiData = choteiboSakuseiMapper.select当月末の段階データ(param);
        for (DankaiDataEntity entity : dogetsudankaiData) {
            DanKaiEntity dankaiEntity = new DanKaiEntity();
            dankaiEntity.setChoteiNendo(entity.getChoteiNendo());
            dankaiEntity.setFukaNendo(entity.getFukaNendo());
            dankaiEntity.setTsuchishoNo(entity.getTsuchishoNo());
            dankaiEntity.setRirekiNo(entity.getRirekiNo());
            dankaiEntity.setHihokenshaNo(entity.getHihokenshaNo());
            dankaiEntity.setDankai(entity.getDankai());
            dankaiEntity.setChoshuHouhou(entity.getChoshuHouhou());
            dankaiEntity.setChoteiId(entity.getChoteiId());
            dankaiEntity.setDogetsuFlag(1);
            if (調定年度.equals(賦課年度)) {
                if (shoriDateKanriData == null || shoriDateKanriData.getKijunTimestamp() == null
                        || shoriDateKanriData.getKijunTimestamp().isEmpty()
                        || entity.getChoteiNichiji() == null || entity.getChoteiNichiji().isEmpty()
                        || (entity.getChoteiNichiji().isBefore(shoriDateKanriData.getKijunTimestamp())
                        && entity.getChoteiNendo().equals(shoriDateKanriData.getNendo()))) {
                    dankaiEntity.setKarisanFlag(仮算定);
                } else if (shoriDateKanriData.getKijunTimestamp().isBeforeOrEquals(entity.getChoteiNichiji())
                        && entity.getChoteiNendo().equals(shoriDateKanriData.getNendo())) {
                    dankaiEntity.setKarisanFlag(本算定);
                }
            } else {
                dankaiEntity.setKarisanFlag(本算定);
            }
            dankaiEntity.setZengetsusueChoteigaku(null);
            dankaiEntity.setFueChoteigaku(null);
            dankaiEntity.setGenChoteigaku(null);
            dankaiEntity.setDogetsusueChoteigaku(entity.getChoteigaku());
            choteiboSakuseiMapper.insertTmpDankai(dankaiEntity);
        }
    }

    private void insert前月末の段階(Map<String, Object> param, DbT7022ShoriDateKanriEntity shoriDateKanriData,
            FlexibleYear 調定年度,
            FlexibleYear 賦課年度) {
        List<DankaiDataEntity> zengetsudankaiData = choteiboSakuseiMapper.select前月末の段階データ(param);
        for (DankaiDataEntity entity : zengetsudankaiData) {
            DanKaiEntity dankaiEntity = new DanKaiEntity();
            dankaiEntity.setChoteiNendo(entity.getChoteiNendo());
            dankaiEntity.setFukaNendo(entity.getFukaNendo());
            dankaiEntity.setTsuchishoNo(entity.getTsuchishoNo());
            dankaiEntity.setRirekiNo(entity.getRirekiNo());
            dankaiEntity.setHihokenshaNo(entity.getHihokenshaNo());
            dankaiEntity.setDankai(entity.getDankai());
            dankaiEntity.setChoshuHouhou(entity.getChoshuHouhou());
            dankaiEntity.setChoteiId(entity.getChoteiId());
            dankaiEntity.setDogetsuFlag(0);
            if (調定年度.equals(賦課年度)) {
                if (shoriDateKanriData == null || shoriDateKanriData.getKijunTimestamp() == null
                        || shoriDateKanriData.getKijunTimestamp().isEmpty()
                        || entity.getChoteiNichiji() == null || entity.getChoteiNichiji().isEmpty()
                        || (entity.getChoteiNichiji().isBefore(shoriDateKanriData.getKijunTimestamp())
                        && entity.getChoteiNendo().equals(shoriDateKanriData.getNendo()))) {
                    dankaiEntity.setKarisanFlag(仮算定);
                } else if (shoriDateKanriData.getKijunTimestamp().isBeforeOrEquals(entity.getChoteiNichiji())
                        && entity.getChoteiNendo().equals(shoriDateKanriData.getNendo())) {
                    dankaiEntity.setKarisanFlag(本算定);
                }
            } else {
                dankaiEntity.setKarisanFlag(本算定);
            }
            dankaiEntity.setZengetsusueChoteigaku(entity.getChoteigaku());
            dankaiEntity.setFueChoteigaku(null);
            dankaiEntity.setGenChoteigaku(null);
            dankaiEntity.setDogetsusueChoteigaku(null);
            choteiboSakuseiMapper.insertTmpDankai(dankaiEntity);
        }
    }

    /**
     * 段階小計一時テーブルに登録します。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 徴収方法 徴収方法
     * @param 当月フラグ 当月フラグ
     */
    private void insert段階小計一時テーブル(FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            RString 徴収方法,
            int 当月フラグ,
            RString 仮算フラグ) {
        Map<String, Object> param = new HashMap<>();
        param.put(KEY_CHOTEINENDO.toString(), 調定年度);
        param.put(KEY_FUKANENDO.toString(), 賦課年度);
        param.put(KEY_CHUSHUHOUHOU.toString(), 徴収方法);
        param.put(KEY_DOGETSUFLG.toString(), 当月フラグ);
        param.put(KEY_KARISANFLG.toString(), 仮算フラグ);
        List<DankaiKensuEntity> dankaiKensu = choteiboSakuseiMapper.select所得段階の件数(param);
        for (DankaiKensuEntity entity : dankaiKensu) {
            DankaiShokeiEntity dankaiShokeiEntity = new DankaiShokeiEntity();
            dankaiShokeiEntity.setChoteiNendo(調定年度);
            dankaiShokeiEntity.setFukaNendo(賦課年度);
            dankaiShokeiEntity.setChoshuHouhou(徴収方法);
            dankaiShokeiEntity.setDankai(entity.getDankai());
            dankaiShokeiEntity.setDogetsuFlag(当月フラグ);
            dankaiShokeiEntity.setKarisanFlag(仮算フラグ);
            if (当月フラグ == 当月) {
                dankaiShokeiEntity.setDogetsusueKensu(entity.getDankaiKensu());
            } else if (当月フラグ == 前月) {
                dankaiShokeiEntity.setZengetsusueKensu(entity.getDankaiKensu());
            }
            if (ChoshuHohoKibetsu.特別徴収.getコード().equals(徴収方法) && 当月フラグ == 当月) {
                dankaiShokeiEntity.setTokuchosyaKensu(entity.getDankaiKensu());
            } else if (ChoshuHohoKibetsu.普通徴収.getコード().equals(徴収方法) && 当月フラグ == 当月) {
                dankaiShokeiEntity.setFuchosyaKensu(entity.getDankaiKensu());
            }
            choteiboSakuseiMapper.insertTmpDankaiShokei(dankaiShokeiEntity);
        }
    }

    /**
     * 内併徴者数に段階小計一時テーブルを更新します。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     */
    private void update内併徴者数(FlexibleYear 調定年度, FlexibleYear 賦課年度, RString 仮算フラグ) {
        Map<String, Object> param = new HashMap<>();
        param.put(KEY_CHOTEINENDO.toString(), 調定年度);
        param.put(KEY_FUKANENDO.toString(), 賦課年度);
        param.put(KEY_KARISANFLG.toString(), 仮算フラグ);
        List<NaiheisyaKensuEntity> naiheisyaKensu = choteiboSakuseiMapper.select内併徴者数(param);
        for (NaiheisyaKensuEntity entity : naiheisyaKensu) {
            choteiboSakuseiMapper.update内併徴者数(entity);
        }
    }

    private void update増減調定額の小計(FlexibleYear 調定年度, FlexibleYear 賦課年度) {
        Map<String, Object> param = new HashMap<>();
        param.put(KEY_CHOTEINENDO.toString(), 調定年度);
        param.put(KEY_FUKANENDO.toString(), 賦課年度);
        List<DankaiShokeiEntity> 増の調定額の小計リスト = choteiboSakuseiMapper.select増の調定額の小計(param);
        List<DankaiShokeiEntity> 減の調定額の小計リスト = choteiboSakuseiMapper.select減の調定額の小計(param);
        for (DankaiShokeiEntity 増の調定額の小計 : 増の調定額の小計リスト) {
            choteiboSakuseiMapper.update増の調定額の小計(増の調定額の小計);
        }
        for (DankaiShokeiEntity 減の調定額の小計 : 減の調定額の小計リスト) {
            choteiboSakuseiMapper.update減の調定額の小計(減の調定額の小計);
        }
    }

    /**
     * 期別小計一時テーブルに登録します。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     */
    private void insert期別小計一時テーブル(FlexibleYear 調定年度, FlexibleYear 賦課年度) {
        List<KibetsuShokei> kibetsuShokei = ChoteiboShukei.kibetsuChoteigakuShokei(
                create期別リスト(調定年度, 賦課年度));
        for (KibetsuShokei entity : kibetsuShokei) {
            KibetsuShokeiEntity kibetsuShokeiEntity = new KibetsuShokeiEntity();
            kibetsuShokeiEntity.setChoteiNendo(entity.getChoteiNendo());
            kibetsuShokeiEntity.setFukaNendo(entity.getFukaNendo());
            kibetsuShokeiEntity.setChoshuHouhou(entity.getChoshuHouhou());
            kibetsuShokeiEntity.setDai1kiChoteigakuCount(entity.getDai1kiChoteiGakuCount());
            kibetsuShokeiEntity.setDai2kiChoteigakuCount(entity.getDai2kiChoteiGakuCount());
            kibetsuShokeiEntity.setDai3kiChoteigakuCount(entity.getDai3kiChoteiGakuCount());
            kibetsuShokeiEntity.setDai4kiChoteigakuCount(entity.getDai4kiChoteiGakuCount());
            kibetsuShokeiEntity.setDai5kiChoteigakuCount(entity.getDai5kiChoteiGakuCount());
            kibetsuShokeiEntity.setDai6kiChoteigakuCount(entity.getDai6kiChoteiGakuCount());
            kibetsuShokeiEntity.setDai7kiChoteigakuCount(entity.getDai7kiChoteiGakuCount());
            kibetsuShokeiEntity.setDai8kiChoteigakuCount(entity.getDai8kiChoteiGakuCount());
            kibetsuShokeiEntity.setDai9kiChoteigakuCount(entity.getDai9kiChoteiGakuCount());
            kibetsuShokeiEntity.setDai10kiChoteigakuCount(entity.getDai10kiChoteiGakuCount());
            kibetsuShokeiEntity.setDai11kiChoteigakuCount(entity.getDai11kiChoteiGakuCount());
            kibetsuShokeiEntity.setDai12kiChoteigakuCount(entity.getDai12kiChoteiGakuCount());
            kibetsuShokeiEntity.setDai13kiChoteigakuCount(entity.getDai13kiChoteiGakuCount());
            kibetsuShokeiEntity.setDai14kiChoteigakuCount(entity.getDai14kiChoteiGakuCount());
            choteiboSakuseiMapper.insertTmpKibetsuShokei(kibetsuShokeiEntity);
        }
    }

    /**
     * 調定額の小計に段階小計一時テーブルに更新します。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     */
    private void update調定額の小計(FlexibleYear 調定年度, FlexibleYear 賦課年度) {
        List<DankaiChoteigakuShokei> shokeiList = ChoteiboShukei.dankaiChoteigakuShokei(
                create段階リスト(調定年度, 賦課年度));
        for (DankaiChoteigakuShokei shokei : shokeiList) {
            choteiboSakuseiMapper.update調定額の小計(shokei);
        }
    }

    /**
     * 期別リストを作成する
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @return List<KiBetsu>
     */
    private List<Kibetsu> create期別リスト(FlexibleYear 調定年度, FlexibleYear 賦課年度) {
        List<Kibetsu> list = new ArrayList<>();
        Map<String, Object> param = new HashMap<>();
        param.put(KEY_CHOTEINENDO.toString(), 調定年度);
        param.put(KEY_FUKANENDO.toString(), 賦課年度);
        List<KibetsuEntity> kiBetsuEntity = choteiboSakuseiMapper.select期別情報(param);
        for (KibetsuEntity entity : kiBetsuEntity) {
            Kibetsu kibetsu = Kibetsu.createParam(
                    entity.getChoteiNendo(),
                    entity.getFukaNendo(),
                    entity.getTsuchishoNo(),
                    entity.getRirekiNo(),
                    entity.getHihokenshaNo(),
                    entity.getChoshuHouhou(),
                    entity.getKi(),
                    entity.getChoteiId(),
                    entity.getDai1kiChoteiGaku(),
                    entity.getDai2kiChoteiGaku(),
                    entity.getDai3kiChoteiGaku(),
                    entity.getDai4kiChoteiGaku(),
                    entity.getDai5kiChoteiGaku(),
                    entity.getDai6kiChoteiGaku(),
                    entity.getDai7kiChoteiGaku(),
                    entity.getDai8kiChoteiGaku(),
                    entity.getDai9kiChoteiGaku(),
                    entity.getDai10kiChoteiGaku(),
                    entity.getDai11kiChoteiGaku(),
                    entity.getDai12kiChoteiGaku(),
                    entity.getDai13kiChoteiGaku(),
                    entity.getDai14kiChoteiGaku()
            );
            list.add(kibetsu);
        }
        return list;
    }

    /**
     * 段階リストを作成する
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @return List<DanKai>
     */
    private List<DanKai> create段階リスト(FlexibleYear 調定年度, FlexibleYear 賦課年度) {
        List<DanKai> list = new ArrayList<>();
        Map<String, Object> param = new HashMap<>();
        param.put(KEY_CHOTEINENDO.toString(), 調定年度);
        param.put(KEY_FUKANENDO.toString(), 賦課年度);
        List<DanKaiEntity> danKaiList = choteiboSakuseiMapper.select段階情報(param);
        for (DanKaiEntity entity : danKaiList) {
            DanKai dankai = DanKai.createParam(entity.getChoteiNendo(),
                    entity.getFukaNendo(),
                    entity.getTsuchishoNo(),
                    entity.getRirekiNo(),
                    entity.getHihokenshaNo(),
                    entity.getDankai(),
                    entity.getChoshuHouhou(),
                    entity.getChoteiId(),
                    entity.getDogetsuFlag(),
                    entity.getKarisanFlag(),
                    entity.getZengetsusueChoteigaku(),
                    entity.getFueChoteigaku(),
                    entity.getGenChoteigaku(),
                    entity.getDogetsusueChoteigaku()
            );
            list.add(dankai);
        }
        return list;
    }

    /**
     * 期別小計リストを作成する
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @return List<KibetsuShokei>
     */
    private List<KibetsuShokei> create期別小計リスト(FlexibleYear 調定年度, FlexibleYear 賦課年度) {
        List<KibetsuShokei> list = new ArrayList<>();
        Map<String, Object> param = new HashMap<>();
        param.put(KEY_CHOTEINENDO.toString(), 調定年度);
        param.put(KEY_FUKANENDO.toString(), 賦課年度);
        List<KibetsuShokeiEntity> kibetsuShokeiList = choteiboSakuseiMapper.select期別小計情報(param);
        for (KibetsuShokeiEntity entity : kibetsuShokeiList) {
            KibetsuShokei kibetsuShokei = KibetsuShokei.createParam(entity.getChoteiNendo(),
                    entity.getFukaNendo(),
                    entity.getChoshuHouhou(),
                    entity.getDai1kiChoteigakuCount(),
                    entity.getDai2kiChoteigakuCount(),
                    entity.getDai3kiChoteigakuCount(),
                    entity.getDai4kiChoteigakuCount(),
                    entity.getDai5kiChoteigakuCount(),
                    entity.getDai6kiChoteigakuCount(),
                    entity.getDai7kiChoteigakuCount(),
                    entity.getDai8kiChoteigakuCount(),
                    entity.getDai9kiChoteigakuCount(),
                    entity.getDai10kiChoteigakuCount(),
                    entity.getDai11kiChoteigakuCount(),
                    entity.getDai12kiChoteigakuCount(),
                    entity.getDai13kiChoteigakuCount(),
                    entity.getDai14kiChoteigakuCount()
            );
            list.add(kibetsuShokei);
        }
        return list;
    }

    /**
     * 段階小計リストを作成する
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @return List<DankaiShokei>
     */
    private List<DankaiShokei> create段階小計リスト(FlexibleYear 調定年度, FlexibleYear 賦課年度) {
        List<DankaiShokei> list = new ArrayList<>();
        Map<String, Object> param = new HashMap<>();
        param.put(KEY_CHOTEINENDO.toString(), 調定年度);
        param.put(KEY_FUKANENDO.toString(), 賦課年度);
        List<DankaiShokeiEntity> dankaiShokeiList = choteiboSakuseiMapper.select段階小計情報(param);
        for (DankaiShokeiEntity entity : dankaiShokeiList) {
            DankaiShokei dankaiShokei = DankaiShokei.createParam(entity.getChoteiNendo(),
                    entity.getFukaNendo(),
                    entity.getChoshuHouhou(),
                    entity.getDankai(),
                    entity.getDogetsuFlag(),
                    entity.getKarisanFlag(),
                    entity.getZengetsusueKensu(),
                    entity.getZengetsusueChoteigakuCount(),
                    entity.getFueKensu(),
                    entity.getFueChoteigakuCount(),
                    entity.getGenKensu(),
                    entity.getGenChoteigakuCount(),
                    entity.getDogetsusueKensu(),
                    entity.getDogetsusueChoteigakuCount(),
                    entity.getTokuchosyaKensu(),
                    entity.getFuchosyaKensu(),
                    entity.getNaiheisyaKensu());
            list.add(dankaiShokei);
        }
        return list;
    }

    /**
     * 期別/段階合計一時テーブルを登録します。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     */
    private void insert合計一時テーブル(FlexibleYear 調定年度, FlexibleYear 賦課年度) {
        List<Gokei> gokeiList = new ArrayList<>();
        Gokei gokei = Gokei.createParam(create期別小計リスト(調定年度, 賦課年度),
                create段階小計リスト(調定年度, 賦課年度));
        gokeiList.add(gokei);
        List<Gokeigo> gokeigoList = ChoteiboShukei.choteiboDataGokei(gokeiList);
        for (Gokeigo list : gokeigoList) {
            List<KibetsuGokeigo> kibetsuGokeigoList = list.getKibetsuGokeigoList();
            for (KibetsuGokeigo param : kibetsuGokeigoList) {
                KibetsuGokeiEntity kibetsuGokeiEntity = new KibetsuGokeiEntity();
                kibetsuGokeiEntity.setChoteiNendo(param.getChoteiNendo());
                kibetsuGokeiEntity.setFukaNendo(param.getFukaNendo());
                kibetsuGokeiEntity.setChoshuHouhou(param.getChoshuHouhou());
                kibetsuGokeiEntity.setTobetsuChoteigakuCount(param.getTobetsuChoteiGakuCount());
                kibetsuGokeiEntity.setFutsuChoteigakuCount(param.getFutsuChoteiGakuCount());
                kibetsuGokeiEntity.setTobetsuTofutsuChoteigakuCount(param.getTobetsuTofutsuChoteiGakuCount());
                kibetsuGokeiEntity.setGenmenCount(null);
                kibetsuGokeiEntity.setGenmenChoteigaku(null);
                kibetsuGokeiEntity.setTkSaishutsuKampuCount(null);
                kibetsuGokeiEntity.setTkSaishutsuKampuChoteigaku(null);
                kibetsuGokeiEntity.setFuSaishutsuKampuCount(null);
                kibetsuGokeiEntity.setFuSaishutsuKampuChoteigaku(null);
                choteiboSakuseiMapper.insertTmpKibetsuGokei(kibetsuGokeiEntity);
            }

            List<DankaiGokeigo> dankaiGokeigoList = list.getDankaiGokeigoList();
            for (DankaiGokeigo param : dankaiGokeigoList) {
                DankaiGokeiEntity dankaiGokeiEntity = new DankaiGokeiEntity();
                dankaiGokeiEntity.setChoteiNendo(param.getChoteiNendo());
                dankaiGokeiEntity.setFukaNendo(param.getFukaNendo());
                dankaiGokeiEntity.setChoshuHouhou(param.getChoshuHouhou());
                if (null != param.getDogetsuFlag()) {
                    dankaiGokeiEntity.setDogetsuFlag(param.getDogetsuFlag());
                }
                dankaiGokeiEntity.setZengetsusueKensuCount(param.getZengetsusueKensuCount());
                dankaiGokeiEntity.setZengetsusueChoteigakuCount(param.getZengetsusueChoteigakuCount());
                dankaiGokeiEntity.setFueZennbuKennsuuGokei(null);
                dankaiGokeiEntity.setFueZennbuChoteigakuGokei(null);
                dankaiGokeiEntity.setGenZennbuKennsuuGokei(null);
                dankaiGokeiEntity.setGenZennbuChoteigakuGokei(null);
                dankaiGokeiEntity.setDogetsusueKensuCount(param.getDogetsusueKensuCount());
                dankaiGokeiEntity.setDogetsusueChoteigakuCount(param.getDogetsusueChoteigakuCount());
                dankaiGokeiEntity.setTokuchosyaKensuCount(param.getTokuchosyaKensuCount());
                dankaiGokeiEntity.setFuchosyaKensuCount(param.getFuchosyaKensuCount());
                dankaiGokeiEntity.setNaiheisyaKensuCount(param.getNaiheisyaKensuCount());
                choteiboSakuseiMapper.insertTmpDankaiGokei(dankaiGokeiEntity);
            }
        }
    }

    /**
     * 調定額の合計に段階合計一時テーブルを更新します。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     */
    private void update調定額の合計(FlexibleYear 調定年度, FlexibleYear 賦課年度) {
        Map<String, Object> param = new HashMap<>();
        param.put(KEY_CHOTEINENDO.toString(), 調定年度);
        param.put(KEY_FUKANENDO.toString(), 賦課年度);
        List<DankaiGokeiEntity> 段階合計リスト = choteiboSakuseiMapper.select段階合計From段階小計一時テーブル(param);
        for (DankaiGokeiEntity 段階合計 : 段階合計リスト) {
            choteiboSakuseiMapper.update段階合計情報(段階合計);
        }
    }

    /**
     * 減免の件数と減免額に減免の件数と減免額を更新します
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 開始調定日時 開始調定日時
     * @param 終了調定日時 終了調定日時
     */
    private void update減免の件数と減免額(FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            YMDHMS 開始調定日時,
            YMDHMS 終了調定日時) {
        Map<String, Object> param = new HashMap<>();
        param.put(KEY_CHOTEINENDO.toString(), 調定年度);
        param.put(KEY_FUKANENDO.toString(), 賦課年度);
        param.put(KEY_CHUSHUTSUSTYMD.toString(), 開始調定日時);
        param.put(KEY_CHUSHUTSUENDYMD.toString(), 終了調定日時);
        List<GenmenEntity> denmenEntity = choteiboSakuseiMapper.select減免の件数と減免額(param);
        for (GenmenEntity entity : denmenEntity) {
            choteiboSakuseiMapper.update減免の件数と減免額(entity);
        }
    }

    /**
     * 期別合計一時テーブルに歳出還付の件数と歳出還付の調定額の更新します。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     */
    private void update歳出還付の件数と金額(FlexibleYear 調定年度, FlexibleYear 賦課年度, YMDHMS 終了調定日時) {
        Map<String, Object> param = new HashMap<>();
        param.put(KEY_CHOTEINENDO.toString(), 調定年度);
        param.put(KEY_FUKANENDO.toString(), 賦課年度);
        param.put(KEY_CHUSHUTSUSTYMD.toString(), parameter.getChushutsuStYMD());
        param.put(KEY_CHUSHUTSUENDYMD.toString(), 終了調定日時);

        List<SaishutsuKampuEntity> tmpTkEntity = choteiboSakuseiMapper.select特徴歳出還付情報(param);
        for (SaishutsuKampuEntity entity : tmpTkEntity) {
            choteiboSakuseiMapper.update特徴歳出還付(entity);
        }
        List<SaishutsuKampuEntity> tmpFuEntity = choteiboSakuseiMapper.select普徴歳出還付情報(param);
        for (SaishutsuKampuEntity entity : tmpFuEntity) {
            choteiboSakuseiMapper.update普徴歳出還付(entity);
        }
    }

    /**
     * 「特別徴収」の場合、期別のデータに合計部分一時テーブルを登録します。
     *
     * @param 調定年度 調定年度
     * @param 当年度 当年度
     * @param 前年度 前年度
     * @param 前々年度 前々年度
     */
    private void insert合計部分一時テーブル_特別徴収(FlexibleYear 調定年度,
            FlexibleYear 当年度,
            FlexibleYear 前年度,
            FlexibleYear 前々年度) {
        Map<String, Object> param = new HashMap<>();
        param.put(KEY_CHOTEINENDO.toString(), 調定年度);
        param.put(KEY_DANNENDO.toString(), 当年度);
        param.put(KEY_ZENNENDO.toString(), 前年度);
        param.put(KEY_ZENZENNENDO.toString(), 前々年度);
        param.put(KEY_CHUSHUHOUHOU.toString(), ChoshuHohoKibetsu.特別徴収.getコード());

        List<TokuchoKibetusDataEntity> tokuchoKibetusDataList = choteiboSakuseiMapper.select特徴期別のデータ(param);
        for (TokuchoKibetusDataEntity entity : tokuchoKibetusDataList) {
            GokeiBubunEntity gokeiBubunEntity = new GokeiBubunEntity();
            gokeiBubunEntity.setChoshuHouhou(entity.getChoshuHouhou());
            gokeiBubunEntity.setChoteigaku4GatsuCount(entity.getDai1kiChoteigakuGokei());
            gokeiBubunEntity.setChoteigaku6GatsuCount(entity.getDai2kiChoteigakuGokei());
            gokeiBubunEntity.setChoteigaku8GatsuCount(entity.getDai3kiChoteigakuGokei());
            gokeiBubunEntity.setChoteigaku10GatsuCount(entity.getDai4kiChoteigakuGokei());
            gokeiBubunEntity.setChoteigaku12GatsuCount(entity.getDai5kiChoteigakuGokei());
            gokeiBubunEntity.setChoteigaku2GatsuCount(entity.getDai6kiChoteigakuGokei());
            choteiboSakuseiMapper.insertTmpGokeiBubun(gokeiBubunEntity);
        }
    }

    /**
     * 「普通徴収」の場合、期別のデータに合計部分一時テーブルを登録します。
     *
     * @param 調定年度 調定年度
     * @param 当年度 当年度
     * @param 前年度 前年度
     * @param 前々年度 前々年度
     * @param 徴収方法 徴収方法
     */
    private void insert合計部分一時テーブル_普通徴収(FlexibleYear 調定年度,
            FlexibleYear 当年度,
            FlexibleYear 前年度,
            FlexibleYear 前々年度) {
        Map<String, Object> param = new HashMap<>();
        param.put(KEY_CHOTEINENDO.toString(), 調定年度);
        param.put(KEY_FUKANENDO.toString(), 調定年度);
        param.put(KEY_DANNENDO.toString(), 当年度);
        param.put(KEY_ZENNENDO.toString(), 前年度);
        param.put(KEY_ZENZENNENDO.toString(), 前々年度);
        param.put(KEY_CHUSHUHOUHOU.toString(), ChoshuHohoKibetsu.普通徴収.getコード());

        List<KibetsuShokeiEntity> kibetsuShokeiList = choteiboSakuseiMapper.select普徴期別小計情報(param);
        List<KibetsuShokeiGokeiEntity> kibetsuShokeiGokeiList = choteiboSakuseiMapper.select期別小計の合計情報(param);
        FuchoKiUtil 月期対応取得_普徴 = new FuchoKiUtil(当年度);
        KitsukiList 期月リスト_普徴 = 月期対応取得_普徴.get期月リスト();
        KanendoKiUtil 月期対応取得_過年度 = new KanendoKiUtil(当年度);
        KitsukiList 期月リスト_過年度 = 月期対応取得_過年度.get期月リスト();
        GokeiBubunEntity gokeiBubunEntity = new GokeiBubunEntity();
        gokeiBubunEntity.setChoshuHouhou(ChoshuHohoKibetsu.普通徴収.getコード());
        for (KibetsuShokeiEntity entity : kibetsuShokeiList) {
            RString 期 = 期月リスト_普徴.get月の期(Tsuki._4月).get期();
            gokeiBubunEntity.add月の調定額の小計By月別(Tsuki._4月, entity.get調定額の小計By期別(期));
            期 = 期月リスト_普徴.get月の期(Tsuki._5月).get期();
            gokeiBubunEntity.add月の調定額の小計By月別(Tsuki._5月, entity.get調定額の小計By期別(期));
            期 = 期月リスト_普徴.get月の期(Tsuki._6月).get期();
            gokeiBubunEntity.add月の調定額の小計By月別(Tsuki._6月, entity.get調定額の小計By期別(期));
            期 = 期月リスト_普徴.get月の期(Tsuki._7月).get期();
            gokeiBubunEntity.add月の調定額の小計By月別(Tsuki._7月, entity.get調定額の小計By期別(期));
            期 = 期月リスト_普徴.get月の期(Tsuki._8月).get期();
            gokeiBubunEntity.add月の調定額の小計By月別(Tsuki._8月, entity.get調定額の小計By期別(期));
            期 = 期月リスト_普徴.get月の期(Tsuki._9月).get期();
            gokeiBubunEntity.add月の調定額の小計By月別(Tsuki._9月, entity.get調定額の小計By期別(期));
            期 = 期月リスト_普徴.get月の期(Tsuki._10月).get期();
            gokeiBubunEntity.add月の調定額の小計By月別(Tsuki._10月, entity.get調定額の小計By期別(期));
            期 = 期月リスト_普徴.get月の期(Tsuki._11月).get期();
            gokeiBubunEntity.add月の調定額の小計By月別(Tsuki._11月, entity.get調定額の小計By期別(期));
            期 = 期月リスト_普徴.get月の期(Tsuki._12月).get期();
            gokeiBubunEntity.add月の調定額の小計By月別(Tsuki._12月, entity.get調定額の小計By期別(期));
            期 = 期月リスト_普徴.get月の期(Tsuki._1月).get期();
            gokeiBubunEntity.add月の調定額の小計By月別(Tsuki._1月, entity.get調定額の小計By期別(期));
            期 = 期月リスト_普徴.get月の期(Tsuki._2月).get期();
            gokeiBubunEntity.add月の調定額の小計By月別(Tsuki._2月, entity.get調定額の小計By期別(期));
            期 = 期月リスト_普徴.get月の期(Tsuki._3月).get期();
            gokeiBubunEntity.add月の調定額の小計By月別(Tsuki._3月, entity.get調定額の小計By期別(期));
            期 = 期月リスト_普徴.get月の期(Tsuki.翌年度4月).get期();
            gokeiBubunEntity.add月の調定額の小計By月別(Tsuki.翌年度4月, entity.get調定額の小計By期別(期));
            期 = 期月リスト_普徴.get月の期(Tsuki.翌年度5月).get期();
            gokeiBubunEntity.add月の調定額の小計By月別(Tsuki.翌年度5月, entity.get調定額の小計By期別(期));
        }
        for (KibetsuShokeiGokeiEntity entity : kibetsuShokeiGokeiList) {
            RString 期 = 期月リスト_過年度.get月の期(Tsuki._4月).get期();
            gokeiBubunEntity.add月の調定額の小計By月別(Tsuki._4月, entity.get調定額の合計By期別(期));
            期 = 期月リスト_過年度.get月の期(Tsuki._5月).get期();
            gokeiBubunEntity.add月の調定額の小計By月別(Tsuki._5月, entity.get調定額の合計By期別(期));
            期 = 期月リスト_過年度.get月の期(Tsuki._6月).get期();
            gokeiBubunEntity.add月の調定額の小計By月別(Tsuki._6月, entity.get調定額の合計By期別(期));
            期 = 期月リスト_過年度.get月の期(Tsuki._7月).get期();
            gokeiBubunEntity.add月の調定額の小計By月別(Tsuki._7月, entity.get調定額の合計By期別(期));
            期 = 期月リスト_過年度.get月の期(Tsuki._8月).get期();
            gokeiBubunEntity.add月の調定額の小計By月別(Tsuki._8月, entity.get調定額の合計By期別(期));
            期 = 期月リスト_過年度.get月の期(Tsuki._9月).get期();
            gokeiBubunEntity.add月の調定額の小計By月別(Tsuki._9月, entity.get調定額の合計By期別(期));
            期 = 期月リスト_過年度.get月の期(Tsuki._10月).get期();
            gokeiBubunEntity.add月の調定額の小計By月別(Tsuki._10月, entity.get調定額の合計By期別(期));
            期 = 期月リスト_過年度.get月の期(Tsuki._11月).get期();
            gokeiBubunEntity.add月の調定額の小計By月別(Tsuki._11月, entity.get調定額の合計By期別(期));
            期 = 期月リスト_過年度.get月の期(Tsuki._12月).get期();
            gokeiBubunEntity.add月の調定額の小計By月別(Tsuki._12月, entity.get調定額の合計By期別(期));
            期 = 期月リスト_過年度.get月の期(Tsuki._1月).get期();
            gokeiBubunEntity.add月の調定額の小計By月別(Tsuki._1月, entity.get調定額の合計By期別(期));
            期 = 期月リスト_過年度.get月の期(Tsuki._2月).get期();
            gokeiBubunEntity.add月の調定額の小計By月別(Tsuki._2月, entity.get調定額の合計By期別(期));
            期 = 期月リスト_過年度.get月の期(Tsuki._3月).get期();
            gokeiBubunEntity.add月の調定額の小計By月別(Tsuki._3月, entity.get調定額の合計By期別(期));
        }
        choteiboSakuseiMapper.insertTmpGokeiBubun(gokeiBubunEntity);
    }

    /**
     * 当月末の段階のデータに合計部分一時テーブルを更新します。
     *
     * @param 調定年度 調定年度
     * @param 当年度 当年度
     * @param 前年度 前年度
     * @param 前々年度 前々年度
     * @param 仮算フラグ 仮算フラグ
     */
    private void update当月末の段階のデータ(FlexibleYear 調定年度,
            FlexibleYear 当年度,
            FlexibleYear 前年度,
            FlexibleYear 前々年度,
            RString 仮算フラグ) {
        Map<String, Object> param = new HashMap<>();
        param.put(KEY_CHOTEINENDO.toString(), 調定年度);
        param.put(KEY_DANNENDO.toString(), 当年度);
        param.put(KEY_ZENNENDO.toString(), 前年度);
        param.put(KEY_ZENZENNENDO.toString(), 前々年度);
        param.put(KEY_DOGETSUFLG.toString(), 当月);
        param.put(KEY_KARISANFLG.toString(), 仮算フラグ);
        List<DangatsuDankaiDataEntity> dangatsuDankaiDataList = choteiboSakuseiMapper.select当月末の段階のデータ(param);
        for (DangatsuDankaiDataEntity entity : dangatsuDankaiDataList) {
            GokeiBubunEntity gokeiBubunEntity = new GokeiBubunEntity();
            gokeiBubunEntity.setChoshuHouhou(entity.getChoshuHouhou());
            gokeiBubunEntity.setDankai(entity.getDankai());
            gokeiBubunEntity.setDogetsuFlag(entity.getDogetsuFlag());
            gokeiBubunEntity.setKarisanFlag(entity.getKarisanFlag());
            gokeiBubunEntity.setDogetsusueChoteigakuCount(entity.getDogetsusueChoteigakuCount());
            gokeiBubunEntity.setDogetsusueKensuCount(entity.getDogetsusueKensuCount());
            gokeiBubunEntity.setFueChoteigakuCount(entity.getFueChoteigakuCount());
            gokeiBubunEntity.setFueKensuCount(entity.getFueKensuCount());
            gokeiBubunEntity.setGenChoteigakuCount(entity.getGenChoteigakuCount());
            gokeiBubunEntity.setGenKensuCount(entity.getGenKensuCount());
            choteiboSakuseiMapper.insertTmpGokeiBubun(gokeiBubunEntity);
        }
    }

    /**
     * 前月末の段階のデータに合計部分一時テーブルを更新します。
     *
     * @param 調定年度 調定年度
     * @param 当年度 当年度
     * @param 前年度 前年度
     * @param 前々年度 前々年度
     * @param 仮算フラグ 仮算フラグ
     */
    private void update前月末の段階のデータ(FlexibleYear 調定年度,
            FlexibleYear 当年度,
            FlexibleYear 前年度,
            FlexibleYear 前々年度,
            RString 仮算フラグ) {
        Map<String, Object> param = new HashMap<>();
        param.put(KEY_CHOTEINENDO.toString(), 調定年度);
        param.put(KEY_DANNENDO.toString(), 当年度);
        param.put(KEY_ZENNENDO.toString(), 前年度);
        param.put(KEY_ZENZENNENDO.toString(), 前々年度);
        param.put(KEY_DOGETSUFLG.toString(), 前月);
        param.put(KEY_KARISANFLG.toString(), 仮算フラグ);
        List<ZengatsuDankaiDataEntity> zengatsuDankaiDataList = choteiboSakuseiMapper.select前月末の段階のデータ(param);
        for (ZengatsuDankaiDataEntity entity : zengatsuDankaiDataList) {
            GokeiBubunEntity gokeiBubunEntity = new GokeiBubunEntity();
            gokeiBubunEntity.setChoshuHouhou(entity.getChoshuHouhou());
            gokeiBubunEntity.setDankai(entity.getDankai());
            gokeiBubunEntity.setDogetsuFlag(entity.getDogetsuFlag());
            gokeiBubunEntity.setKarisanFlag(entity.getKarisanFlag());
            gokeiBubunEntity.setZengetsusueChoteigakuCount(entity.getZengetsusueChoteigakuCount());
            gokeiBubunEntity.setZengetsusueKensuCount(entity.getZengetsusueKensuCount());
            choteiboSakuseiMapper.insertTmpGokeiBubun(gokeiBubunEntity);
        }
    }

    /**
     * 所得段階の特徴/普徴者数の集計に合計部分一時テーブルを更新します。
     *
     * @param 調定年度 調定年度
     * @param 当年度 当年度
     * @param 前年度 前年度
     * @param 前々年度 前々年度
     */
    private void update段階の特徴と普徴者数(FlexibleYear 調定年度,
            FlexibleYear 当年度,
            FlexibleYear 前年度,
            FlexibleYear 前々年度,
            RString 仮算フラグ) {
        Map<String, Object> param = new HashMap<>();
        param.put(KEY_CHOTEINENDO.toString(), 調定年度);
        param.put(KEY_DANNENDO.toString(), 当年度);
        param.put(KEY_ZENNENDO.toString(), 前年度);
        param.put(KEY_ZENZENNENDO.toString(), 前々年度);
        param.put(KEY_KARISANFLG.toString(), 仮算フラグ);
        List<DankaiTksaiToFusaiKensuEntity> dankaiTksaiToFusaiKensuList
                = choteiboSakuseiMapper.select段階の特徴と普徴者数(param);
        for (DankaiTksaiToFusaiKensuEntity entity : dankaiTksaiToFusaiKensuList) {
            choteiboSakuseiMapper.update段階の特徴と普徴者数(entity);
        }
    }

    /**
     * 期別部分の集計に合計部分総計一時テーブルを登録します。
     *
     * @param 調定年度 調定年度
     * @param 当年度 当年度
     * @param 前年度 前年度
     * @param 前々年度 前々年度
     */
    private void insert合計部分総計一時テーブル(FlexibleYear 調定年度,
            FlexibleYear 当年度,
            FlexibleYear 前年度,
            FlexibleYear 前々年度) {
        Map<String, Object> param = new HashMap<>();
        param.put(KEY_CHOTEINENDO.toString(), 調定年度);
        param.put(KEY_DANNENDO.toString(), 当年度);
        param.put(KEY_ZENNENDO.toString(), 前年度);
        param.put(KEY_ZENZENNENDO.toString(), 前々年度);

        List<KibetsuBubunDataEntity> kibetsuBubunDataList = choteiboSakuseiMapper.select期別部分のデータ(param);
        for (KibetsuBubunDataEntity entity : kibetsuBubunDataList) {
            GokeiBubunSoukeiEntity gokeiBubunSoukeiEntity = new GokeiBubunSoukeiEntity();
            gokeiBubunSoukeiEntity.setChoshuHouhou(entity.getChoshuHouhou());
            gokeiBubunSoukeiEntity.setTobetsuChoteigakuSoukei(entity.getTobetsuChoteigakuSoukei());
            gokeiBubunSoukeiEntity.setFutsuChoteigakuSoukei(entity.getFutsuChoteigakuSoukei());
            gokeiBubunSoukeiEntity.setTobetsuTofutsuChoteigakuSoukei(entity.getTobetsuTofutsuChoteigakuSoukei());
            gokeiBubunSoukeiEntity.setGenmenSoukei(entity.getGenmenSoukei());
            gokeiBubunSoukeiEntity.setGenmenChoteigakuSoukei(entity.getGenmenChoteigakuSoukei());
            gokeiBubunSoukeiEntity.setTkSaishutsuKampuSoukei(entity.getTkSaishutsuKampuSoukei());
            gokeiBubunSoukeiEntity.setTkSaishutsuKampuChoteigakuSoukei(entity.getTkSaishutsuKampuChoteigakuSoukei());
            gokeiBubunSoukeiEntity.setFuSaishutsuKampuSoukei(entity.getFuSaishutsuKampuSoukei());
            gokeiBubunSoukeiEntity.setFuSaishutsuKampuChoteigakuSoukei(entity.getFuSaishutsuKampuChoteigakuSoukei());
            choteiboSakuseiMapper.insertTmpGokeiBubunSoukei(gokeiBubunSoukeiEntity);
        }
    }

    /**
     * その他部分の集計に合計部分総計一時テーブルを更新します。
     *
     * @param 調定年度 調定年度
     * @param 当年度 当年度
     * @param 前年度 前年度
     * @param 前々年度 前々年度
     */
    private void updateその他部分のデータ(FlexibleYear 調定年度,
            FlexibleYear 当年度,
            FlexibleYear 前年度,
            FlexibleYear 前々年度) {
        Map<String, Object> param = new HashMap<>();
        param.put(KEY_CHOTEINENDO.toString(), 調定年度);
        param.put(KEY_DANNENDO.toString(), 当年度);
        param.put(KEY_ZENNENDO.toString(), 前年度);
        param.put(KEY_ZENZENNENDO.toString(), 前々年度);

        List<SonotaBubunDataEntity> sonotaBubunDataList = choteiboSakuseiMapper.selectその他部分のデータ(param);
        for (SonotaBubunDataEntity entity : sonotaBubunDataList) {
            GokeiBubunSoukeiEntity gokeiBubunSoukeiEntity = new GokeiBubunSoukeiEntity();
            gokeiBubunSoukeiEntity.setChoshuHouhou(entity.getChoshuHouhou());
            gokeiBubunSoukeiEntity.setDogetsuFlag(entity.getDogetsuFlag());
            gokeiBubunSoukeiEntity.setZengetsusueChoteigakuSoukei(entity.getZengetsusueChoteigakuSoukei());
            gokeiBubunSoukeiEntity.setZengetsusueKensuSoukei(entity.getZengetsusueKensuSoukei());
            gokeiBubunSoukeiEntity.setFueZennbuChoteigakuSoukei(entity.getFueZennbuChoteigakuSoukei());
            gokeiBubunSoukeiEntity.setFueZennbuKennsuuSoukei(entity.getFueZennbuKennsuuSoukei());
            gokeiBubunSoukeiEntity.setGenZennbuChoteigakuSoukei(entity.getGenZennbuChoteigakuSoukei());
            gokeiBubunSoukeiEntity.setGenZennbuKennsuuSoukei(entity.getGenZennbuKennsuuSoukei());
            gokeiBubunSoukeiEntity.setDogetsusueChoteigakuSoukei(entity.getDogetsusueChoteigakuSoukei());
            gokeiBubunSoukeiEntity.setDogetsusueKensuSoukei(entity.getDogetsusueKensuSoukei());
            gokeiBubunSoukeiEntity.setTokuchosyaKensuSoukei(entity.getTokuchosyaKensuSoukei());
            gokeiBubunSoukeiEntity.setFuchosyaKensuSoukei(entity.getFuchosyaKensuSoukei());
            gokeiBubunSoukeiEntity.setNaiheisyaKensuSoukei(entity.getNaiheisyaKensuSoukei());
            choteiboSakuseiMapper.insertTmpGokeiBubunSoukei(gokeiBubunSoukeiEntity);
        }
    }
}
