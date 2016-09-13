/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.shikakutokuso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBZCodeShubetsu;
import jp.co.ndensan.reams.db.dbz.business.core.shikakutokuso.ShikakuTokuso;
import jp.co.ndensan.reams.db.dbz.business.core.shikakutokuso.ShutokuJiyuDDL;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.shikakutokuso.ShikakuTokusoParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.shikakutoku.shikakutokuso.ServiceShikakuRelateEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.shikakutokuso.IShikakuTokusoMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 資格得喪履歴クラスです。
 *
 * @reamsid_L DBA-0130-010 wanghui
 */
public class ShikakuTokusoFinder {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     *
     *
     */
    ShikakuTokusoFinder() {

        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     */
    ShikakuTokusoFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShikakuTokusoFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ShikakuTokusoFinder}のインスタンス
     */
    public static ShikakuTokusoFinder createInstance() {
        return InstanceProvider.create(ShikakuTokusoFinder.class);
    }

    /**
     * 資格得喪履歴の一覧データ取得リストを取得する。
     *
     * @param params ShikakuTokusoInputGuideParameter
     * @return 一覧データ取得取得リスト
     */
    public SearchResult<ShikakuTokuso> getShikakuTokuso(ShikakuTokusoParameter params) {
        IShikakuTokusoMapper shikakuTokusoMapper = this.mapperProvider.create(IShikakuTokusoMapper.class);
        List<ServiceShikakuRelateEntity> 一覧データ取得リスト = shikakuTokusoMapper.getShikakuJoho(params);
        List<ShikakuTokuso> serviceShuruiList = new ArrayList<>();
        List<ServiceShikakuRelateEntity> 取得日リスト = new ArrayList();
        FlexibleDate shikakuShutokuYMDFlag = FlexibleDate.EMPTY;

        if (一覧データ取得リスト == null || 一覧データ取得リスト.isEmpty()) {
            return SearchResult.of(Collections.<ShikakuTokuso>emptyList(), 0, false);
        }
        for (int i = 0; i < 一覧データ取得リスト.size(); i++) {
            if (!shikakuShutokuYMDFlag.equals(一覧データ取得リスト.get(i).getShikakuShutokuYMD())) {

                取得日リスト.add(一覧データ取得リスト.get(i));
                shikakuShutokuYMDFlag = 一覧データ取得リスト.get(i).getShikakuShutokuYMD();
            }
        }
        for (ServiceShikakuRelateEntity entity : 取得日リスト) {
            serviceShuruiList.add(new ShikakuTokuso(entity));
        }
        return SearchResult.of(serviceShuruiList, 0, false);
    }

    /**
     * 資格得喪履歴のコードマスタから取得事由ドロップダウンリストに表示する用のデータを取得する。
     *
     * @return 取得事由ドロップダウンリスト
     */
    @Transaction
    public SearchResult<ShutokuJiyuDDL> getShutokuJiyuDDL() {
        List<UzT0007CodeEntity> codeList = CodeMaster.getCode(SubGyomuCode.DBA介護資格, DBZCodeShubetsu.申請届出代行区分.getコード(), FlexibleDate.getNowDate());
        List<ShutokuJiyuDDL> serviceShuruiList = new ArrayList<>();
        if (codeList == null || codeList.isEmpty()) {
            return SearchResult.of(Collections.<ShutokuJiyuDDL>emptyList(), 0, false);
        }
        serviceShuruiList.add(new ShutokuJiyuDDL());
        for (UzT0007CodeEntity entity : codeList) {
            ShutokuJiyuDDL shikakuTokuSoa = new ShutokuJiyuDDL();
            shikakuTokuSoa.setCode(entity.getコード());
            shikakuTokuSoa.setCodeRyakusho(entity.getコード略称());
            serviceShuruiList.add(shikakuTokuSoa);
        }
        return SearchResult.of(serviceShuruiList, 0, false);
    }

    /**
     * 資格得喪履歴のコードマスタから喪失事由ドロップダウンリストに表示する用のデータを取得する。
     *
     * @return 喪失事由ドロップダウンリスト
     */
    @Transaction
    public SearchResult<ShutokuJiyuDDL> getSoshitsuJiyuDDL() {
        List<UzT0007CodeEntity> codeList = CodeMaster.getCode(SubGyomuCode.DBA介護資格, DBZCodeShubetsu.医師の配置基準.getコード(), FlexibleDate.getNowDate());
        List<ShutokuJiyuDDL> serviceShuruiList = new ArrayList<>();
        if (codeList.isEmpty()) {
            return SearchResult.of(Collections.<ShutokuJiyuDDL>emptyList(), 0, false);
        }
        serviceShuruiList.add(new ShutokuJiyuDDL());
        for (UzT0007CodeEntity entity : codeList) {
            ShutokuJiyuDDL list = new ShutokuJiyuDDL();
            list.setCode(entity.getコード());
            list.setCodeRyakusho(entity.getコード略称());
            serviceShuruiList.add(list);
        }
        return SearchResult.of(serviceShuruiList, 0, false);
    }
}
