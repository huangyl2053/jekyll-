/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.shujiiikenshotoroku;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shujiiikenshotoroku.ShujiiIkenshoTorokuResult;
import jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteiimagekanri.ImagekanriJoho;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeErrorMessages;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shujiiikenshotoroku.ShujiiIkenshoTorokuMapperParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.yokaigoninteiimagesakujo.YokaigoninteiimagesakujoMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiiikenshotoroku.ShujiiIkenshoTorokuRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shujiiikenshotoroku.IShujiiIkenshoTorokuMapper;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.yokaigoninteiimagesakujo.IYokaigoninteiimagesakujoMapper;
import jp.co.ndensan.reams.db.dbe.persistence.db.util.MapperProvider;
import jp.co.ndensan.reams.db.dbe.service.core.basic.NinteiKanryoJohoManager;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurity.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurity.ShichosonSecurityJohoFinder;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJoho;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.GenponMaskKubun;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 主治医意見書登録のサービスクラスです。
 *
 * @reamsid_L DBE-0070-010 chengsanyuan
 */
public class ShujiiIkenshoTorokuManager {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    ShujiiIkenshoTorokuManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param MapperProvider {@link mapperProvider}
     */
    ShujiiIkenshoTorokuManager(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShujiiIkenshoTorokuManager}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link ShujiiIkenshoTorokuManager}のインスタンス
     */
    public static ShujiiIkenshoTorokuManager createInstance() {
        return InstanceProvider.create(ShujiiIkenshoTorokuManager.class);
    }

    /**
     * 主治医意見書登録画面初期検索
     *
     * @param param 主治医意見書登録のパラメータ
     * @return SearchResult<ShujiiIkenshoTorokuResult>
     */
    public SearchResult<ShujiiIkenshoTorokuResult> getDataForLoad(ShujiiIkenshoTorokuMapperParameter param) {
        List<ShujiiIkenshoTorokuResult> resultList = new ArrayList<>();
        ShujiiIkenshoTorokuRelateEntity entity
                = mapperProvider.create(IShujiiIkenshoTorokuMapper.class).getShujiiIkenshoForLoad(param);
        if (entity == null) {
            return SearchResult.of(Collections.<ShujiiIkenshoTorokuResult>emptyList(), 0, false);
        }
        resultList.add(new ShujiiIkenshoTorokuResult(entity));
        return SearchResult.of(resultList, 0, false);
    }

    /**
     * 意見書情報件数
     *
     * @param param 主治医意見書登録のパラメータ
     * @return int
     */
    public int getShujiiIkenshoKensu(ShujiiIkenshoTorokuMapperParameter param) {
        return mapperProvider.create(IShujiiIkenshoTorokuMapper.class).getShujiiIkenshoKensu(param);
    }

    /**
     * 一次判定データの件数
     *
     * @param param 主治医意見書登録のパラメータ
     * @return int
     */
    public int getIchijiHantei(ShujiiIkenshoTorokuMapperParameter param) {
        return mapperProvider.create(IShujiiIkenshoTorokuMapper.class).getIchijiHantei(param);
    }

    /**
     * 一次判定完了データ
     *
     * @param param 主治医意見書登録のパラメータ
     * @return int
     */
    public int getIchijiHanteiKanryo(ShujiiIkenshoTorokuMapperParameter param) {
        return mapperProvider.create(IShujiiIkenshoTorokuMapper.class).getIchijiHanteiKanryo(param);
    }

    /**
     * 一次判定未完了データ
     *
     * @param param 主治医意見書登録のパラメータ
     * @return int
     */
    public int getIchijiHanteiMikanryo(ShujiiIkenshoTorokuMapperParameter param) {
        return mapperProvider.create(IShujiiIkenshoTorokuMapper.class).getIchijiHanteiMikanryo(param);
    }

    /**
     * イメージ管理情報の更新
     *
     * @param イメージ管理情報　ImagekanriJoho
     */
    public void updateOrDelete(ImagekanriJoho イメージ管理情報) {
        IYokaigoninteiimagesakujoMapper mapper = mapperProvider.create(IYokaigoninteiimagesakujoMapper.class);

        mapper.deleteDbT5302PhysicalBy(YokaigoninteiimagesakujoMapperParameter.createDeleteByKeyParam_主治医意見書(
                イメージ管理情報.get申請書管理番号(), イメージ管理情報.get主治医意見書作成依頼履歴番号(), RString.EMPTY, false));
        mapper.deleteDbT5303PhysicalBy(YokaigoninteiimagesakujoMapperParameter.createDeleteByKeyParam_主治医意見書(
                イメージ管理情報.get申請書管理番号(), イメージ管理情報.get主治医意見書作成依頼履歴番号(), RString.EMPTY, false));
        mapper.deleteDbT5304PhysicalBy(YokaigoninteiimagesakujoMapperParameter.createDeleteByKeyParam_主治医意見書(
                イメージ管理情報.get申請書管理番号(), イメージ管理情報.get主治医意見書作成依頼履歴番号(), RString.EMPTY, false));
        mapper.deleteDbT5305PhysicalBy(YokaigoninteiimagesakujoMapperParameter.createDeleteByKeyParam_主治医意見書(
                イメージ管理情報.get申請書管理番号(), イメージ管理情報.get主治医意見書作成依頼履歴番号(), RString.EMPTY, false));

        mapper.deleteDbT5305PhysicalBy(YokaigoninteiimagesakujoMapperParameter.createDeleteByKeyParam_主治医意見書(
                イメージ管理情報.get申請書管理番号(), イメージ管理情報.get主治医意見書作成依頼履歴番号(), GenponMaskKubun.マスク.getコード(), true));

    }

    /**
     * {@link #checkEditable(jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo)
     * }の結果です。
     */
    public enum CheckEditableResult {

        編集可能,
        意見書書入手完了済み(DbeErrorMessages.完了済みのため不可.getMessage().replace("主治医意見書入手", "処理")),
        審査会結果登録完了済み(DbeErrorMessages.完了済みのため不可.getMessage().replace("審査会結果登録", "処理"));

        private final Message message;
        private final RString messageCode;

        CheckEditableResult() {
            this.message = null;
            this.messageCode = RString.EMPTY;
        }

        private CheckEditableResult(Message message) {
            this.message = message;
            this.messageCode = new RString(this.message.getCode());
        }

        /**
         * @return {@link #編集可能} のインスタンスである場合、{@code true}.
         */
        public boolean is編集可能() {
            return this == 編集可能;
        }

        /**
         * @return エラー内容を表すメッセージ.
         * {@link #is編集可能()}が{@code true}の場合、{@code null}.
         */
        public Message getMessage() {
            return this.message;
        }

        /**
         * @return エラー内容を表すメッセージのコード.
         * {@link #is編集可能()}が{@code true}の場合、{@link RString#EMPTY}.
         */
        public RString getMessageCode() {
            return this.messageCode;
        }
    }

    /**
     * @param 申請書管理番号 申請書管理番号
     * @return 指定の申請について、編集可能かどうかを検査した結果
     */
    public CheckEditableResult checkEditable(ShinseishoKanriNo 申請書管理番号) {
        NinteiKanryoJoho kj = NinteiKanryoJohoManager.createInstance().get要介護認定完了情報(申請書管理番号);
        if (!isNullOrEmpty(kj.get認定審査会完了年月日())) {
            return CheckEditableResult.審査会結果登録完了済み;
        }
        ShichosonSecurityJoho sj = ShichosonSecurityJohoFinder.createInstance()
                .getShichosonSecurityJoho(GyomuBunrui.介護認定);
        if (!isNullOrEmpty(kj.get主治医意見書登録完了年月日()) && (sj == null || !sj.get市町村情報().get市町村識別ID().is広域s())) {
            return CheckEditableResult.意見書書入手完了済み;
        }
        return CheckEditableResult.編集可能;
    }

    private static boolean isNullOrEmpty(FlexibleDate fDate) {
        return fDate == null || fDate.isEmpty();
    }

}
