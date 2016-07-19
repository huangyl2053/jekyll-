/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.gemmengengakushohakkomain;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.futangendogakunintei.FutanGendogakuNintei;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.homonkaigogengaku.HomonKaigoRiyoshaFutangakuGengaku;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.riyoshafutangengaku.RiyoshaFutangakuGengaku;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shafukukeigen.ShakaifukuRiyoshaFutanKeigen;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.tokubetsuchikikasangemmen.TokubetsuchiikiKasanGemmen;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmengengaku.futangendogakunintei.FutanGendogakuNinteiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmengengaku.homonkaigogengaku.HomonKaigoRiyoshaFutangakuGengakuEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmengengaku.riyoshafutangengaku.RiyoshaFutangakuGengakuEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmengengaku.shafukukeigen.ShafukuRiyoshaFutanKeigenEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmengengaku.tokubetsuchikikasangemmen.TokubetsuchiikiKasanGemmenEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT4014RiyoshaFutangakuGengakuDac;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT4016HomonKaigoRiyoshaFutangakuGengakuDac;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenDac;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT4018KaigoHokenFutanGendogakuNinteiDac;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT4020TokubetsuchiikiKasanGemmenDac;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.gemmengengakushohakkomain.IGemmenGengakuShoHakkoMainMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 減免減額認定証・決定通知書個別発行のデータアクセスクラスです。
 *
 * @reamsid_L DBD-3540-010 xuyue
 */
public class IGemmenGengakuShoHakkoMainMapperFinder {

    private final MapperProvider mapperProvider;
    private final DbT4014RiyoshaFutangakuGengakuDac dbt4014Dac;
    private final DbT4018KaigoHokenFutanGendogakuNinteiDac dbt4018Dac;
    private final DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenDac dbt4017Dac;
    private final DbT4016HomonKaigoRiyoshaFutangakuGengakuDac dbt4016Dac;
    private final DbT4020TokubetsuchiikiKasanGemmenDac dbt4020Dac;

    /**
     * コンストラクタです。
     */
    IGemmenGengakuShoHakkoMainMapperFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.dbt4014Dac = InstanceProvider.create(DbT4014RiyoshaFutangakuGengakuDac.class);
        this.dbt4018Dac = InstanceProvider.create(DbT4018KaigoHokenFutanGendogakuNinteiDac.class);
        this.dbt4017Dac = InstanceProvider.create(DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenDac.class);
        this.dbt4016Dac = InstanceProvider.create(DbT4016HomonKaigoRiyoshaFutangakuGengakuDac.class);
        this.dbt4020Dac = InstanceProvider.create(DbT4020TokubetsuchiikiKasanGemmenDac.class);
    }

    /**
     * FinderのIntanceを作成します。
     *
     * @return GenmenGengakuNinteishoTsuchishoFinder
     */
    public static IGemmenGengakuShoHakkoMainMapperFinder createIntance() {
        return InstanceProvider.create(IGemmenGengakuShoHakkoMainMapperFinder.class);
    }

    /**
     * 利用者負担額減免の情報が存在するかを判断します。
     *
     * @param 被保険者番号 被保険者番号
     * @return 結果 true:利用者負担額減免の情報が存在
     */
    public boolean is利用者負担額減免の情報存在(HihokenshaNo 被保険者番号) {
        return dbt4014Dac.get利用者負担額減免情報の件数(被保険者番号) > 0;
    }

    /**
     * 負担限度額認定の情報が存在するかを判断します。
     *
     * @param 被保険者番号 被保険者番号
     * @return 結果 true:負担限度額認定の情報が存在
     */
    public boolean is負担限度額認定の情報存在(HihokenshaNo 被保険者番号) {
        return dbt4018Dac.get負担限度額認定情報の件数(被保険者番号) > 0;
    }

    /**
     * 社会福祉法人等利用者負担軽減の情報が存在するかを判断します。
     *
     * @param 被保険者番号 被保険者番号
     * @return 結果 true:社会福祉法人等利用者負担軽減の情報が存在
     */
    public boolean is社会福祉法人等利用者負担軽減の情報存在(HihokenshaNo 被保険者番号) {
        return dbt4017Dac.get社会福祉法人等利用者負担軽減情報の件数(被保険者番号) > 0;
    }

    /**
     * 訪問介護利用者負担額減額の情報が存在するかを判断します。
     *
     * @param 被保険者番号 被保険者番号
     * @return 結果 true:訪問介護利用者負担額減額の情報が存在
     */
    public boolean is訪問介護利用者負担額減額の情報存在(HihokenshaNo 被保険者番号) {
        return dbt4016Dac.get訪問介護利用者負担額減額情報の件数(被保険者番号) > 0;
    }

    /**
     * 特別地域加算減免の情報が存在するかを判断します。
     *
     * @param 被保険者番号 被保険者番号
     * @return 結果 true:特別地域加算減免の情報が存在
     */
    public boolean is特別地域加算減免の情報存在(HihokenshaNo 被保険者番号) {
        return dbt4020Dac.get特別地域加算減免情報の件数(被保険者番号) > 0;
    }

    /**
     * 利用者負担額減免の情報を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return List<利用者負担額減免の情報>
     */
    @Transaction
    public ArrayList<RiyoshaFutangakuGengaku> get利用者負担額減免の情報(HihokenshaNo 被保険者番号) {
        ArrayList<RiyoshaFutangakuGengaku> 利用者負担額減免の情報List = new ArrayList<>();

        IGemmenGengakuShoHakkoMainMapper mapper = mapperProvider.create(IGemmenGengakuShoHakkoMainMapper.class);
        List<RiyoshaFutangakuGengakuEntity> entityList = mapper.get利用者負担額減免の情報(被保険者番号);
        if (entityList != null && !entityList.isEmpty()) {
            for (RiyoshaFutangakuGengakuEntity entity : entityList) {
                利用者負担額減免の情報List.add(new RiyoshaFutangakuGengaku(entity));
            }
        }
        return 利用者負担額減免の情報List;
    }

    /**
     * 負担限度額認定の情報を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return List<負担限度額認定の情報>
     */
    @Transaction
    public ArrayList<FutanGendogakuNintei> get負担限度額認定の情報(HihokenshaNo 被保険者番号) {
        ArrayList<FutanGendogakuNintei> 負担限度額認定の情報List = new ArrayList<>();

        IGemmenGengakuShoHakkoMainMapper mapper = mapperProvider.create(IGemmenGengakuShoHakkoMainMapper.class);
        List<FutanGendogakuNinteiEntity> entityList = mapper.get負担限度額認定の情報(被保険者番号);
        if (entityList != null && !entityList.isEmpty()) {
            for (FutanGendogakuNinteiEntity entity : entityList) {
                負担限度額認定の情報List.add(new FutanGendogakuNintei(entity));
            }
        }
        return 負担限度額認定の情報List;
    }

    /**
     * 社会福祉法人等利用者負担軽減の情報を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return List<社会福祉法人等利用者負担軽減の情報>
     */
    @Transaction
    public ArrayList<ShakaifukuRiyoshaFutanKeigen> get社会福祉法人等利用者負担軽減の情報(HihokenshaNo 被保険者番号) {
        ArrayList<ShakaifukuRiyoshaFutanKeigen> 社会福祉法人等利用者負担軽減の情報List = new ArrayList<>();

        IGemmenGengakuShoHakkoMainMapper mapper = mapperProvider.create(IGemmenGengakuShoHakkoMainMapper.class);
        List<ShafukuRiyoshaFutanKeigenEntity> entityList = mapper.get社会福祉法人等利用者負担軽減の情報(被保険者番号);
        if (entityList != null && !entityList.isEmpty()) {
            for (ShafukuRiyoshaFutanKeigenEntity entity : entityList) {
                社会福祉法人等利用者負担軽減の情報List.add(new ShakaifukuRiyoshaFutanKeigen(entity));
            }
        }
        return 社会福祉法人等利用者負担軽減の情報List;
    }

    /**
     * 訪問介護利用者負担額減額の情報を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return List<訪問介護利用者負担額減額の情報>
     */
    @Transaction
    public ArrayList<HomonKaigoRiyoshaFutangakuGengaku> get訪問介護利用者負担額減額の情報(HihokenshaNo 被保険者番号) {
        ArrayList<HomonKaigoRiyoshaFutangakuGengaku> 訪問介護利用者負担額減額の情報List = new ArrayList<>();

        IGemmenGengakuShoHakkoMainMapper mapper = mapperProvider.create(IGemmenGengakuShoHakkoMainMapper.class);
        List<HomonKaigoRiyoshaFutangakuGengakuEntity> entityList = mapper.get訪問介護利用者負担額減額の情報(被保険者番号);
        if (entityList != null && !entityList.isEmpty()) {
            for (HomonKaigoRiyoshaFutangakuGengakuEntity entity : entityList) {
                訪問介護利用者負担額減額の情報List.add(new HomonKaigoRiyoshaFutangakuGengaku(entity));
            }
        }
        return 訪問介護利用者負担額減額の情報List;
    }

    /**
     * 特別地域加算減免の情報を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return List<特別地域加算減免の情報>
     */
    @Transaction
    public ArrayList<TokubetsuchiikiKasanGemmen> get特別地域加算減免の情報(HihokenshaNo 被保険者番号) {
        ArrayList<TokubetsuchiikiKasanGemmen> 訪問介護利用者負担額減額の情報List = new ArrayList<>();

        IGemmenGengakuShoHakkoMainMapper mapper = mapperProvider.create(IGemmenGengakuShoHakkoMainMapper.class);
        List<TokubetsuchiikiKasanGemmenEntity> entityList = mapper.get特別地域加算減免の情報(被保険者番号);
        if (entityList != null && !entityList.isEmpty()) {
            for (TokubetsuchiikiKasanGemmenEntity entity : entityList) {
                訪問介護利用者負担額減額の情報List.add(new TokubetsuchiikiKasanGemmen(entity));
            }
        }
        return 訪問介護利用者負担額減額の情報List;
    }

}
