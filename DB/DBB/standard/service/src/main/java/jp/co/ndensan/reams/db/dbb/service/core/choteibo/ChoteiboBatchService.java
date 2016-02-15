/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.choteibo;

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
import jp.co.ndensan.reams.db.dbb.definition.processprm.choteibo.ChoteiboProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo.ChoteiboChohyoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo.ChoteigakuGokeiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo.DanKaiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo.DangatsuDankaiDataEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo.DankaiDataEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo.DankaiGokeiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo.DankaiKensuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo.DankaiShokeiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo.DankaiTksaiToFusaiKensuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo.DataListEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo.GenmenEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo.GokeiBubunEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo.GokeiBubunSoukeiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo.GokeiDataListEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo.KibetsuBubunDataEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo.KibetsuDataEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo.KibetsuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo.KibetsuGokeiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo.KibetsuShokeiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo.KibetsuShokeiGokeiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo.NaiheisyaKensuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo.NendoDataListEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo.SaishutsuKampuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo.SonotaBubunDataEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo.TokuchoKibetusDataEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo.ZengatsuDankaiDataEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.basic.choteibo.IChoteiboSakuseiMapper;
import jp.co.ndensan.reams.db.dbb.service.core.MapperProvider;
import jp.co.ndensan.reams.ur.urc.business.core.noki.nokitsuki.Kitsuki;
import jp.co.ndensan.reams.ur.urc.definition.core.noki.nokitsuki.KibetsuName;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 調定簿作成バッチサービス用のクラス。
 */
public class ChoteiboBatchService {

    private static final int 当月フラグ = 1;
    private static final int 前月フラグ = 0;
    private final MapperProvider mapperProvider;
    private static IChoteiboSakuseiMapper choteiboSakuseiMapper;

    /**
     * コンストラクタです。
     */
    ChoteiboBatchService() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mapperProvider {@link MapperProvider}
     */
    ChoteiboBatchService(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ChoteiboBatchService}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ChoteiboBatchService}のインスタンス
     */
    public static ChoteiboBatchService createInstance() {
        return InstanceProvider.create(ChoteiboBatchService.class);
    }

    public List<ChoteiboChohyoEntity> initialize(ChoteiboProcessParameter parameter) {
        createTempTable();
        // 当年度データリストを作成する
        create年度データ(parameter.getShoriNendo(),
                parameter.getShoriNendo(),
                parameter.getChushutsuStYMD(),
                parameter.getChushutsuEdYMD());
        // 前年度データリストを作成する
        create年度データ(parameter.getShoriNendo(),
                parameter.getShoriNendo().minusYear(1),
                parameter.getChushutsuStYMD(),
                parameter.getChushutsuEdYMD());
        // 前々年度データリストを作成する
        create年度データ(parameter.getShoriNendo(),
                parameter.getShoriNendo().minusYear(2),
                parameter.getChushutsuStYMD(),
                parameter.getChushutsuEdYMD());
        // 合計データリストを作成する
        create合計データ(parameter.getShoriNendo(),
                parameter.getShoriNendo(),
                parameter.getShoriNendo().minusYear(1),
                parameter.getShoriNendo().minusYear(2));

        // 帳票用Entityリストを作成する ChoteiboChohyoEntity
//        lists = new ArrayList<>();
        dropTempTable();
        List<ChoteiboChohyoEntity> choteiboChohyoEntityList = get帳票用Entityリスト(
                parameter.getShoriNendo(),
                parameter.getShoriNendo());
        return choteiboChohyoEntityList;
    }

    /**
     * 一時テーブルを作成します。
     */
    public void createTempTable() {
        choteiboSakuseiMapper = mapperProvider.create(IChoteiboSakuseiMapper.class);
        // 期別情報一時テーブルを作成します。
        choteiboSakuseiMapper.createTmpKibetsu();

        // 段階情報一時テーブルを作成します。
        choteiboSakuseiMapper.createTmpDankai();

        // 期別小計一時テーブルを作成します。
        choteiboSakuseiMapper.createTmpKibetsuShokei();

        // 段階小計一時テーブルを作成します。
        choteiboSakuseiMapper.createTmpDankaiShokei();

        // 期別合計一時テーブルを作成します。
        choteiboSakuseiMapper.createTmpKibetsuGokei();

        // 段階合計一時テーブルを作成します。
        choteiboSakuseiMapper.createTmpDankaiGokei();

        // 合計部分一時テーブルを作成します。
        choteiboSakuseiMapper.createTmpGokeiBubun();

        // 合計部分総計一時テーブルを作成します。
        choteiboSakuseiMapper.createTmpGokeiBubunSoukei();
    }

    /**
     * 一時テーブルを削除します。
     */
    public void dropTempTable() {
        choteiboSakuseiMapper = mapperProvider.create(IChoteiboSakuseiMapper.class);
        // 期別情報一時テーブルを削除します。
        choteiboSakuseiMapper.dropTmpKibetsu();

        // 段階情報一時テーブルを削除します。
        choteiboSakuseiMapper.dropTmpDankai();

        // 期別小計一時テーブルを削除します。
        choteiboSakuseiMapper.dropTmpKibetsuShokei();

        // 段階小計一時テーブルを削除します。
        choteiboSakuseiMapper.dropTmpDankaiShokei();

        // 期別合計一時テーブルを削除します。
        choteiboSakuseiMapper.dropTmpKibetsuGokei();

        // 段階合計一時テーブルを削除します。
        choteiboSakuseiMapper.dropTmpDankaiGokei();

        // 合計部分一時テーブルを削除します。
        choteiboSakuseiMapper.dropTmpGokeiBubun();

        // 合計部分総計一時テーブルを削除します。
        choteiboSakuseiMapper.dropTmpGokeiBubunSoukei();
    }

    /**
     * 年度データリストを作成します。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 開始調定日時 開始調定日時
     * @param 終了調定日時 終了調定日時
     */
    public void create年度データ(FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            YMDHMS 開始調定日時,
            YMDHMS 終了調定日時) {
        insert期別情報一時テーブル(調定年度, 賦課年度, 開始調定日時, 終了調定日時);
        insert段階情報一時テーブル(調定年度, 賦課年度, 開始調定日時, 終了調定日時);
        insert段階小計一時テーブル(調定年度, 賦課年度, ChoshuHohoKibetsu.特別徴収.getコード(), 当月フラグ);
        insert段階小計一時テーブル(調定年度, 賦課年度, ChoshuHohoKibetsu.特別徴収.getコード(), 前月フラグ);
        insert段階小計一時テーブル(調定年度, 賦課年度, ChoshuHohoKibetsu.普通徴収.getコード(), 当月フラグ);
        insert段階小計一時テーブル(調定年度, 賦課年度, ChoshuHohoKibetsu.普通徴収.getコード(), 前月フラグ);

        // 内併徴者数に段階小計一時テーブルを更新する
        update内併徴者数(調定年度, 賦課年度);

        // 期別小計一時テーブルを登録する
        insert期別小計一時テーブル(調定年度, 賦課年度);

        // 調定額の小計に段階小計一時テーブルを更新する
        update調定額の小計(調定年度, 賦課年度);

        // 期別/段階合計一時テーブルを登録する
        insert合計一時テーブル(調定年度, 賦課年度);

        // 増/減部分の計算の集計した結果をに「段階合計一時テーブル」の該当段階に対するデータを更新する
        update調定額の合計(調定年度, 賦課年度);

        // 減免の件数と減免額に期別合計一時テーブルを更新する
        update減免の件数と減免額(調定年度, 賦課年度, 開始調定日時, 終了調定日時);

        // 歳出還付の件数と金額に期別合計一時テーブルを更新する
        update歳出還付の件数と金額(調定年度, 賦課年度);
    }

    /**
     * 合計データリストを作成します。
     *
     * @param 当年度 当年度
     * @param 前年度 前年度
     * @param 前々年度 前々年度
     */
    private void create合計データ(FlexibleYear 調定年度,
            FlexibleYear 当年度,
            FlexibleYear 前年度,
            FlexibleYear 前々年度) {
        // 特別徴収の場合、合計部分一時テーブルを登録します。
        insert合計部分一時テーブル_特別徴収(調定年度, 当年度, 前年度, 前々年度, ChoshuHohoKibetsu.特別徴収.getコード());
        // 普通徴収の場合、合計部分一時テーブルを登録します。
        insert合計部分一時テーブル_普通徴収(調定年度, 当年度, 前年度, 前々年度, ChoshuHohoKibetsu.普通徴収.getコード());
        // 合計部分一時テーブルを更新します。
        // 当月末の段階のデータに合計部分一時テーブルを更新します。
        update当月末の段階のデータ(調定年度, 当年度, 前年度, 前々年度, 当月フラグ);
        // 前月末の段階のデータに合計部分一時テーブルを更新します。
        update前月末の段階のデータ(調定年度, 当年度, 前年度, 前々年度, 前月フラグ);
        // 所得段階の特徴/普徴者数の集計に合計部分一時テーブルを更新します。
        update段階の特徴と普徴者数(調定年度, 当年度, 前年度, 前々年度);

        // 期別部分の集計に合計部分総計一時テーブルを登録します。
        insert合計部分総計一時テーブル(調定年度, 当年度, 前年度, 前々年度);
        // その他部分の集計に合計部分総計一時テーブルを更新します。
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
    private void insert期別情報一時テーブル(FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            YMDHMS 開始調定日時,
            YMDHMS 終了調定日時) {
        Map<String, Object> param = new HashMap<>();
        param.put("choteiNendo", 調定年度);
        param.put("fukaNendo", 賦課年度);
        param.put("chushutsuStYMD", 開始調定日時);
        param.put("chushutsuEdYMD", 終了調定日時);
        choteiboSakuseiMapper = mapperProvider.create(IChoteiboSakuseiMapper.class);
        List<KibetsuDataEntity> kibetsuData = choteiboSakuseiMapper.get期別のデータ(param);
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
                case 1:
                    kibetsuEntity.setDai1kiChoteiGaku(entity.getChoteigaku());
                    break;
                case 2:
                    kibetsuEntity.setDai2kiChoteiGaku(entity.getChoteigaku());
                    break;
                case 3:
                    kibetsuEntity.setDai3kiChoteiGaku(entity.getChoteigaku());
                    break;
                case 4:
                    kibetsuEntity.setDai4kiChoteiGaku(entity.getChoteigaku());
                    break;
                case 5:
                    kibetsuEntity.setDai5kiChoteiGaku(entity.getChoteigaku());
                    break;
                case 6:
                    kibetsuEntity.setDai6kiChoteiGaku(entity.getChoteigaku());
                    break;
                case 7:
                    kibetsuEntity.setDai7kiChoteiGaku(entity.getChoteigaku());
                case 8:
                    kibetsuEntity.setDai8kiChoteiGaku(entity.getChoteigaku());
                    break;
                case 9:
                    kibetsuEntity.setDai9kiChoteiGaku(entity.getChoteigaku());
                    break;
                case 10:
                    kibetsuEntity.setDai10kiChoteiGaku(entity.getChoteigaku());
                    break;
                case 11:
                    kibetsuEntity.setDai11kiChoteiGaku(entity.getChoteigaku());
                    break;
                case 12:
                    kibetsuEntity.setDai12kiChoteiGaku(entity.getChoteigaku());
                    break;
                case 13:
                    kibetsuEntity.setDai13kiChoteiGaku(entity.getChoteigaku());
                    break;
                case 14:
                    kibetsuEntity.setDai14kiChoteiGaku(entity.getChoteigaku());
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
        param.put("choteiNendo", 調定年度);
        param.put("fukaNendo", 賦課年度);
        param.put("chushutsuStYMD", 開始調定日時);
        param.put("chushutsuEdYMD", 終了調定日時);
        choteiboSakuseiMapper = mapperProvider.create(IChoteiboSakuseiMapper.class);
        List<DankaiDataEntity> dogetsudankaiData = choteiboSakuseiMapper.get当月末の段階データ(param);
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
            dankaiEntity.setZengetsusueChoteigaku(null);
            dankaiEntity.setFueChoteigaku(null);
            dankaiEntity.setGenChoteigaku(null);
            dankaiEntity.setDogetsusueChoteigaku(entity.getChoteigaku());
            choteiboSakuseiMapper.insertTmpDankai(dankaiEntity);
        }

        List<DankaiDataEntity> zengetsudankaiData = choteiboSakuseiMapper.get前月末の段階データ(param);
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
            int 当月フラグ) {
        Map<String, Object> param = new HashMap<>();
        param.put("choteiNendo", 調定年度);
        param.put("fukaNendo", 賦課年度);
        param.put("choshuHouhou", 徴収方法);
        param.put("dogetsuFlag", 当月フラグ);
        choteiboSakuseiMapper = mapperProvider.create(IChoteiboSakuseiMapper.class);
        List<DankaiKensuEntity> dankaiKensu = choteiboSakuseiMapper.get所得段階の件数(param);
        for (DankaiKensuEntity entity : dankaiKensu) {
            DankaiShokeiEntity dankaiShokeiEntity = new DankaiShokeiEntity();
            dankaiShokeiEntity.setChoteiNendo(調定年度);
            dankaiShokeiEntity.setFukaNendo(賦課年度);
            dankaiShokeiEntity.setChoshuHouhou(徴収方法);
            dankaiShokeiEntity.setDankai(entity.getDankai());
            dankaiShokeiEntity.setDogetsuFlag(当月フラグ);
            if (当月フラグ == 1) {
                dankaiShokeiEntity.setDogetsusueKensu(entity.getDankaiKensu());
            } else if (当月フラグ == 0) {
                dankaiShokeiEntity.setZengetsusueKensu(entity.getDankaiKensu());
            }
            if (ChoshuHohoKibetsu.特別徴収.getコード().equals(当月フラグ)) {
                dankaiShokeiEntity.setTokuchosyaKensu(entity.getDankaiKensu());
            } else if (ChoshuHohoKibetsu.普通徴収.getコード().equals(当月フラグ)) {
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
    private void update内併徴者数(FlexibleYear 調定年度, FlexibleYear 賦課年度) {
        Map<String, Object> param = new HashMap<>();
        param.put("choteiNendo", 調定年度);
        param.put("fukaNendo", 賦課年度);
        choteiboSakuseiMapper = mapperProvider.create(IChoteiboSakuseiMapper.class);
        List<NaiheisyaKensuEntity> naiheisyaKensu = choteiboSakuseiMapper.get内併徴者数(param);
        for (NaiheisyaKensuEntity entity : naiheisyaKensu) {
            choteiboSakuseiMapper.update内併徴者数(entity);
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
        choteiboSakuseiMapper = mapperProvider.create(IChoteiboSakuseiMapper.class);
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
        choteiboSakuseiMapper = mapperProvider.create(IChoteiboSakuseiMapper.class);
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
        List<Kibetsu> list = new ArrayList<Kibetsu>();
        Map<String, Object> param = new HashMap<>();
        param.put("choteiNendo", 調定年度);
        param.put("fukaNendo", 賦課年度);
        choteiboSakuseiMapper = mapperProvider.create(IChoteiboSakuseiMapper.class);
        List<KibetsuEntity> kiBetsuEntity = choteiboSakuseiMapper.select期別情報(param);
        for (KibetsuEntity entity : kiBetsuEntity) {
            Kibetsu kibetsu = Kibetsu.createParam(entity.getChoteiNendo(),
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
        List<DanKai> list = new ArrayList<DanKai>();
        Map<String, Object> param = new HashMap<>();
        param.put("choteiNendo", 調定年度);
        param.put("fukaNendo", 賦課年度);
        choteiboSakuseiMapper = mapperProvider.create(IChoteiboSakuseiMapper.class);
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
        param.put("choteiNendo", 調定年度);
        param.put("fukaNendo", 賦課年度);
        choteiboSakuseiMapper = mapperProvider.create(IChoteiboSakuseiMapper.class);
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
        param.put("choteiNendo", 調定年度);
        param.put("fukaNendo", 賦課年度);
        choteiboSakuseiMapper = mapperProvider.create(IChoteiboSakuseiMapper.class);
        List<DankaiShokeiEntity> dankaiShokeiList = choteiboSakuseiMapper.select段階小計情報(param);
        for (DankaiShokeiEntity entity : dankaiShokeiList) {
            DankaiShokei dankaiShokei = DankaiShokei.createParam(entity.getChoteiNendo(),
                    entity.getFukaNendo(),
                    entity.getChoshuHouhou(),
                    entity.getDankai(),
                    entity.getDogetsuFlag(),
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
                    entity.getNaiheisyaKensu()
            );
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
        // 合計用リストを作成します。
        List<Gokei> gokeiList = new ArrayList<>();
        Gokei gokei = Gokei.createParam(create期別小計リスト(調定年度, 賦課年度),
                create段階小計リスト(調定年度, 賦課年度));
        gokeiList.add(gokei);
        choteiboSakuseiMapper = mapperProvider.create(IChoteiboSakuseiMapper.class);
        List<Gokeigo> gokeigoList = ChoteiboShukei.choteiboDataGokei(gokeiList);
        for (Gokeigo list : gokeigoList) {
            // 期別合計一時テーブルをINSERT
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

            // 段階合計一時テーブルをINSERT
            List<DankaiGokeigo> dankaiGokeigoList = list.getDankaiGokeigoList();
            for (DankaiGokeigo param : dankaiGokeigoList) {
                DankaiGokeiEntity dankaiGokeiEntity = new DankaiGokeiEntity();
                dankaiGokeiEntity.setChoteiNendo(param.getChoteiNendo());
                dankaiGokeiEntity.setFukaNendo(param.getFukaNendo());
                dankaiGokeiEntity.setChoshuHouhou(param.getChoshuHouhou());
                dankaiGokeiEntity.setDogetsuFlag(param.getDogetsuFlag());
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
        param.put("choteiNendo", 調定年度);
        param.put("fukaNendo", 賦課年度);
        choteiboSakuseiMapper = mapperProvider.create(IChoteiboSakuseiMapper.class);
        // 「増」の調定額の合計に段階合計一時テーブルを更新する
        List<ChoteigakuGokeiEntity> tmpFueEntity = choteiboSakuseiMapper.get増の全部調定額の合計(param);
        for (ChoteigakuGokeiEntity entity : tmpFueEntity) {
            choteiboSakuseiMapper.update増の調定額の合計(entity);
        }

        // 「減」の調定額の合計に段階合計一時テーブルを更新する
        List<ChoteigakuGokeiEntity> tmpGenEntity = choteiboSakuseiMapper.get減の全部調定額の合計(param);
        for (ChoteigakuGokeiEntity entity : tmpGenEntity) {
            choteiboSakuseiMapper.update減の調定額の合計(entity);
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
        param.put("choteiNendo", 調定年度);
        param.put("fukaNendo", 賦課年度);
        param.put("chushutsuStYMD", 開始調定日時);
        param.put("chushutsuEdYMD", 終了調定日時);
        choteiboSakuseiMapper = mapperProvider.create(IChoteiboSakuseiMapper.class);
        List<GenmenEntity> denmenEntity = choteiboSakuseiMapper.get減免の件数と減免額(param);
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
    private void update歳出還付の件数と金額(FlexibleYear 調定年度, FlexibleYear 賦課年度) {
        Map<String, Object> param = new HashMap<>();
        param.put("choteiNendo", 調定年度);
        param.put("fukaNendo", 賦課年度);
        choteiboSakuseiMapper = mapperProvider.create(IChoteiboSakuseiMapper.class);
        // 特別徴収の場合
        List<SaishutsuKampuEntity> tmpTkEntity = choteiboSakuseiMapper.get特徴歳出還付情報(param);
        for (SaishutsuKampuEntity entity : tmpTkEntity) {
            choteiboSakuseiMapper.update特徴歳出還付(entity);
        }
        // 普通徴収の場合
        List<SaishutsuKampuEntity> tmpFuEntity = choteiboSakuseiMapper.get普徴歳出還付情報(param);
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
     * @param 徴収方法 徴収方法
     */
    private void insert合計部分一時テーブル_特別徴収(FlexibleYear 調定年度,
            FlexibleYear 当年度,
            FlexibleYear 前年度,
            FlexibleYear 前々年度,
            RString 徴収方法) {
        Map<String, Object> param = new HashMap<>();
        param.put("choteiNendo", 調定年度);
        param.put("danNendo", 当年度);
        param.put("zenNendo", 前年度);
        param.put("zenzenNendo", 前々年度);
        param.put("choshuHouhou", 徴収方法);
        choteiboSakuseiMapper = mapperProvider.create(IChoteiboSakuseiMapper.class);
        List<TokuchoKibetusDataEntity> tokuchoKibetusDataList = choteiboSakuseiMapper.get特徴期別のデータ(param);
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
            FlexibleYear 前々年度,
            RString 徴収方法) {
        Map<String, Object> param = new HashMap<>();
        param.put("choteiNendo", 調定年度);
        param.put("danNendo", 当年度);
        param.put("zenNendo", 前年度);
        param.put("zenzenNendo", 前々年度);
        param.put("choshuHouhou", 徴収方法);
        choteiboSakuseiMapper = mapperProvider.create(IChoteiboSakuseiMapper.class);
        // 徴収方法が「普通徴収」の場合、期別小計情報を取得します。
        List<KibetsuShokeiEntity> kibetsuShokeiList = choteiboSakuseiMapper.get普徴期別小計情報(param);
        // 徴収方法が「普通徴収」の場合、期別小計の合計情報を取得します。
        List<KibetsuShokeiGokeiEntity> KibetsuShokeiGokeiList = choteiboSakuseiMapper.get期別小計の合計情報(param);

        // TODO QA #73929  共通クラスの月期対応取得_普徴．get期月リスト()がまだ作成していないので、残留。
        for (KibetsuShokeiEntity entity : kibetsuShokeiList) {
            Kitsuki ki = new Kitsuki(徴収方法, 徴収方法, KibetsuName.期);
//            int katsu = ki.get期の月(entity.getDai1kiChoteigakuCount());
            GokeiBubunEntity gokeiBubunEntity = new GokeiBubunEntity();
            // 合計部分一時テーブルを登録します。
            choteiboSakuseiMapper.insertTmpGokeiBubun(gokeiBubunEntity);
        }
    }

    /**
     * 当月末の段階のデータに合計部分一時テーブルを更新します。
     *
     * @param 調定年度 調定年度
     * @param 当年度 当年度
     * @param 前年度 前年度
     * @param 前々年度 前々年度
     * @param 当月フラグ 当月フラグ
     */
    private void update当月末の段階のデータ(FlexibleYear 調定年度,
            FlexibleYear 当年度,
            FlexibleYear 前年度,
            FlexibleYear 前々年度,
            int 当月フラグ) {
        Map<String, Object> param = new HashMap<>();
        param.put("choteiNendo", 調定年度);
        param.put("danNendo", 当年度);
        param.put("zenNendo", 前年度);
        param.put("zenzenNendo", 前々年度);
        param.put("dogetsuFlag", 当月フラグ);
        choteiboSakuseiMapper = mapperProvider.create(IChoteiboSakuseiMapper.class);
        List<DangatsuDankaiDataEntity> dangatsuDankaiDataList = choteiboSakuseiMapper.get当月末の段階のデータ(param);
        for (DangatsuDankaiDataEntity entity : dangatsuDankaiDataList) {
            choteiboSakuseiMapper.update当月末の段階のデータ(entity);
        }
    }

    /**
     * 前月末の段階のデータに合計部分一時テーブルを更新します。
     *
     * @param 調定年度 調定年度
     * @param 当年度 当年度
     * @param 前年度 前年度
     * @param 前々年度 前々年度
     * @param 当月フラグ 当月フラグ
     */
    private void update前月末の段階のデータ(FlexibleYear 調定年度,
            FlexibleYear 当年度,
            FlexibleYear 前年度,
            FlexibleYear 前々年度,
            int 当月フラグ) {
        Map<String, Object> param = new HashMap<>();
        param.put("choteiNendo", 調定年度);
        param.put("danNendo", 当年度);
        param.put("zenNendo", 前年度);
        param.put("zenzenNendo", 前々年度);
        param.put("dogetsuFlag", 当月フラグ);
        choteiboSakuseiMapper = mapperProvider.create(IChoteiboSakuseiMapper.class);
        List<ZengatsuDankaiDataEntity> zengatsuDankaiDataList = choteiboSakuseiMapper.get前月末の段階のデータ(param);
        for (ZengatsuDankaiDataEntity entity : zengatsuDankaiDataList) {
            choteiboSakuseiMapper.update前月末の段階のデータ(entity);
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
            FlexibleYear 前々年度) {
        Map<String, Object> param = new HashMap<>();
        param.put("choteiNendo", 調定年度);
        param.put("danNendo", 当年度);
        param.put("zenNendo", 前年度);
        param.put("zenzenNendo", 前々年度);
        choteiboSakuseiMapper = mapperProvider.create(IChoteiboSakuseiMapper.class);
        List<DankaiTksaiToFusaiKensuEntity> dankaiTksaiToFusaiKensuList
                = choteiboSakuseiMapper.get段階の特徴と普徴者数(param);
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
        param.put("choteiNendo", 調定年度);
        param.put("danNendo", 当年度);
        param.put("zenNendo", 前年度);
        param.put("zenzenNendo", 前々年度);
        choteiboSakuseiMapper = mapperProvider.create(IChoteiboSakuseiMapper.class);
        List<KibetsuBubunDataEntity> kibetsuBubunDataList = choteiboSakuseiMapper.get期別部分のデータ(param);
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
        param.put("choteiNendo", 調定年度);
        param.put("danNendo", 当年度);
        param.put("zenNendo", 前年度);
        param.put("zenzenNendo", 前々年度);
        choteiboSakuseiMapper = mapperProvider.create(IChoteiboSakuseiMapper.class);
        List<SonotaBubunDataEntity> sonotaBubunDataList = choteiboSakuseiMapper.getその他部分のデータ(param);
        for (SonotaBubunDataEntity entity : sonotaBubunDataList) {
            choteiboSakuseiMapper.updateその他部分のデータ(entity);
        }
    }

    private List<ChoteiboChohyoEntity> get帳票用Entityリスト(FlexibleYear choteiNendo, FlexibleYear fukaNendo) {
        List<ChoteiboChohyoEntity> list = new ArrayList<>();
        List<NendoDataListEntity> 年度データリストEntity = new ArrayList<>();
        List<DataListEntity> データリストEntity = get年度データリスト(choteiNendo, fukaNendo);

        年度データリストEntity.add((NendoDataListEntity) データリストEntity);
        List<GokeiDataListEntity> 年度合計データリストEntity = new ArrayList<>();

        return list;
    }

    private List<DataListEntity> get年度データリスト(FlexibleYear choteiNendo, FlexibleYear fukaNendo) {
        Map<String, Object> param = new HashMap<>();
        param.put("choteiNendo", choteiNendo);
        param.put("fukaNendo", fukaNendo);
        List<DataListEntity> list = new ArrayList<>();
        List<KibetsuShokeiEntity> 期別小計Entity = choteiboSakuseiMapper.select期別小計情報(param);
        List<DankaiShokeiEntity> 段階小計Entity = choteiboSakuseiMapper.select段階小計情報(param);
        List<KibetsuGokeiEntity> 期別合計Entity = choteiboSakuseiMapper.select期別合計情報(param);
        List<DankaiGokeiEntity> 段階合計Entity = choteiboSakuseiMapper.select段階合計情報(param);
        list.add((DataListEntity) 期別小計Entity);
        list.add((DataListEntity) 段階小計Entity);
        list.add((DataListEntity) 期別合計Entity);
        list.add((DataListEntity) 段階合計Entity);
        return list;
    }

}
