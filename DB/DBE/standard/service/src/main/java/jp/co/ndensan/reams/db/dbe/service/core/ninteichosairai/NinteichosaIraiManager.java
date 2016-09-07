/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.ninteichosairai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.kanryouninteichosairai.NinteichosaIraiBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.kanryouninteichosairai.NinteichosaIraiChosainBusiness;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosairai.NinteichosaIraiParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosairai.ChosaKekkaNyuryokuMobileChosainRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosairai.ChosaKekkaNyuryokuMobileRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteichosairai.INinteichosaIraiMapper;
import jp.co.ndensan.reams.db.dbe.persistence.db.util.MapperProvider;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosaIraiJoho;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.MobileDataShutsuryokuFlag;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinteiChousaIraiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShoriJotaiKubun;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5201NinteichosaIraiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5913ChosainJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5201NinteichosaIraiJohoDac;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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

    /**
     * コンストラクタです。
     */
    NinteichosaIraiManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.dbT5201Dac = InstanceProvider.create(DbT5201NinteichosaIraiJohoDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param dbT5201Dac dbT5201Dac
     */
    NinteichosaIraiManager(MapperProvider mapperProvider, DbT5201NinteichosaIraiJohoDac dbT5201Dac) {
        this.mapperProvider = mapperProvider;
        this.dbT5201Dac = dbT5201Dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link NinteichosaIraiManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link NinteichosaIraiManager}のインスタンス
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
     * 調査機関自動割付処理を実行します。
     *
     * @param 保険者番号 保険者番号
     * @param 地区コード 地区コード
     * @param 申請書管理番号 申請書管理番号
     * @param 要割付人数 要割付人数
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 割付済人数
     */
    @Transaction
    public int 調査機関自動割付処理(RString 保険者番号, RString 地区コード,
            RString 申請書管理番号, int 要割付人数, RString 厚労省IF識別コード) {
        int tmp要割付人数 = 要割付人数;
        INinteichosaIraiMapper mapper = mapperProvider.create(INinteichosaIraiMapper.class);
        List<DbT5913ChosainJohoEntity> 調査員情報リスト = mapper.select委託先調査員情報(
                new NinteichosaIraiParameter(
                        保険者番号, 地区コード, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY));
        int max履歴番号 = getMax認定調査依頼履歴番号(申請書管理番号);
        for (DbT5913ChosainJohoEntity entity : 調査員情報リスト) {
            if (tmp要割付人数 == 0) {
                return tmp要割付人数;
            } else {
                for (int i = 0; i < entity.getChosaKanoNinzuPerMonth(); i++) {
                    if (tmp要割付人数 == 0) {
                        return tmp要割付人数;
                    } else {
                        max履歴番号++;
                        dbT5201Dac.save(set認定調査依頼情報(申請書管理番号, max履歴番号, 厚労省IF識別コード,
                                entity.getNinteiChosaItakusakiCode(), entity.getNinteiChosainCode()).toEntity());
                        tmp要割付人数 = tmp要割付人数 - 1;
                    }
                }
            }
        }
        return tmp要割付人数;
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
        return mapper.selectMax認定調査依頼履歴番号(new NinteichosaIraiParameter(
                RString.EMPTY, RString.EMPTY, 申請書管理番号, RString.EMPTY, RString.EMPTY, RString.EMPTY));
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
        entity.setMobileDataShutsuryokuZumiFlag(MobileDataShutsuryokuFlag.出力済.isモバイルデータ出力());
        entity.setState(EntityDataState.Modified);
        dbT5201Dac.save(entity);
    }

    private NinteichosaIraiJoho set認定調査依頼情報(RString 申請書管理番号, int 認定調査依頼履歴番号,
            RString 厚労省IF識別コード, RString 認定調査委託先コード, RString 認定調査員コード) {
        NinteichosaIraiJoho ninteichosaIraiJoho = new NinteichosaIraiJoho(new ShinseishoKanriNo(申請書管理番号), 認定調査依頼履歴番号);
        FlexibleDate システム日付 = FlexibleDate.getNowDate();
        return ninteichosaIraiJoho.createBuilderForEdit()
                .set厚労省IF識別コード(RString.isNullOrEmpty(厚労省IF識別コード) ? Code.EMPTY : new Code(厚労省IF識別コード))
                .set認定調査委託先コード(RString.isNullOrEmpty(認定調査委託先コード) ? JigyoshaNo.EMPTY : new JigyoshaNo(認定調査委託先コード))
                .set認定調査員コード(認定調査員コード)
                .set認定調査依頼区分コード(認定調査依頼履歴番号 == 1 ? new Code(NinteiChousaIraiKubunCode.初回.getコード())
                        : new Code(NinteiChousaIraiKubunCode.再依頼.getコード()))
                .set認定調査回数(認定調査依頼履歴番号 == 1 ? 0 : 1)
                .set認定調査依頼年月日(システム日付)
                .set認定調査期限年月日(システム日付.plusDay(Integer.parseInt(DbBusinessConfig.get(
                                                ConfigNameDBE.認定調査期限日数, RDate.getNowDate(), SubGyomuCode.DBE認定支援).toString())))
                .set論理削除フラグ(false)
                .build();
    }

}
