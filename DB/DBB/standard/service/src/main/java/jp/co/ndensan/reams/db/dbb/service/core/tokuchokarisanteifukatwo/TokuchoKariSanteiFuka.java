/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.tokuchokarisanteifukatwo;

import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchokarisanteifukatwo.BatchParameterEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchokarisanteifukatwo.InputeImageDivEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * ビジネス設計_DBBBZ21004_段階別被保険者数一覧表作成
 *
 * @reamsid_L DBB-1820-030 surun
 */
public class TokuchoKariSanteiFuka {

    private final DbT7022ShoriDateKanriDac 処理日付管理Dac;

    /**
     * コンストラクタです。
     */
    TokuchoKariSanteiFuka() {
        this.処理日付管理Dac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
    }

    /**
     * コンストラクタです。
     *
     * @param 処理日付管理Dac DbT7022ShoriDateKanriDac
     */
    TokuchoKariSanteiFuka(DbT7022ShoriDateKanriDac 処理日付管理Dac) {
        this.処理日付管理Dac = 処理日付管理Dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link TokuchoKariSanteiFuka}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link TokuchoKariSanteiFuka}のインスタンス
     */
    public static TokuchoKariSanteiFuka createInstance() {
        return InstanceProvider.create(TokuchoKariSanteiFuka.class);
    }

    /**
     * 本算定賦課処理日取得
     *
     * @param 調定年度 FlexibleYear
     * @return YMDHMS
     */
    public YMDHMS getHonsanteiShoribi(FlexibleYear 調定年度) {
        DbT7022ShoriDateKanriEntity entity = 処理日付管理Dac.select基準日時(調定年度);
        if (entity.getKijunTimestamp() != null) {
            return entity.getKijunTimestamp();
        }
        return null;
    }

    /**
     * バッチパラメータ作成
     *
     * @param inputeImageDivEntity InputeImageDivEntity
     * @return BatchParameterEntity
     */
    public BatchParameterEntity createDankaibechuHihokenshaCountParameter(InputeImageDivEntity inputeImageDivEntity) {
        BatchParameterEntity batchParameterEntity = new BatchParameterEntity();
        batchParameterEntity.set調定年度(inputeImageDivEntity.get調定年度());
        batchParameterEntity.set本算定賦課処理日(inputeImageDivEntity.get本算定賦課処理日());
        batchParameterEntity.set広域分市町村分区分(inputeImageDivEntity.get広域分市町村分区分());
        batchParameterEntity.set市町村コード複数(inputeImageDivEntity.get市町村コードHIDDEN());
        batchParameterEntity.set資格基準日(inputeImageDivEntity.get資格基準日());
        batchParameterEntity.set調定基準日(inputeImageDivEntity.get調定基準日());
        return batchParameterEntity;
    }
}
