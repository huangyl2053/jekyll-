/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.imagejohomasking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.imagejohomasking.ImageJohoMaskingResult;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.imagejohomasking.ImageJohoMaskingParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.imagejohomasking.ImageJohoMaskingRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.imagejohomasking.IImageJohoMaskingMapper;
import jp.co.ndensan.reams.db.dbe.persistence.db.util.MapperProvider;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.IkenshoImageJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoTokkijiko;
import jp.co.ndensan.reams.db.dbz.service.core.basic.IkenshoImageJohoManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.NinteichosahyoTokkijikoManager;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * イメージ情報マスキングのサービスクラスです。
 *
 * @reamsid_L DBE-1620-010 chengsanyuan
 */
public class ImageJohoMaskingFinder {

    private final MapperProvider mapperProvider;
    private final IkenshoImageJohoManager dbt5305;
    private final NinteichosahyoTokkijikoManager dbt5205;

    /**
     * コンストラクタです。
     */
    ImageJohoMaskingFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.dbt5305 = IkenshoImageJohoManager.createInstance();
        this.dbt5205 = NinteichosahyoTokkijikoManager.createInstance();
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param MapperProvider {@link mapperProvider}
     * @param IkenshoImageJohoManager {@link dbt5305}
     * @param NinteichosahyoTokkijikoManager {@link dbt5205}
     */
    ImageJohoMaskingFinder(MapperProvider mapperProvider, IkenshoImageJohoManager dbt5305, NinteichosahyoTokkijikoManager dbt5205) {
        this.mapperProvider = mapperProvider;
        this.dbt5305 = dbt5305;
        this.dbt5205 = dbt5205;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ImageJohoMaskingFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ImageJohoMaskingFinder}のインスタンス
     */
    public static ImageJohoMaskingFinder createInstance() {
        return InstanceProvider.create(ImageJohoMaskingFinder.class);
    }

    /**
     * イメージ情報マスキング画面初期検索
     *
     * @param param イメージ情報マスキングのパラメータ
     * @return イメージ情報マスキング画面データ
     */
    public SearchResult<ImageJohoMaskingResult> getDataForLoad(ImageJohoMaskingParameter param) {
        List<ImageJohoMaskingResult> resultList = new ArrayList<>();
        List<ImageJohoMaskingRelateEntity> entityList
                = mapperProvider.create(IImageJohoMaskingMapper.class).getDataForLoad(param);
        if (entityList.isEmpty()) {
            return SearchResult.of(Collections.<ImageJohoMaskingResult>emptyList(), 0, false);
        }
        for (ImageJohoMaskingRelateEntity entity : entityList) {
            resultList.add(new ImageJohoMaskingResult(entity));
        }
        return SearchResult.of(resultList, 0, false);
    }

    /**
     * マスクデータ有無の判定
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 主治医意見書作成依頼履歴番号 主治医意見書作成依頼履歴番号
     * @param 帳票ID 帳票ID
     * @param マスキングデータ区分 マスキングデータ区分
     * @param 取込みページ番号 取込みページ番号
     * @return true:ある　false:なし
     */
    public boolean has意見書イメージ情報(ShinseishoKanriNo 申請書管理番号,
            int 主治医意見書作成依頼履歴番号, Code 帳票ID,
            RString マスキングデータ区分, int 取込みページ番号) {
        IkenshoImageJoho business = dbt5305.get要介護認定意見書イメージ情報(申請書管理番号, 主治医意見書作成依頼履歴番号, 帳票ID,
                マスキングデータ区分, 取込みページ番号);
        return business != null;
    }

    /**
     * マスクデータ有無の判定
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査依頼履歴番号 認定調査依頼履歴番号
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @param 認定調査特記事項連番 認定調査特記事項連番
     * @param 特記事項テキスト_イメージ区分 特記事項テキスト_イメージ区分
     * @param 原本マスク区分 原本マスク区分
     * @return true:ある　false:なし
     */
    public boolean has特記情報(
            ShinseishoKanriNo 申請書管理番号,
            int 認定調査依頼履歴番号,
            RString 認定調査特記事項番号,
            Integer 認定調査特記事項連番,
            RString 特記事項テキスト_イメージ区分,
            Code 原本マスク区分) {
        NinteichosahyoTokkijiko business = dbt5205.get認定調査票_特記情報(
                申請書管理番号, 認定調査依頼履歴番号, 認定調査特記事項番号, 認定調査特記事項連番, 特記事項テキスト_イメージ区分, 原本マスク区分);
        return business != null;
    }
}
