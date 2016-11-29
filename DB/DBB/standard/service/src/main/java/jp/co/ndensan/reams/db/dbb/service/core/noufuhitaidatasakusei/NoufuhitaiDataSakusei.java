/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.noufuhitaidatasakusei;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.noufugakudatasakuseishoridate.NoufuGakuDataSakuseiShoriDateParameter;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.noufugakudatasakuseishoridate.INoufuGakuDataSakuseiShoriDateMapper;
import jp.co.ndensan.reams.db.dbb.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbx.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 画面設計_DBBGM91003_納付額データ作成のクラスです。
 *
 * @reamsid_L DBB-1890-010 chenhui
 */
public class NoufuhitaiDataSakusei {

    private final DbT7022ShoriDateKanriDac dbt7022Dac;
    private final MapperProvider mapperProvider;
    private static final RString 処理名 = new RString("納付額データ作成");

    /**
     * コンストラクタです。
     */
    NoufuhitaiDataSakusei() {
        this.dbt7022Dac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * にて生成した{@link NoufuhitaiDataSakusei}のインスタンスを返します。
     *
     * @return NoufuhitaiDataSakusei
     */
    public static NoufuhitaiDataSakusei createInstance() {
        return InstanceProvider.create(NoufuhitaiDataSakusei.class);
    }

    /**
     * 抽出条件前回処理日付のデータの取得のメソッドです。
     *
     * @param 市町村コード LasdecCode
     * @param 処理枝番 RString
     *
     * @return ShoriDateKanri
     *
     */
    public ShoriDateKanri get抽出条件前回処理日付(LasdecCode 市町村コード, RString 処理枝番) {
        DbT7022ShoriDateKanriEntity entity = dbt7022Dac.select抽出条件前回処理日付(SubGyomuCode.DBB介護賦課, 市町村コード, 処理名, 処理枝番);
        if (entity != null) {
            return new ShoriDateKanri(entity);
        }
        return null;
    }

    /**
     * 処理対象前回処理日付のデータの取得のメソッドです。
     *
     * @param 市町村コードList List<LasdecCode>
     * @param 処理枝番List List<RString>
     *
     * @return ShoriDateKanri
     *
     */
    public List<ShoriDateKanri> get処理対象前回処理日付(List<LasdecCode> 市町村コードList,
            List<RString> 処理枝番List) {
        if (市町村コードList == null || 市町村コードList.isEmpty()) {
            return new ArrayList<>();
        }
        if (処理枝番List == null || 処理枝番List.isEmpty()) {
            return new ArrayList<>();
        }
        INoufuGakuDataSakuseiShoriDateMapper mapper = mapperProvider.create(INoufuGakuDataSakuseiShoriDateMapper.class);
        NoufuGakuDataSakuseiShoriDateParameter param = new NoufuGakuDataSakuseiShoriDateParameter();
        param.set処理枝番List(処理枝番List);
        param.set市町村コードList(市町村コードList);
        List<DbT7022ShoriDateKanriEntity> 前回処理日付List = mapper.get前回の処理日付取得(param);
        if (前回処理日付List == null || 前回処理日付List.isEmpty()) {
            return new ArrayList<>();
        }
        List<ShoriDateKanri> 処理対象前回処理日付List = new ArrayList<>();
        for (DbT7022ShoriDateKanriEntity entity : 前回処理日付List) {
            処理対象前回処理日付List.add(new ShoriDateKanri(entity));
        }
        return 処理対象前回処理日付List;
    }
}
