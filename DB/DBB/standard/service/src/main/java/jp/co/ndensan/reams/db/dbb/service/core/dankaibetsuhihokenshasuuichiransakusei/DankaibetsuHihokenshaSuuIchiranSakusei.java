/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.dankaibetsuhihokenshasuuichiransakusei;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.dankaibetuhihokensyasuichiranhyo.DankaibetuHihokensyasuIchiranhyoBatchParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.dankaibetuhihokensyasuichiranhyo.InputeImageDivEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * ビジネス設計_DBBBZ21004_段階別被保険者数一覧表作成
 *
 * @reamsid_L DBB-1820-030 surun
 */
public class DankaibetsuHihokenshaSuuIchiranSakusei {

    private final DbT7022ShoriDateKanriDac 処理日付管理Dac;

    /**
     * コンストラクタです。
     */
    DankaibetsuHihokenshaSuuIchiranSakusei() {
        this.処理日付管理Dac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
    }

    /**
     * コンストラクタです。
     *
     * @param 処理日付管理Dac DbT7022ShoriDateKanriDac
     */
    DankaibetsuHihokenshaSuuIchiranSakusei(DbT7022ShoriDateKanriDac 処理日付管理Dac) {
        this.処理日付管理Dac = 処理日付管理Dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link DankaibetsuHihokenshaSuuIchiranSakusei}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link DankaibetsuHihokenshaSuuIchiranSakusei}のインスタンス
     */
    public static DankaibetsuHihokenshaSuuIchiranSakusei createInstance() {
        return InstanceProvider.create(DankaibetsuHihokenshaSuuIchiranSakusei.class);
    }

    /**
     * 本算定賦課処理日取得
     *
     * @param 調定年度 FlexibleYear
     * @return YMDHMS
     */
    @Transaction
    public YMDHMS getHonsanteiShoribi(FlexibleYear 調定年度) {
        List<DbT7022ShoriDateKanriEntity> entityList
                = 処理日付管理Dac.select処理状況(調定年度, ShoriName.本算定賦課.get名称(), new RString("0001"));
        if (entityList.isEmpty()) {
            return null;
        }
        return entityList.get(0).getKijunTimestamp();
    }

    /**
     * バッチパラメータ作成
     *
     * @param inputeImageDivEntity InputeImageDivEntity
     * @return BatchParameterEntity
     */
    public DankaibetuHihokensyasuIchiranhyoBatchParameter createDankaibechuHihokenshaCountParameter(InputeImageDivEntity inputeImageDivEntity) {
        DankaibetuHihokensyasuIchiranhyoBatchParameter batchParameterEntity = new DankaibetuHihokensyasuIchiranhyoBatchParameter();
        batchParameterEntity.set調定年度(inputeImageDivEntity.get調定年度());
        batchParameterEntity.set本算定賦課処理日(inputeImageDivEntity.get本算定賦課処理日());
        batchParameterEntity.set広域分市町村分区分(inputeImageDivEntity.get広域分市町村分区分());
        batchParameterEntity.set市町村コード複数(inputeImageDivEntity.get市町村コードHIDDEN());
        batchParameterEntity.set資格基準日(inputeImageDivEntity.get資格基準日());
        batchParameterEntity.set調定基準日(inputeImageDivEntity.get調定基準日());
        return batchParameterEntity;
    }
}
