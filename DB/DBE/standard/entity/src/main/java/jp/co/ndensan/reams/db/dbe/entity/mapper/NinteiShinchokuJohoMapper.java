/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.mapper;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.YokaigoNinteiProgress;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ConsentsToEnkitsuchiHakko;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5005NinteiShinchokuJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.Messages;

/**
 * 認定進捗情報を変換するMapperクラスです。
 *
 * @author N8187 久保田 英男
 */
public final class NinteiShinchokuJohoMapper {

    /**
     * インスタンス化防止のためのプライベートコンストラクタです。
     */
    private NinteiShinchokuJohoMapper() {
    }

    /**
     * 認定進捗情報エンティティを認定進捗情報に変換します。
     *
     * @param entity 認定進捗情報エンティティ
     * @return 認定進捗情報
     */
    public static YokaigoNinteiProgress toNinteiShinchokuJoho(DbT5005NinteiShinchokuJohoEntity entity) {
        requireNonNull(entity, Messages.E00003.replace("認定進捗情報エンティティ", "認定進捗情報").getMessage());
        return new YokaigoNinteiProgress(
                entity.getShinseishoKanriNo(),
                entity.getNinteiShinseiJohoTorokuYMD(),
                ConsentsToEnkitsuchiHakko.toValue(entity.isEnkitsuchiDoiUmuKubun()),
                entity.getEnkitsuchiHakkoYMD(),
                entity.getEnkitsuchiHakkoKaisu(),
                entity.getNinteiEnkiRuyu(),
                entity.getIchijihanteiChushutsuYMD(),
                entity.getIraiJohoSoshinYMD(),
                entity.getNinteichosaIraiKanryoYMD(),
                entity.getNinteichosaKanryoYMD(),
                entity.getIkenshoSakuseiIraiKanryoYMD(),
                entity.getIkenshoTorokuKanryoYMD(),
                entity.getIchijiHanteiKanryoYMD(),
                entity.getIchiGoHanteiKanryoYMD(),
                entity.getNinteiShinsakaiWariateKanryoYMD(),
                entity.getNinteiShinsakaiKanryoYMD(),
                entity.getCenterSoshinYMD());
    }

    /**
     * 認定進捗情報を認定進捗情報エンティティに変換します。
     *
     * @param yokaigoninteiProgress 認定進捗情報
     * @return 認定進捗情報エンティティ
     */
    public static DbT5005NinteiShinchokuJohoEntity toNinteiShinchokuJohoEntity(YokaigoNinteiProgress yokaigoninteiProgress) {
        requireNonNull(yokaigoninteiProgress, Messages.E00003.replace("認定進捗情報", "認定進捗情報エンティティ").getMessage());
        DbT5005NinteiShinchokuJohoEntity entity = new DbT5005NinteiShinchokuJohoEntity();

        entity.setShinseishoKanriNo(yokaigoninteiProgress.get申請書管理番号());
        entity.setNinteiShinseiJohoTorokuYMD(yokaigoninteiProgress.get認定申請情報登録年月日());
        entity.setEnkitsuchiDoiUmuKubun(yokaigoninteiProgress.has認定延期通知発行に対する同意有無().is同意());
        entity.setEnkitsuchiHakkoYMD(yokaigoninteiProgress.get認定延期通知発行年月日());
        entity.setEnkitsuchiHakkoKaisu(yokaigoninteiProgress.get認定延期通知発行回数());
        entity.setNinteiEnkiRuyu(yokaigoninteiProgress.get要介護認定延期理由());
        entity.setIchijihanteiChushutsuYMD(yokaigoninteiProgress.get要介護認定一次判定情報抽出年月日());
        entity.setIraiJohoSoshinYMD(yokaigoninteiProgress.get依頼情報データ送信年月日());
        entity.setNinteichosaIraiKanryoYMD(yokaigoninteiProgress.get認定調査依頼完了年月日());
        entity.setNinteichosaKanryoYMD(yokaigoninteiProgress.get認定調査完了年月日());
        entity.setIkenshoSakuseiIraiKanryoYMD(yokaigoninteiProgress.get主治医意見書作成依頼完了年月日());
        entity.setIkenshoTorokuKanryoYMD(yokaigoninteiProgress.get主治医意見書登録完了年月日());
        entity.setIchijiHanteiKanryoYMD(yokaigoninteiProgress.get要介護認定一次判定完了年月日());
        entity.setIchiGoHanteiKanryoYMD(yokaigoninteiProgress.get要介護認定1_5次判定完了年月日());
        entity.setNinteiShinsakaiWariateKanryoYMD(yokaigoninteiProgress.get認定審査会割当完了年月日());
        entity.setNinteiShinsakaiKanryoYMD(yokaigoninteiProgress.get認定審査会完了年月日());
        entity.setCenterSoshinYMD(yokaigoninteiProgress.getセンター送信年月日());

        return entity;
    }
}
