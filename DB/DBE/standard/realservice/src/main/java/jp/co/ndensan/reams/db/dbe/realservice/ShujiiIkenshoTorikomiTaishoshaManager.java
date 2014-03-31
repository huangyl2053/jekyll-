/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.KaigoDoctor;
import jp.co.ndensan.reams.db.dbe.business.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbe.business.ShujiiIkenshoSakuseiIrai;
import jp.co.ndensan.reams.db.dbe.business.ShujiiIkenshoTorikomiTaishosha;
import jp.co.ndensan.reams.db.dbe.business.YokaigoninteiProgress;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.IkenshosakuseiIraiRirekiNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5001NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5005NinteiShinchokuJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.mapper.NinteiShinchokuJohoMapper;
import jp.co.ndensan.reams.db.dbe.entity.mapper.NinteishinseiJohoMapper;
import jp.co.ndensan.reams.db.dbe.entity.relate.KaigoNinteiShoriTaishoshaEntity;
import jp.co.ndensan.reams.db.dbe.persistence.relate.IShujiiIkenshoTorikomiTaishoshaDac;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IKojin;
import jp.co.ndensan.reams.ur.urz.realservice.KojinService;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 主治医意見書取込対象者を扱うクラスです。
 *
 * @author N8187 久保田 英男
 */
public class ShujiiIkenshoTorikomiTaishoshaManager {

    private final IShujiiIkenshoTorikomiTaishoshaDac torikomiTaishoshaDac;

    /**
     * コンストラクタです。
     */
    public ShujiiIkenshoTorikomiTaishoshaManager() {
        torikomiTaishoshaDac = InstanceProvider.create(IShujiiIkenshoTorikomiTaishoshaDac.class);
    }

    /**
     * テスト用プライベートコンストラクタです。
     *
     * @param torikomiTaishoshaDac torikomiTaishoshaDac
     */
    ShujiiIkenshoTorikomiTaishoshaManager(
            IShujiiIkenshoTorikomiTaishoshaDac torikomiTaishoshaDac) {
        this.torikomiTaishoshaDac = torikomiTaishoshaDac;
    }

    /**
     * 主治医意見書取込対象者を全件取得します。
     *
     * @return 主治医意見書取込対象者全件
     */
    public List<ShujiiIkenshoTorikomiTaishosha> get主治医意見書取込対象者全件() {
        List<KaigoNinteiShoriTaishoshaEntity> torikomiTaishoshaEntityList = torikomiTaishoshaDac.selectAll();
        return create主治医意見書取込対象者List(torikomiTaishoshaEntityList);
    }

    /**
     * 主治医意見書取込対象者を市町村コードを指定して全件取得します。
     *
     * @param 市町村コード 市町村コード
     * @return 主治医意見書取込対象者全件
     */
    public List<ShujiiIkenshoTorikomiTaishosha> get主治医意見書取込対象者全件(ShichosonCode 市町村コード) {
        List<KaigoNinteiShoriTaishoshaEntity> torikomiTaishoshaEntityList = torikomiTaishoshaDac.select市町村コード(市町村コード);
        return create主治医意見書取込対象者List(torikomiTaishoshaEntityList);
    }

    /**
     * 主治医意見書取込対象者を、市町村コードと支所コードを指定して全件取得します。
     *
     * @param 市町村コード 市町村コード
     * @param 支所コード 支所コード
     * @return 主治医意見書取込対象者全件
     */
    public List<ShujiiIkenshoTorikomiTaishosha> get主治医意見書取込対象者全件(ShichosonCode 市町村コード, RString 支所コード) {
        List<KaigoNinteiShoriTaishoshaEntity> torikomiTaishoshaEntityList = torikomiTaishoshaDac.select市町村コード及び支所コード(市町村コード, 支所コード);
        return create主治医意見書取込対象者List(torikomiTaishoshaEntityList);
    }

    /**
     * 主治医意見書取込対象者の進捗を完了状態にするために、要介護認定進捗情報の主治医意見書登録完了年月日を更新します。
     *
     * @param 主治医意見書取込対象者 主治医意見書取込対象者
     * @param 主治医意見書登録完了年月日 主治医意見書登録完了年月日
     * @return true:更新OK, false:更新NG
     */
    public boolean update主治医意見書登録完了年月日(ShujiiIkenshoTorikomiTaishosha 主治医意見書取込対象者, FlexibleDate 主治医意見書登録完了年月日) {
        YokaigoninteiProgress currentProgress = 主治医意見書取込対象者.get認定進捗情報();
        YokaigoninteiProgress yokaigoninteiProgress = new YokaigoninteiProgress(
                currentProgress.get申請書管理番号(),
                currentProgress.get認定申請情報登録年月日(),
                currentProgress.has認定延期通知発行に対する同意有無(),
                currentProgress.get認定延期通知発行年月日(),
                currentProgress.get認定延期通知発行回数(),
                currentProgress.get要介護認定延期理由(),
                currentProgress.get要介護認定一次判定情報抽出年月日(),
                currentProgress.get依頼情報データ送信年月日(),
                currentProgress.get認定調査依頼完了年月日(),
                currentProgress.get認定調査完了年月日(),
                currentProgress.get主治医意見書作成依頼完了年月日(),
                主治医意見書登録完了年月日,
                currentProgress.get要介護認定一次判定完了年月日(),
                currentProgress.get要介護認定1_5次判定完了年月日(),
                currentProgress.get認定審査会割当完了年月日(),
                currentProgress.get認定審査会完了年月日(),
                currentProgress.getセンター送信年月日());
        return new YokaigoninteiProgressManager().save(yokaigoninteiProgress);
    }

    private List<ShujiiIkenshoTorikomiTaishosha> create主治医意見書取込対象者List(
            List<KaigoNinteiShoriTaishoshaEntity> entityList) {
        List<ShujiiIkenshoTorikomiTaishosha> list = new ArrayList<>();

        for (KaigoNinteiShoriTaishoshaEntity entity : entityList) {
            list.add(create主治医意見書取込対象者(entity));
        }

        if (list.isEmpty()) {
            return Collections.EMPTY_LIST;
        }

        return list;
    }

    private ShujiiIkenshoTorikomiTaishosha create主治医意見書取込対象者(KaigoNinteiShoriTaishoshaEntity entity) {
        DbT5005NinteiShinchokuJohoEntity shinchokuEntity = entity.getNinteiShinchokuJohoEntity();
        DbT5001NinteiShinseiJohoEntity shinseiEntity = entity.getNinteiShinseiJohoEntity();

        YokaigoninteiProgress yokaigoninteiProgress = NinteiShinchokuJohoMapper.toNinteiShinchokuJoho(shinchokuEntity);
        NinteiShinseiJoho ninteiShinseiJoho = NinteishinseiJohoMapper.to認定申請情報(shinseiEntity);
        ShujiiIkenshoSakuseiIrai shujiiIkenshoIraiJoho = new ShujiiIkenshoSakuseiIraiKirokuManager().get主治医意見書作成依頼情報(
                shinseiEntity.getShinseishoKanriNo(), new IkenshosakuseiIraiRirekiNo(shinseiEntity.getIkenshoIraiRirekiNo()));
        IKojin kojin = KojinService.createKojinFinder().get個人(shinseiEntity.getShikibetsuCode());
        KaigoDoctor doctor = shujiiIkenshoIraiJoho.get介護医師();

        return new ShujiiIkenshoTorikomiTaishosha(
                yokaigoninteiProgress, ninteiShinseiJoho, shujiiIkenshoIraiJoho, kojin, doctor);
    }
}
