/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.sakuseiryoSeikyuKubun;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.SakuseiryoSeikyuKubun;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.sakuseiryoSeikyuKubun.SakuseiryoSeikyuKubunParameter;
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.sakuseiryoseikyuKubun.ISakuseiryoSeikyuKubunMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 作成料請求区分取得
 *
 */
public class SakuseiryoSeikyuKubunFinder {

    private final MapperProvider mapperProvider;
    private final int 該当データなし = 0;

    /**
     * コンストラクタです。
     */
    SakuseiryoSeikyuKubunFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link SakuseiryoSeikyuKubunFinder}のインスタンスを返します。
     *
     * @return SeikatsuhogoRirekiFinder
     */
    public static SakuseiryoSeikyuKubunFinder createInstance() {
        return InstanceProvider.create(SakuseiryoSeikyuKubunFinder.class);
    }

    /**
     * 入力された検索条件によって、作成料請求区分コードを取得します。
     *
     * @param 申請書管理番号 ShinseishoKanriNo
     * @param 主治医医療機関コード RString
     * @param 主治医コード RString
     * @return 作成料請求区分 RString
     */
    @Transaction
    public RString search作成料請求区分(ShinseishoKanriNo 申請書管理番号, RString 主治医医療機関コード, RString 主治医コード) {
        RString 作成料請求区分コード;
        ISakuseiryoSeikyuKubunMapper mapper = mapperProvider.create(ISakuseiryoSeikyuKubunMapper.class);
        SakuseiryoSeikyuKubunParameter parameter = SakuseiryoSeikyuKubunParameter.createParameter(申請書管理番号, 主治医医療機関コード, 主治医コード);
        int 意見書データ = mapper.get意見書データ(parameter);
        int 施設入所有 = mapper.get施設入所有(parameter);

        if (意見書データ == 該当データなし) {
            if (施設入所有 == 該当データなし) {
                作成料請求区分コード = SakuseiryoSeikyuKubun.在宅新規.getコード();
            } else {
                作成料請求区分コード = SakuseiryoSeikyuKubun.施設新規.getコード();
            }
        } else {
            if (施設入所有 == 該当データなし) {
                作成料請求区分コード = SakuseiryoSeikyuKubun.在宅継続.getコード();
            } else {
                作成料請求区分コード = SakuseiryoSeikyuKubun.施設継続.getコード();
            }
        }
        return 作成料請求区分コード;
    }
}
