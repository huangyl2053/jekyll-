/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.shikakutokuso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.shikakutokuso.ShikakuTokuSoa;
import jp.co.ndensan.reams.db.dba.business.core.shikakutokuso.ShikakuTokuso;
import jp.co.ndensan.reams.db.dba.definition.shikakutokuso.ShikakuTokusoParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.shikakutoku.shikakutokuso.ServiceShikakuRelateEntity;
import jp.co.ndensan.reams.db.dba.persistence.db.basic.shikakutokuso.IShikakuTokusoMapper;

import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1001HihokenshaDaichoDac;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 *
 * 資格一覧データ取得クラスです。
 */
public class ShikakuTokusoFinder {

    private final MapperProvider mapperProvider;
    private final DbT1001HihokenshaDaichoDac dbT1001Dac;
    private final CodeShubetsu CHIKU_CODE_SHUBETSU = new CodeShubetsu("0117");
    private final CodeShubetsu CHIKU_CODE_SHUBETSu = new CodeShubetsu("0117");

    /**
     * コンストラクタです。
     */
    public ShikakuTokusoFinder() {

        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.dbT1001Dac = InstanceProvider.create(DbT1001HihokenshaDaichoDac.class);
    }

    /**
     * 資格一覧データ取得クラスです。
     *
     * @return ShikakuTokusoFinde
     */
    public static ShikakuTokusoFinder createInstance() {
        return InstanceProvider.create(ShikakuTokusoFinder.class);
    }

    /**
     * 一覧データ取得リストを取得する。
     *
     * @param params ShikakuTokusoInputGuideParameter
     * @return List<ServiceJigyoshaInputGuideRelateEntity> 一覧データ取得取得リスト
     */
    public SearchResult<ShikakuTokuso> getShikakuTokuso(ShikakuTokusoParameter params) {
        if (params.getHihokenshaNo().isEmpty() && params.getShikibetsuCode().isEmpty()) {
            throw new ApplicationException(UrErrorMessages.検索キーの誤り.getMessage().toString());
        }
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
     * コードマスタから取得事由ドロップダウンリストに表示する用のデータを取得する。
     *
     * @param 住所地特例適用事由コード 住所地特例適用事由コード
     * @return List<ShikakuTokuso>コード種別　=　'0117'取得取得リスト
     *///TODD:QA未回
    public SearchResult<ShikakuTokuSoa> getShutokuJiyuDDL() {
        List<UzT0007CodeEntity> codeList = CodeMaster.getCodeRireki(SubGyomuCode.DBA介護資格, CHIKU_CODE_SHUBETSU);
        List<ShikakuTokuSoa> serviceShuruiList = new ArrayList<>();
        if (codeList == null || codeList.isEmpty()) {
            return SearchResult.of(Collections.<ShikakuTokuso>emptyList(), 0, false);
        }
        for (UzT0007CodeEntity entity : codeList) {
            ShikakuTokuSoa List = new ShikakuTokuSoa();
            List.setCode(entity.getコード());
            List.setCodeRyakusho(entity.getコード略称());
            serviceShuruiList.add(List);
        }
        return SearchResult.of(serviceShuruiList, 0, false);
    }

    /**
     * コードマスタから喪失事由ドロップダウンリストに表示する用のデータを取得する。
     *
     * @param 住所地特例解除事由コード 住所地特例解除事由コード
     * @return List<ShikakuTokuso>コード種別　=　'0121'取得取得リスト
     */
    //TODD:QA未回
    public SearchResult<ShikakuTokuSoa> getSoshitsuJiyuDDL() {
        List<UzT0007CodeEntity> codeList = CodeMaster.getCodeRireki(SubGyomuCode.DBA介護資格, CHIKU_CODE_SHUBETSu);
        List<ShikakuTokuSoa> serviceShuruiList = new ArrayList<>();
        if (codeList.isEmpty()) {
            return SearchResult.of(Collections.<ShikakuTokuso>emptyList(), 0, false);
        }
        for (UzT0007CodeEntity entity : codeList) {
            ShikakuTokuSoa List = new ShikakuTokuSoa();
            List.setCode(entity.getコード());
            List.setCodeRyakusho(entity.getコード略称());
            serviceShuruiList.add(List);
        }
        return SearchResult.of(serviceShuruiList, 0, false);
    }
}
