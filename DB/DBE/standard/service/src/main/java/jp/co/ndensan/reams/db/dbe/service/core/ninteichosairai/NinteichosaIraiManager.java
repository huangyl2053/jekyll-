/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.ninteichosairai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.NinteichosaItakusakiJohoRelate;
import jp.co.ndensan.reams.db.dbe.business.core.kanryouninteichosairai.NinteichosaIraiBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.kanryouninteichosairai.NinteichosaIraiChosainBusiness;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosairai.NinteichosaIraiParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosairai.ChosaKekkaNyuryokuMobileChosainRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosairai.ChosaKekkaNyuryokuMobileRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.tyousai.ninteichosaitakusakijoho.NinteichosaItakusakiJohoRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteichosairai.INinteichosaIraiMapper;
import jp.co.ndensan.reams.db.dbe.persistence.db.util.MapperProvider;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.MobileDataShutsuryokuFlag;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShoriJotaiKubun;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5201NinteichosaIraiJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5101NinteiShinseiJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5201NinteichosaIraiJohoDac;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 完了処理・認定調査依頼を管理するクラスです。
 *
 * @reamsid_L DBE-0300-010 dingyi
 */
public class NinteichosaIraiManager {

    private final MapperProvider mapperProvider;
    private final DbT5201NinteichosaIraiJohoDac dbT5201Dac;
    private final DbT5101NinteiShinseiJohoDac dbT5101Dac;

    /**
     * コンストラクタです。
     */
    NinteichosaIraiManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.dbT5201Dac = InstanceProvider.create(DbT5201NinteichosaIraiJohoDac.class);
        this.dbT5101Dac = InstanceProvider.create(DbT5101NinteiShinseiJohoDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param dbT5201Dac dbT5201Dac
     */
    NinteichosaIraiManager(MapperProvider mapperProvider, DbT5201NinteichosaIraiJohoDac dbT5201Dac, DbT5101NinteiShinseiJohoDac db5101Dac) {
        this.mapperProvider = mapperProvider;
        this.dbT5201Dac = dbT5201Dac;
        this.dbT5101Dac = db5101Dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link NinteichosaIraiManager}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link NinteichosaIraiManager}のインスタンス
     */
    public static NinteichosaIraiManager createInstance() {
        return InstanceProvider.create(NinteichosaIraiManager.class);
    }

    /**
     * 画面選択した保険者番号より、認定調査委託先情報を検索します。
     *
     * @param 保険者番号 保険者番号
     * @return 認定調査委託先情報検索結果件数
     */
    @Transaction
    public int select認定調査委託先情報(RString 保険者番号) {
        INinteichosaIraiMapper mapper = mapperProvider.create(INinteichosaIraiMapper.class);
        return mapper.select認定調査委託先情報(new NinteichosaIraiParameter(
                保険者番号, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY));
    }

    /**
     * 画面選択した保険者番号より、調査可能人数を取得します。
     *
     * @param 保険者番号 保険者番号
     * @param 地区コード 地区コード
     * @return 調査可能人数
     */
    @Transaction
    public int select調査可能人数(RString 保険者番号, RString 地区コード) {
        INinteichosaIraiMapper mapper = mapperProvider.create(INinteichosaIraiMapper.class);
        return mapper.select調査可能人数(new NinteichosaIraiParameter(
                保険者番号, 地区コード, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY));
    }

    /**
     * 画面選択した保険者番号より、割付済人数を取得します。
     *
     * @param 保険者番号 保険者番号
     * @param 地区コード 地区コード
     * @return 割付済人数
     */
    @Transaction
    public int select割付済人数(RString 保険者番号, RString 地区コード) {
        INinteichosaIraiMapper mapper = mapperProvider.create(INinteichosaIraiMapper.class);
        return mapper.select割付済人数(new NinteichosaIraiParameter(
                保険者番号, 地区コード, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY));
    }

    /**
     * 認定調査委託先と調査員の情報のリストを返します。
     *
     * @param 保険者番号 保険者番号
     * @param 地区コード 地区コード
     * @return 認定調査委託先と調査員の情報のリスト
     */
    @Transaction
    public List<NinteichosaItakusakiJohoRelate> get認定調査委託先And調査員情報リスト(RString 保険者番号, RString 地区コード) {
        INinteichosaIraiMapper mapper = mapperProvider.create(INinteichosaIraiMapper.class);
        List<NinteichosaItakusakiJohoRelateEntity> entityList = mapper.select認定調査委託先And調査員情報(
                new NinteichosaIraiParameter(保険者番号, 地区コード, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY));
        List<NinteichosaItakusakiJohoRelate> 認定調査委託先And調査員情報リスト = new ArrayList<>();
        for (NinteichosaItakusakiJohoRelateEntity entity : entityList) {
            認定調査委託先And調査員情報リスト.add(new NinteichosaItakusakiJohoRelate(entity));
        }
        return 認定調査委託先And調査員情報リスト;
    }

    /**
     * 最大認定調査依頼履歴番号を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return Max認定調査依頼履歴番号
     */
    @Transaction
    public int getMax認定調査依頼履歴番号(RString 申請書管理番号) {
        INinteichosaIraiMapper mapper = mapperProvider.create(INinteichosaIraiMapper.class);
        RString result = mapper.selectMax認定調査依頼履歴番号(new NinteichosaIraiParameter(
                RString.EMPTY, RString.EMPTY, 申請書管理番号, RString.EMPTY, RString.EMPTY, RString.EMPTY));
        return result == null ? 0 : Integer.parseInt(result.toString());
    }

    /**
     * 選択された行の申請書管理番号条件として、調査結果入力用データを取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 調査結果入力用データ
     */
    @Transaction
    public SearchResult<NinteichosaIraiBusiness> select調査結果入力用データ(RString 申請書管理番号) {
        INinteichosaIraiMapper mapper = mapperProvider.create(INinteichosaIraiMapper.class);
        RString 概況調査テキストイメージ区分 = DbBusinessConfig.get(
                ConfigNameDBE.概況調査テキストイメージ区分, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        List<ChosaKekkaNyuryokuMobileRelateEntity> relateEntityList = mapper.select調査結果入力用データ(new NinteichosaIraiParameter(
                RString.EMPTY, RString.EMPTY, 申請書管理番号,
                概況調査テキストイメージ区分, ShoriJotaiKubun.通常.getコード(), ShoriJotaiKubun.延期.getコード()));
        if (relateEntityList.isEmpty()) {
            return SearchResult.of(Collections.<NinteichosaIraiBusiness>emptyList(), 0, false);
        }
        List<NinteichosaIraiBusiness> 調査結果入力用データList = new ArrayList<>();
        for (ChosaKekkaNyuryokuMobileRelateEntity relateEntity : relateEntityList) {
            調査結果入力用データList.add(new NinteichosaIraiBusiness(relateEntity));
        }
        return SearchResult.of(調査結果入力用データList, 0, false);
    }

    /**
     * 選択された行の申請書管理番号条件として、調査結果入力用調査員データを取得します。
     *
     * @return 調査結果入力用調査員データ
     */
    @Transaction
    public SearchResult<NinteichosaIraiChosainBusiness> select調査結果入力用調査員データ() {
        INinteichosaIraiMapper mapper = mapperProvider.create(INinteichosaIraiMapper.class);
        List<ChosaKekkaNyuryokuMobileChosainRelateEntity> relateEntityList = mapper.select調査結果入力用調査員データ();
        if (relateEntityList.isEmpty()) {
            return SearchResult.of(Collections.<NinteichosaIraiChosainBusiness>emptyList(), 0, false);
        }
        List<NinteichosaIraiChosainBusiness> 調査結果入力用調査員データList = new ArrayList<>();
        for (ChosaKekkaNyuryokuMobileChosainRelateEntity relateEntity : relateEntityList) {
            調査結果入力用調査員データList.add(new NinteichosaIraiChosainBusiness(relateEntity));
        }
        return SearchResult.of(調査結果入力用調査員データList, 0, false);
    }

    /**
     * 認定調査依頼情報のモバイルデータ出力済フラグをシステム日付で更新します。
     *
     * @param 申請書管理番号 申請書管理番号
     */
    @Transaction
    public void update認定調査依頼情報(RString 申請書管理番号) {
        INinteichosaIraiMapper mapper = mapperProvider.create(INinteichosaIraiMapper.class);
        DbT5201NinteichosaIraiJohoEntity entity = mapper.select最新認定調査依頼情報(new NinteichosaIraiParameter(
                RString.EMPTY, RString.EMPTY, 申請書管理番号, RString.EMPTY, RString.EMPTY, RString.EMPTY));
        if (entity != null) {
            entity.setMobileDataShutsuryokuZumiFlag(MobileDataShutsuryokuFlag.出力済.isモバイルデータ出力());
            entity.setState(EntityDataState.Modified);
            dbT5201Dac.save(entity);
        }
    }
}
