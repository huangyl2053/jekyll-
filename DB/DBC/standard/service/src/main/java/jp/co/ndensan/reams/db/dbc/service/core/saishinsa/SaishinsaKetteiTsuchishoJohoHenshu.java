/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.saishinsa;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.KohiFutanShaMeiSai;
import jp.co.ndensan.reams.db.dbc.business.core.KohiFutanShaShuKei;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.saishinsakohifutansha.ISaishinsaKohishaMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 再審査決定通知書情報取込（公費負担者分）データ編集
 *
 * @reamsid_L DBC-2820-020 sunhui
 */
public class SaishinsaKetteiTsuchishoJohoHenshu {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public SaishinsaKetteiTsuchishoJohoHenshu() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     */
    SaishinsaKetteiTsuchishoJohoHenshu(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link SaishinsaKetteiTsuchishoJohoHenshu}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link SaishinsaKetteiTsuchishoJohoHenshu}のインスタンス
     */
    public static SaishinsaKetteiTsuchishoJohoHenshu createInstance() {
        return InstanceProvider.create(SaishinsaKetteiTsuchishoJohoHenshu.class);
    }

    /**
     * 被保険者データ変更
     */
    public void updateHihokenshaJoho() {

        ISaishinsaKohishaMapper mapper = mapperProvider.create(ISaishinsaKohishaMapper.class);
        mapper.select被保険者番号From一時テーブル();
    }

    /**
     * DB編集処理
     *
     * @param 処理年月 処理年月
     * @param csvFileNameList Csvファイル名
     */
    @Transaction
    public void createSaishinsaKetteiTsuchishoJoho(FlexibleYearMonth 処理年月, List<RString> csvFileNameList) {

    }

    /**
     * 公費負担者分再審査決定通知書明細情報取得
     *
     * @return 公費負担者分再審査決定通知書明細情報Entityリスト
     */
    public List<KohiFutanShaMeiSai> getSaishinsaKetteiTsuchishoMeisaiJohoData() {

        return null;
    }

    /**
     * 公費負担者分再審査決定通知書集計情報取得
     *
     * @return 公費負担者分再審査決定通知書集計情報
     */
    public KohiFutanShaShuKei getSaishinsaKetteiTsuchishoShukeiJohoData() {

        return null;
    }
}
