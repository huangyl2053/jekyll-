/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.core.gaikyochosahyouniteichosahyousiseturiy.GaikyoChosahyouNiteichosahyouSisetuRiy02A;
import jp.co.ndensan.reams.db.dbe.definition.core.gaikyochosahyouniteichosahyousiseturiy.GaikyoChosahyouNiteichosahyouSisetuRiy06A;
import jp.co.ndensan.reams.db.dbe.definition.core.gaikyochosahyouniteichosahyousiseturiy.GaikyoChosahyouNiteichosahyouSisetuRiy09A;
import jp.co.ndensan.reams.db.dbe.definition.core.gaikyochosahyouniteichosahyousiseturiy.GaikyoChosahyouNiteichosahyouSisetuRiy09B;
import jp.co.ndensan.reams.db.dbe.definition.core.gaikyochosahyouniteichosahyousiseturiy.GaikyoChosahyouNiteichosahyouSisetuRiy99A;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ItiziHanteiEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ichijihanteikekkahyoa3.IchijihanteikekkahyoEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping02A;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping06A;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping09A;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping09B;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping99A;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser01;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser03;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser04;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser08;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser10;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser11;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser12;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser13;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser14;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser15;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser16;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser17;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser20;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser21;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser22;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser34;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku01;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku04;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku05;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku14;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoKomokuMapping02A;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoKomokuMapping06A;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoKomokuMapping09A;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoKomokuMapping09B;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoKomokuMapping99A;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5211NinteichosahyoChosaItemEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * 委員用一次判定結果票のEntityの編集クラスです。
 *
 * @reamsid_L DBE-0150-200 linghuhang
 */
public class IchijihanteikekkahyoItemSetteiTwo {

    private static final RString A_99 = new RString("99A");
    private static final RString A_02 = new RString("02A");
    private static final RString A_06 = new RString("06A");
    private static final RString A_09 = new RString("09A");
    private static final RString B_09 = new RString("09B");
    private static final RString 結果比較有 = new RString("★");
    private static final RString 結果比較無 = new RString("☆");
    private static final RString 結果比較_未 = new RString("未");
    private static final RString 改善 = new RString("▽");
    private static final RString 悪化 = new RString("▲");

    /**
     * 認定調査と主治医意見書の結果比較の設定です。
     *
     * @param item 委員用一次判定結果票のEntity
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param dbT5211厚労省IF識別コード dbT5211厚労省IF識別コード
     * @param itiziHanteiEntity ItiziHanteiEntity
     * @return IchijihanteikekkahyoItem
     */
    public IchijihanteikekkahyoEntity set認定調査と主治医意見書の結果比較(IchijihanteikekkahyoEntity item,
            RString 厚労省IF識別コード, RString dbT5211厚労省IF識別コード, ItiziHanteiEntity itiziHanteiEntity) {
        RString 認定調査左_上肢コード = RString.EMPTY;
        RString 医意見書左_上肢コード = RString.EMPTY;
        if (!RString.isNullOrEmpty(getコード(厚労省IF識別コード, itiziHanteiEntity.getDbt5211_remban()))
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5211_koroshoIfShikibetsuCode().value())) {
            認定調査左_上肢コード = ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード();
        }
        if (get主治医意見書コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5304_remban()
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5304_koroshoIfShikibetsuCode().value())) {
            医意見書左_上肢コード = IkenKomoku01.toValue(itiziHanteiEntity.getDbt5304_ikenItem()).getコード();
        }
        if (医意見書左_上肢コード.compareTo(認定調査左_上肢コード) > 0) {
            item.set結果比較_麻痺_左_上肢(結果比較有);
        } else if (認定調査左_上肢コード.compareTo(医意見書左_上肢コード) > 0) {
            item.set結果比較_麻痺_左_上肢(結果比較無);
        }
        RString 認定調査右_上肢コード = RString.EMPTY;
        RString 医意見書右_上肢コード = RString.EMPTY;
        if (!RString.isNullOrEmpty(getコード(厚労省IF識別コード, itiziHanteiEntity.getDbt5211_remban()))
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5211_koroshoIfShikibetsuCode().value())) {
            認定調査右_上肢コード = ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード();
        }
        if (get主治医右_上肢コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5304_remban()
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5304_koroshoIfShikibetsuCode().value())) {
            医意見書右_上肢コード = IkenKomoku01.toValue(itiziHanteiEntity.getDbt5304_ikenItem()).getコード();
        }
        if (医意見書右_上肢コード.compareTo(認定調査右_上肢コード) > 0) {
            item.set結果比較_麻痺_右_上肢(結果比較有);
        } else if (認定調査右_上肢コード.compareTo(医意見書右_上肢コード) > 0) {
            item.set結果比較_麻痺_右_上肢(結果比較無);
        }
        RString 認定調査左_下肢コード = RString.EMPTY;
        RString 医意見書左_下肢コード = RString.EMPTY;
        if (!RString.isNullOrEmpty(getコード(厚労省IF識別コード, itiziHanteiEntity.getDbt5211_remban()))
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5211_koroshoIfShikibetsuCode().value())) {
            認定調査左_下肢コード = ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード();
        }
        if (get主治医左_下肢コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5304_remban()
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5304_koroshoIfShikibetsuCode().value())) {
            医意見書左_下肢コード = IkenKomoku01.toValue(itiziHanteiEntity.getDbt5304_ikenItem()).getコード();
        }
        if (医意見書左_下肢コード.compareTo(認定調査左_下肢コード) > 0) {
            item.set結果比較_麻痺_左_下肢(結果比較有);
        } else if (認定調査左_下肢コード.compareTo(医意見書左_下肢コード) > 0) {
            item.set結果比較_麻痺_左_下肢(結果比較無);
        }
        set結果比較1(item, 厚労省IF識別コード, dbT5211厚労省IF識別コード, itiziHanteiEntity);
        set結果比較2(item, 厚労省IF識別コード, dbT5211厚労省IF識別コード, itiziHanteiEntity);
        set結果比較3(item, 厚労省IF識別コード, dbT5211厚労省IF識別コード, itiziHanteiEntity);
        set結果比較4(item, 厚労省IF識別コード, dbT5211厚労省IF識別コード, itiziHanteiEntity);
        set結果比較5(item, 厚労省IF識別コード, dbT5211厚労省IF識別コード, itiziHanteiEntity);
        set結果比較6(item, 厚労省IF識別コード, dbT5211厚労省IF識別コード, itiziHanteiEntity);
        set結果比較7(item, 厚労省IF識別コード, dbT5211厚労省IF識別コード, itiziHanteiEntity);
        set結果比較8(item, 厚労省IF識別コード, dbT5211厚労省IF識別コード, itiziHanteiEntity);
        return item;
    }

    /**
     * 前回結果の設定処理です。
     *
     * @param item IchijihanteikekkahyoItem
     * @param itemHensyu IchijihanteikekkahyoItemHensyu
     * @return IchijihanteikekkahyoItem
     */
    public IchijihanteikekkahyoEntity set段階改善(IchijihanteikekkahyoEntity item, IchijihanteikekkahyoItemHensyu itemHensyu) {
        item.set段階改善_麻痺_左_上肢(get段階改善(itemHensyu.get調査結果_麻痺_左_上肢(), itemHensyu.get前回結果_麻痺_左_上肢()));
        item.set段階改善_麻痺_左_下肢(get段階改善(itemHensyu.get調査結果_麻痺_左_下肢(), itemHensyu.get前回結果_麻痺_左_下肢()));
        item.set段階改善_麻痺_右_上肢(get段階改善(itemHensyu.get調査結果_麻痺_右_上肢(), itemHensyu.get前回結果_麻痺_右_上肢()));
        item.set段階改善_麻痺_右_下肢(get段階改善(itemHensyu.get調査結果_麻痺_左_上肢(), itemHensyu.get前回結果_麻痺_右_下肢()));
        item.set段階改善_麻痺_その他(get段階改善(itemHensyu.get調査結果_麻痺_左_上肢(), itemHensyu.get前回結果_麻痺_その他()));
        item.set段階改善_拘縮_肩関節(get段階改善(itemHensyu.get調査結果_拘縮_肩関節(), itemHensyu.get前回結果_拘縮_肩関節()));
        item.set段階改善_拘縮_股関節(get段階改善(itemHensyu.get調査結果_拘縮_股関節(), itemHensyu.get前回結果_拘縮_股関節()));
        item.set段階改善_拘縮_膝関節(get段階改善(itemHensyu.get調査結果_拘縮_膝関節(), itemHensyu.get前回結果_拘縮_膝関節()));
        item.set段階改善_拘縮_その他(get段階改善(itemHensyu.get調査結果_拘縮_その他(), itemHensyu.get前回結果_拘縮_その他()));
        item.set段階改善_寝返り(get段階改善(itemHensyu.get調査結果_寝返り(), itemHensyu.get前回結果_寝返り()));
        item.set段階改善_起き上がり(get段階改善(itemHensyu.get調査結果_起き上がり(), itemHensyu.get前回結果_起き上がり()));
        item.set段階改善_座位保持(get段階改善(itemHensyu.get調査結果_座位保持(), itemHensyu.get前回結果_座位保持()));
        item.set段階改善_両足での立位(get段階改善(itemHensyu.get調査結果_両足での立位(), itemHensyu.get前回結果_両足での立位()));
        item.set段階改善_歩行(get段階改善(itemHensyu.get調査結果_歩行(), itemHensyu.get前回結果_歩行()));
        item.set段階改善_立ち上がり(get段階改善(itemHensyu.get調査結果_立ち上がり(), itemHensyu.get前回結果_立ち上がり()));
        item.set段階改善_片足での立位(get段階改善(itemHensyu.get調査結果_片足での立位(), itemHensyu.get前回結果_片足での立位()));
        item.set段階改善_洗身(get段階改善(itemHensyu.get調査結果_洗身(), itemHensyu.get前回結果_洗身()));
        item.set段階改善_つめ切り(get段階改善(itemHensyu.get調査結果_つめ切り(), itemHensyu.get前回結果_つめ切り()));
        item.set段階改善_視力(get段階改善(itemHensyu.get調査結果_視力(), itemHensyu.get前回結果_視力()));
        item.set段階改善_聴力(get段階改善(itemHensyu.get調査結果_聴力(), itemHensyu.get前回結果_聴力()));
        item.set段階改善_移乗(get段階改善(itemHensyu.get調査結果_移乗(), itemHensyu.get前回結果_移乗()));
        item.set段階改善_移動(get段階改善(itemHensyu.get調査結果_移動(), itemHensyu.get前回結果_移動()));
        item.set段階改善_えん下(get段階改善(itemHensyu.get調査結果_えん下(), itemHensyu.get前回結果_えん下()));
        item.set段階改善_食事摂取(get段階改善(itemHensyu.get調査結果_食事摂取(), itemHensyu.get前回結果_食事摂取()));
        item.set段階改善_排尿(get段階改善(itemHensyu.get調査結果_排尿(), itemHensyu.get前回結果_排尿()));
        item.set段階改善_排便(get段階改善(itemHensyu.get調査結果_排便(), itemHensyu.get前回結果_排便()));
        item.set段階改善_口腔清潔(get段階改善(itemHensyu.get調査結果_口腔清潔(), itemHensyu.get前回結果_口腔清潔()));
        item.set段階改善_洗顔(get段階改善(itemHensyu.get調査結果_洗顔(), itemHensyu.get前回結果_洗顔()));
        item.set段階改善_整髪(get段階改善(itemHensyu.get調査結果_整髪(), itemHensyu.get前回結果_整髪()));
        item.set段階改善_上衣の着脱(get段階改善(itemHensyu.get調査結果_上衣の着脱(), itemHensyu.get前回結果_上衣の着脱()));
        item.set段階改善_ズボン等の着脱(get段階改善(itemHensyu.get調査結果_ズボン等の着脱(), itemHensyu.get前回結果_ズボン等の着脱()));
        item.set段階改善_外出頻度(get段階改善(itemHensyu.get調査結果_外出頻度(), itemHensyu.get前回結果_外出頻度()));
        item.set段階改善_意思の伝達(get段階改善(itemHensyu.get調査結果_意思の伝達(), itemHensyu.get前回結果_意思の伝達()));
        item.set段階改善_毎日の日課を理解(get段階改善(itemHensyu.get調査結果_毎日の日課を理解(), itemHensyu.get前回結果_毎日の日課を理解()));
        item.set段階改善_生年月日をいう(get段階改善(itemHensyu.get調査結果_生年月日をいう(), itemHensyu.get前回結果_生年月日をいう()));
        item.set段階改善_短期記憶(get段階改善(itemHensyu.get調査結果_短期記憶(), itemHensyu.get前回結果_短期記憶()));
        item.set段階改善_自分の名前をいう(get段階改善(itemHensyu.get調査結果_自分の名前をいう(), itemHensyu.get前回結果_自分の名前をいう()));
        item.set段階改善_今の季節を理解(get段階改善(itemHensyu.get調査結果_今の季節を理解(), itemHensyu.get前回結果_今の季節を理解()));
        item.set段階改善_場所の理解(get段階改善(itemHensyu.get調査結果_場所の理解(), itemHensyu.get前回結果_場所の理解()));
        item.set段階改善_徘徊(get段階改善(itemHensyu.get調査結果_徘徊(), itemHensyu.get前回結果_徘徊()));
        item.set段階改善_外出して戻れない(get段階改善(itemHensyu.get調査結果_外出して戻れない(), itemHensyu.get前回結果_外出して戻れない()));
        item.set段階改善_被害的(get段階改善(itemHensyu.get調査結果_被害的(), itemHensyu.get前回結果_被害的()));
        item.set段階改善_作話(get段階改善(itemHensyu.get調査結果_作話(), itemHensyu.get前回結果_作話()));
        item.set段階改善_感情が不安定(get段階改善(itemHensyu.get調査結果_感情が不安定(), itemHensyu.get前回結果_感情が不安定()));
        item.set段階改善_昼夜逆転(get段階改善(itemHensyu.get調査結果_昼夜逆転(), itemHensyu.get前回結果_昼夜逆転()));
        item.set段階改善_同じ話をする(get段階改善(itemHensyu.get調査結果_同じ話をする(), itemHensyu.get前回結果_同じ話をする()));
        item.set段階改善_大声を出す(get段階改善(itemHensyu.get調査結果_大声を出す(), itemHensyu.get前回結果_大声を出す()));
        item.set段階改善_介護に抵抗(get段階改善(itemHensyu.get調査結果_介護に抵抗(), itemHensyu.get前回結果_介護に抵抗()));
        item.set段階改善_落ち着きなし(get段階改善(itemHensyu.get調査結果_落ち着きなし(), itemHensyu.get前回結果_落ち着きなし()));
        item.set段階改善_一人で出たがる(get段階改善(itemHensyu.get調査結果_一人で出たがる(), itemHensyu.get前回結果_一人で出たがる()));
        item.set段階改善_収集癖(get段階改善(itemHensyu.get調査結果_収集癖(), itemHensyu.get前回結果_収集癖()));
        item.set段階改善_物や衣類を壊す(get段階改善(itemHensyu.get調査結果_物や衣類を壊す(), itemHensyu.get前回結果_物や衣類を壊す()));
        item.set段階改善_ひどい物忘れ(get段階改善(itemHensyu.get調査結果_ひどい物忘れ(), itemHensyu.get前回結果_ひどい物忘れ()));
        item.set段階改善_独り言_独り笑い(get段階改善(itemHensyu.get調査結果_独り言_独り笑い(), itemHensyu.get前回結果_独り言_独り笑い()));
        item.set段階改善_自分勝手に行動する(get段階改善(itemHensyu.get調査結果_自分勝手に行動する(), itemHensyu.get前回結果_自分勝手に行動する()));
        item.set段階改善_話がまとまらない(get段階改善(itemHensyu.get調査結果_話がまとまらない(), itemHensyu.get前回結果_話がまとまらない()));
        item.set段階改善_薬の内服(get段階改善(itemHensyu.get調査結果_薬の内服(), itemHensyu.get前回結果_薬の内服()));
        item.set段階改善_金銭の管理(get段階改善(itemHensyu.get調査結果_金銭の管理(), itemHensyu.get前回結果_金銭の管理()));
        item.set段階改善_日常の意思決定(get段階改善(itemHensyu.get調査結果_日常の意思決定(), itemHensyu.get前回結果_日常の意思決定()));
        item.set段階改善_集団への不適応(get段階改善(itemHensyu.get調査結果_集団への不適応(), itemHensyu.get前回結果_集団への不適応()));
        item.set段階改善_買い物(get段階改善(itemHensyu.get調査結果_買い物(), itemHensyu.get前回結果_買い物()));
        item.set段階改善_簡単な調理(get段階改善(itemHensyu.get調査結果_簡単な調理(), itemHensyu.get前回結果_簡単な調理()));
        item.set段階改善_点滴の管理(get特別な医療_段階改善(itemHensyu.get調査結果_点滴の管理(), itemHensyu.get前回結果_点滴の管理()));
        item.set段階改善_中心静脈栄養(get特別な医療_段階改善(itemHensyu.get調査結果_中心静脈栄養(), itemHensyu.get前回結果_中心静脈栄養()));
        item.set段階改善_透析(get特別な医療_段階改善(itemHensyu.get調査結果_透析(), itemHensyu.get前回結果_透析()));
        item.set段階改善_ストーマの処置(get特別な医療_段階改善(itemHensyu.get調査結果_ストーマの処置(), itemHensyu.get前回結果_ストーマの処置()));
        item.set段階改善_酸素療法(get特別な医療_段階改善(itemHensyu.get調査結果_酸素療法(), itemHensyu.get前回結果_酸素療法()));
        item.set段階改善_レスピレーター(get特別な医療_段階改善(itemHensyu.get調査結果_レスピレーター(), itemHensyu.get前回結果_レスピレーター()));
        item.set段階改善_気管切開の処置(get特別な医療_段階改善(itemHensyu.get調査結果_気管切開の処置(), itemHensyu.get前回結果_気管切開の処置()));
        item.set段階改善_疼痛の看護(get特別な医療_段階改善(itemHensyu.get調査結果_疼痛の看護(), itemHensyu.get前回結果_疼痛の看護()));
        item.set段階改善_経管栄養(get特別な医療_段階改善(itemHensyu.get調査結果_経管栄養(), itemHensyu.get前回結果_経管栄養()));
        item.set段階改善_モニター測定(get特別な医療_段階改善(itemHensyu.get調査結果_モニター測定(), itemHensyu.get前回結果_モニター測定()));
        item.set段階改善_じょくそうの処置(get特別な医療_段階改善(itemHensyu.get調査結果_じょくそうの処置(), itemHensyu.get前回結果_じょくそうの処置()));
        item.set段階改善_カテーテル(get特別な医療_段階改善(itemHensyu.get調査結果_カテーテル(), itemHensyu.get前回結果_カテーテル()));
        return item;
    }

    private RString get特別な医療_段階改善(RString 調査結果, RString 前回結果) {
        if (!RString.isNullOrEmpty(調査結果) && !RString.isNullOrEmpty(前回結果)) {
            if (前回結果.compareTo(調査結果) < 0) {
                return 悪化;
            }
            if (調査結果.compareTo(前回結果) < 0) {
                return 改善;
            }
        }
        return RString.EMPTY;
    }

    private RString get段階改善(RString 調査結果, RString 前回結果) {
        if (!RString.isNullOrEmpty(調査結果) && !RString.isNullOrEmpty(前回結果)) {
            if (前回結果.compareTo(調査結果) < 0) {
                return 段階悪化(Integer.valueOf(調査結果.toString()) - Integer.valueOf(前回結果.toString()));
            }
            if (前回結果.compareTo(調査結果) > 0) {
                return 段階改善(Integer.valueOf(調査結果.toString()) - Integer.valueOf(前回結果.toString()));
            }
        }
        return RString.EMPTY;
    }

    private RString 段階改善(int 段階) {
        RStringBuilder 段階改善 = new RStringBuilder();
        段階改善.append(改善);
        段階改善.append(段階);
        return 段階改善.toRString();
    }

    private RString 段階悪化(int 段階) {
        RStringBuilder 段階改善 = new RStringBuilder();
        段階改善.append(悪化);
        段階改善.append(段階);
        return 段階改善.toRString();
    }

    /**
     * 前回結果の設定処理です。
     *
     * @param item IchijihanteikekkahyoItem
     * @param entityList List<DbT5211NinteichosahyoChosaItemEntity>
     * @param itemHensyu IchijihanteikekkahyoItemHensyu
     * @return IchijihanteikekkahyoEntity
     */
    public IchijihanteikekkahyoEntity set前回結果(IchijihanteikekkahyoEntity item, List<DbT5211NinteichosahyoChosaItemEntity> entityList,
            IchijihanteikekkahyoItemHensyu itemHensyu) {
        IchijihanteikekkahyoItemSetteiThree setteiThree = new IchijihanteikekkahyoItemSetteiThree();
        for (DbT5211NinteichosahyoChosaItemEntity entity : entityList) {
            if ((entity.getKoroshoIfShikibetsuCode() == null || entity.getKoroshoIfShikibetsuCode().isEmpty()
                    && RString.isNullOrEmpty(entity.getResearchItem()))) {
                continue;
            }
            if (setteiThree.get麻痺_左_上肢(entity.getKoroshoIfShikibetsuCode().value()) == entity.getRemban()) {
                item.set前回結果_麻痺_左_上肢(ChosaAnser01.toValue(entity.getResearchItem()).get名称());
                itemHensyu.set前回結果_麻痺_左_上肢(ChosaAnser01.toValue(entity.getResearchItem()).getコード());
            } else if (setteiThree.get麻痺_左_下肢(entity.getKoroshoIfShikibetsuCode().value()) == entity.getRemban()) {
                item.set前回結果_麻痺_左_下肢(ChosaAnser01.toValue(entity.getResearchItem()).get名称());
                itemHensyu.set前回結果_麻痺_左_下肢(ChosaAnser01.toValue(entity.getResearchItem()).getコード());
            } else if (setteiThree.get麻痺_右_上肢(entity.getKoroshoIfShikibetsuCode().value()) == entity.getRemban()) {
                item.set前回結果_麻痺_右_上肢(ChosaAnser01.toValue(entity.getResearchItem()).get名称());
                itemHensyu.set前回結果_麻痺_右_上肢(ChosaAnser01.toValue(entity.getResearchItem()).getコード());
            } else if (setteiThree.get麻痺_右_下肢(entity.getKoroshoIfShikibetsuCode().value()) == entity.getRemban()) {
                item.set前回結果_麻痺_右_下肢(ChosaAnser01.toValue(entity.getResearchItem()).get名称());
                itemHensyu.set前回結果_麻痺_右_下肢(ChosaAnser01.toValue(entity.getResearchItem()).getコード());
            } else if (setteiThree.get麻痺_その他(entity.getKoroshoIfShikibetsuCode().value()) == entity.getRemban()) {
                item.set前回結果_麻痺_その他(ChosaAnser01.toValue(entity.getResearchItem()).get名称());
                itemHensyu.set前回結果_麻痺_その他(ChosaAnser01.toValue(entity.getResearchItem()).getコード());
            } else if (setteiThree.get拘縮_肩関節(entity.getKoroshoIfShikibetsuCode().value()) == entity.getRemban()) {
                item.set前回結果_拘縮_肩関節(ChosaAnser01.toValue(entity.getResearchItem()).get名称());
                itemHensyu.set前回結果_拘縮_肩関節(ChosaAnser01.toValue(entity.getResearchItem()).getコード());
            } else if (setteiThree.get拘縮_股関節(entity.getKoroshoIfShikibetsuCode().value()) == entity.getRemban()) {
                item.set前回結果_拘縮_股関節(ChosaAnser01.toValue(entity.getResearchItem()).get名称());
                itemHensyu.set前回結果_拘縮_股関節(ChosaAnser01.toValue(entity.getResearchItem()).getコード());
            } else if (setteiThree.get拘縮_膝関節(entity.getKoroshoIfShikibetsuCode().value()) == entity.getRemban()) {
                item.set前回結果_拘縮_膝関節(ChosaAnser01.toValue(entity.getResearchItem()).get名称());
                itemHensyu.set前回結果_拘縮_膝関節(ChosaAnser01.toValue(entity.getResearchItem()).getコード());
            } else if (setteiThree.get拘縮_その他(entity.getKoroshoIfShikibetsuCode().value()) == entity.getRemban()) {
                item.set前回結果_拘縮_その他(ChosaAnser01.toValue(entity.getResearchItem()).get名称());
                itemHensyu.set前回結果_拘縮_その他(ChosaAnser01.toValue(entity.getResearchItem()).getコード());
            } else if (setteiThree.get寝返り(entity.getKoroshoIfShikibetsuCode().value()) == entity.getRemban()) {
                item.set前回結果_寝返り(ChosaAnser02.toValue(entity.getResearchItem()).get名称());
                itemHensyu.set前回結果_寝返り(ChosaAnser02.toValue(entity.getResearchItem()).getコード());
            } else if (setteiThree.get起き上がり(entity.getKoroshoIfShikibetsuCode().value()) == entity.getRemban()) {
                item.set前回結果_起き上がり(ChosaAnser02.toValue(entity.getResearchItem()).get名称());
                itemHensyu.set前回結果_起き上がり(ChosaAnser02.toValue(entity.getResearchItem()).getコード());
            } else if (setteiThree.get座位保持(entity.getKoroshoIfShikibetsuCode().value()) == entity.getRemban()) {
                item.set前回結果_座位保持(ChosaAnser03.toValue(entity.getResearchItem()).get名称());
                itemHensyu.set前回結果_座位保持(ChosaAnser03.toValue(entity.getResearchItem()).getコード());
            } else {
                set前回結果1(entity, itemHensyu, item);
            }
        }
        return item;
    }

    private IchijihanteikekkahyoEntity set前回結果1(DbT5211NinteichosahyoChosaItemEntity entity, IchijihanteikekkahyoItemHensyu itemHensyu,
            IchijihanteikekkahyoEntity item) {
        IchijihanteikekkahyoItemSetteiThree setteiThree = new IchijihanteikekkahyoItemSetteiThree();
        if (setteiThree.get両足での立位(entity.getKoroshoIfShikibetsuCode().value()) == entity.getRemban()) {
            item.set前回結果_両足での立位(ChosaAnser04.toValue(entity.getResearchItem()).get名称());
            itemHensyu.set前回結果_両足での立位(ChosaAnser04.toValue(entity.getResearchItem()).getコード());
        } else if (setteiThree.get歩行(entity.getKoroshoIfShikibetsuCode().value()) == entity.getRemban()) {
            item.set前回結果_歩行(ChosaAnser02.toValue(entity.getResearchItem()).get名称());
            itemHensyu.set前回結果_歩行(ChosaAnser02.toValue(entity.getResearchItem()).getコード());
        } else if (setteiThree.get立ち上がり(entity.getKoroshoIfShikibetsuCode().value()) == entity.getRemban()) {
            item.set前回結果_立ち上がり(ChosaAnser02.toValue(entity.getResearchItem()).get名称());
            itemHensyu.set前回結果_立ち上がり(ChosaAnser02.toValue(entity.getResearchItem()).getコード());
        } else if (setteiThree.get片足での立位(entity.getKoroshoIfShikibetsuCode().value()) == entity.getRemban()) {
            item.set前回結果_片足での立位(ChosaAnser04.toValue(entity.getResearchItem()).get名称());
            itemHensyu.set前回結果_片足での立位(ChosaAnser04.toValue(entity.getResearchItem()).getコード());
        } else if (setteiThree.get洗身(entity.getKoroshoIfShikibetsuCode().value()) == entity.getRemban()) {
            item.set前回結果_洗身(ChosaAnser21.toValue(entity.getResearchItem()).get名称());
            itemHensyu.set前回結果_洗身(ChosaAnser21.toValue(entity.getResearchItem()).getコード());
        } else if (setteiThree.getつめ切り(entity.getKoroshoIfShikibetsuCode().value()) == entity.getRemban()) {
            item.set前回結果_つめ切り(ChosaAnser22.toValue(entity.getResearchItem()).get名称());
            itemHensyu.set前回結果_つめ切り(ChosaAnser22.toValue(entity.getResearchItem()).getコード());
        } else if (setteiThree.get視力(entity.getKoroshoIfShikibetsuCode().value()) == entity.getRemban()) {
            item.set前回結果_視力(ChosaAnser08.toValue(entity.getResearchItem()).get名称());
            itemHensyu.set前回結果_視力(ChosaAnser08.toValue(entity.getResearchItem()).getコード());
        } else if (setteiThree.get聴力(entity.getKoroshoIfShikibetsuCode().value()) == entity.getRemban()) {
            item.set前回結果_聴力(ChosaAnser09.toValue(entity.getResearchItem()).get名称());
            itemHensyu.set前回結果_聴力(ChosaAnser09.toValue(entity.getResearchItem()).getコード());
        } else if (setteiThree.get移乗(entity.getKoroshoIfShikibetsuCode().value()) == entity.getRemban()) {
            item.set前回結果_移乗(ChosaAnser20.toValue(entity.getResearchItem()).get名称());
            itemHensyu.set前回結果_移乗(ChosaAnser20.toValue(entity.getResearchItem()).getコード());
        } else if (setteiThree.get移動(entity.getKoroshoIfShikibetsuCode().value()) == entity.getRemban()) {
            item.set前回結果_移動(ChosaAnser20.toValue(entity.getResearchItem()).get名称());
            itemHensyu.set前回結果_移動(ChosaAnser20.toValue(entity.getResearchItem()).getコード());
        } else if (setteiThree.getえん下(entity.getKoroshoIfShikibetsuCode().value()) == entity.getRemban()) {
            item.set前回結果_えん下(ChosaAnser11.toValue(entity.getResearchItem()).get名称());
            itemHensyu.set前回結果_えん下(ChosaAnser11.toValue(entity.getResearchItem()).getコード());
        } else if (setteiThree.get食事摂取(entity.getKoroshoIfShikibetsuCode().value()) == entity.getRemban()) {
            item.set前回結果_食事摂取(ChosaAnser20.toValue(entity.getResearchItem()).get名称());
            itemHensyu.set前回結果_食事摂取(ChosaAnser20.toValue(entity.getResearchItem()).getコード());
        } else if (setteiThree.get排尿(entity.getKoroshoIfShikibetsuCode().value()) == entity.getRemban()) {
            item.set前回結果_排尿(ChosaAnser20.toValue(entity.getResearchItem()).get名称());
            itemHensyu.set前回結果_排尿(ChosaAnser20.toValue(entity.getResearchItem()).getコード());
        }
        if (setteiThree.get排便(entity.getKoroshoIfShikibetsuCode().value()) == entity.getRemban()) {
            item.set前回結果_排便(ChosaAnser20.toValue(entity.getResearchItem()).get名称());
            itemHensyu.set前回結果_排便(ChosaAnser20.toValue(entity.getResearchItem()).getコード());
        } else {
            set前回結果2(entity, itemHensyu, item);
        }
        return item;
    }

    private IchijihanteikekkahyoEntity set前回結果2(DbT5211NinteichosahyoChosaItemEntity entity, IchijihanteikekkahyoItemHensyu itemHensyu,
            IchijihanteikekkahyoEntity item) {
        IchijihanteikekkahyoItemSetteiThree setteiThree = new IchijihanteikekkahyoItemSetteiThree();
        if (setteiThree.get口腔清潔(entity.getKoroshoIfShikibetsuCode().value()) == entity.getRemban()) {
            item.set前回結果_口腔清潔(ChosaAnser22.toValue(entity.getResearchItem()).get名称());
            itemHensyu.set前回結果_口腔清潔(ChosaAnser22.toValue(entity.getResearchItem()).getコード());
        } else if (setteiThree.get洗顔(entity.getKoroshoIfShikibetsuCode().value()) == entity.getRemban()) {
            item.set前回結果_洗顔(ChosaAnser22.toValue(entity.getResearchItem()).get名称());
            itemHensyu.set前回結果_洗顔(ChosaAnser22.toValue(entity.getResearchItem()).getコード());
        } else if (setteiThree.get整髪(entity.getKoroshoIfShikibetsuCode().value()) == entity.getRemban()) {
            item.set前回結果_整髪(ChosaAnser22.toValue(entity.getResearchItem()).get名称());
            itemHensyu.set前回結果_整髪(ChosaAnser22.toValue(entity.getResearchItem()).getコード());
        } else if (setteiThree.get上衣の着脱(entity.getKoroshoIfShikibetsuCode().value()) == entity.getRemban()) {
            item.set前回結果_上衣の着脱(ChosaAnser34.toValue(entity.getResearchItem()).get名称());
            itemHensyu.set前回結果_上衣の着脱(ChosaAnser34.toValue(entity.getResearchItem()).getコード());
        } else if (setteiThree.getズボン等の着脱(entity.getKoroshoIfShikibetsuCode().value()) == entity.getRemban()) {
            item.set前回結果_ズボン等の着脱(ChosaAnser34.toValue(entity.getResearchItem()).get名称());
            itemHensyu.set前回結果_ズボン等の着脱(ChosaAnser34.toValue(entity.getResearchItem()).getコード());
        } else if (setteiThree.get外出頻度(entity.getKoroshoIfShikibetsuCode().value()) == entity.getRemban()) {
            item.set前回結果_外出頻度(ChosaAnser13.toValue(entity.getResearchItem()).get名称());
            itemHensyu.set前回結果_外出頻度(ChosaAnser13.toValue(entity.getResearchItem()).getコード());
        } else if (setteiThree.get意思の伝達(entity.getKoroshoIfShikibetsuCode().value()) == entity.getRemban()) {
            item.set前回結果_意思の伝達(ChosaAnser14.toValue(entity.getResearchItem()).get名称());
            itemHensyu.set前回結果_意思の伝達(ChosaAnser14.toValue(entity.getResearchItem()).getコード());
        } else if (setteiThree.get毎日の日課を理解(entity.getKoroshoIfShikibetsuCode().value()) == entity.getRemban()) {
            item.set前回結果_毎日の日課を理解(ChosaAnser15.toValue(entity.getResearchItem()).get名称());
            itemHensyu.set前回結果_毎日の日課を理解(ChosaAnser15.toValue(entity.getResearchItem()).getコード());
        } else if (setteiThree.get生年月日をいう(entity.getKoroshoIfShikibetsuCode().value()) == entity.getRemban()) {
            item.set前回結果_生年月日をいう(ChosaAnser15.toValue(entity.getResearchItem()).get名称());
            itemHensyu.set前回結果_生年月日をいう(ChosaAnser15.toValue(entity.getResearchItem()).getコード());
        } else if (setteiThree.get短期記憶(entity.getKoroshoIfShikibetsuCode().value()) == entity.getRemban()) {
            item.set前回結果_短期記憶(ChosaAnser15.toValue(entity.getResearchItem()).get名称());
            itemHensyu.set前回結果_短期記憶(ChosaAnser15.toValue(entity.getResearchItem()).getコード());
        } else if (setteiThree.get自分の名前をいう(entity.getKoroshoIfShikibetsuCode().value()) == entity.getRemban()) {
            item.set前回結果_自分の名前をいう(ChosaAnser15.toValue(entity.getResearchItem()).get名称());
            itemHensyu.set前回結果_自分の名前をいう(ChosaAnser15.toValue(entity.getResearchItem()).getコード());
        } else if (setteiThree.get今の季節を理解(entity.getKoroshoIfShikibetsuCode().value()) == entity.getRemban()) {
            item.set前回結果_今の季節を理解(ChosaAnser15.toValue(entity.getResearchItem()).get名称());
            itemHensyu.set前回結果_今の季節を理解(ChosaAnser15.toValue(entity.getResearchItem()).getコード());
        } else if (setteiThree.get場所の理解(entity.getKoroshoIfShikibetsuCode().value()) == entity.getRemban()) {
            item.set前回結果_場所の理解(ChosaAnser15.toValue(entity.getResearchItem()).get名称());
            itemHensyu.set前回結果_場所の理解(ChosaAnser15.toValue(entity.getResearchItem()).getコード());
        } else if (setteiThree.get徘徊(entity.getKoroshoIfShikibetsuCode().value()) == entity.getRemban()) {
            item.set前回結果_徘徊(ChosaAnser16.toValue(entity.getResearchItem()).get名称());
            itemHensyu.set前回結果_徘徊(ChosaAnser16.toValue(entity.getResearchItem()).getコード());
        } else if (setteiThree.get外出して戻れない(entity.getKoroshoIfShikibetsuCode().value()) == entity.getRemban()) {
            item.set前回結果_外出して戻れない(ChosaAnser16.toValue(entity.getResearchItem()).get名称());
            itemHensyu.set前回結果_外出して戻れない(ChosaAnser16.toValue(entity.getResearchItem()).getコード());
        } else if (setteiThree.get被害的(entity.getKoroshoIfShikibetsuCode().value()) == entity.getRemban()) {
            item.set前回結果_被害的(ChosaAnser16.toValue(entity.getResearchItem()).get名称());
            itemHensyu.set前回結果_被害的(ChosaAnser16.toValue(entity.getResearchItem()).getコード());
        } else if (setteiThree.get作話(entity.getKoroshoIfShikibetsuCode().value()) == entity.getRemban()) {
            item.set前回結果_作話(ChosaAnser16.toValue(entity.getResearchItem()).get名称());
            itemHensyu.set前回結果_作話(ChosaAnser16.toValue(entity.getResearchItem()).getコード());
        } else if (setteiThree.get感情が不安定(entity.getKoroshoIfShikibetsuCode().value()) == entity.getRemban()) {
            item.set前回結果_感情が不安定(ChosaAnser16.toValue(entity.getResearchItem()).get名称());
            itemHensyu.set前回結果_感情が不安定(ChosaAnser16.toValue(entity.getResearchItem()).getコード());
        } else {
            set前回結果3(entity, itemHensyu, item);
        }
        return item;
    }

    private IchijihanteikekkahyoEntity set前回結果3(DbT5211NinteichosahyoChosaItemEntity entity, IchijihanteikekkahyoItemHensyu itemHensyu,
            IchijihanteikekkahyoEntity item) {
        IchijihanteikekkahyoItemSetteiThree setteiThree = new IchijihanteikekkahyoItemSetteiThree();
        if (setteiThree.get昼夜逆転(entity.getKoroshoIfShikibetsuCode().value()) == entity.getRemban()) {
            item.set前回結果_昼夜逆転(ChosaAnser16.toValue(entity.getResearchItem()).get名称());
            itemHensyu.set前回結果_昼夜逆転(ChosaAnser16.toValue(entity.getResearchItem()).getコード());
        } else if (setteiThree.get同じ話をする(entity.getKoroshoIfShikibetsuCode().value()) == entity.getRemban()) {
            item.set前回結果_同じ話をする(ChosaAnser16.toValue(entity.getResearchItem()).get名称());
            itemHensyu.set前回結果_同じ話をする(ChosaAnser16.toValue(entity.getResearchItem()).getコード());
        } else if (setteiThree.get大声を出す(entity.getKoroshoIfShikibetsuCode().value()) == entity.getRemban()) {
            item.set前回結果_大声を出す(ChosaAnser16.toValue(entity.getResearchItem()).get名称());
            itemHensyu.set前回結果_大声を出す(ChosaAnser16.toValue(entity.getResearchItem()).getコード());
        } else if (setteiThree.get介護に抵抗(entity.getKoroshoIfShikibetsuCode().value()) == entity.getRemban()) {
            item.set前回結果_介護に抵抗(ChosaAnser16.toValue(entity.getResearchItem()).get名称());
            itemHensyu.set前回結果_介護に抵抗(ChosaAnser16.toValue(entity.getResearchItem()).getコード());
        } else if (setteiThree.get落ち着きなし(entity.getKoroshoIfShikibetsuCode().value()) == entity.getRemban()) {
            item.set前回結果_落ち着きなし(ChosaAnser16.toValue(entity.getResearchItem()).get名称());
            itemHensyu.set前回結果_落ち着きなし(ChosaAnser16.toValue(entity.getResearchItem()).getコード());
        } else if (setteiThree.get一人で出たがる(entity.getKoroshoIfShikibetsuCode().value()) == entity.getRemban()) {
            item.set前回結果_一人で出たがる(ChosaAnser16.toValue(entity.getResearchItem()).get名称());
            itemHensyu.set前回結果_一人で出たがる(ChosaAnser16.toValue(entity.getResearchItem()).getコード());
        } else if (setteiThree.get収集癖(entity.getKoroshoIfShikibetsuCode().value()) == entity.getRemban()) {
            item.set前回結果_収集癖(ChosaAnser16.toValue(entity.getResearchItem()).get名称());
            itemHensyu.set前回結果_収集癖(ChosaAnser16.toValue(entity.getResearchItem()).getコード());
        } else if (setteiThree.get物や衣類を壊す(entity.getKoroshoIfShikibetsuCode().value()) == entity.getRemban()) {
            item.set前回結果_物や衣類を壊す(ChosaAnser16.toValue(entity.getResearchItem()).get名称());
            itemHensyu.set前回結果_物や衣類を壊す(ChosaAnser16.toValue(entity.getResearchItem()).getコード());
        } else if (setteiThree.getひどい物忘れ(entity.getKoroshoIfShikibetsuCode().value()) == entity.getRemban()) {
            item.set前回結果_ひどい物忘れ(ChosaAnser16.toValue(entity.getResearchItem()).get名称());
            itemHensyu.set前回結果_ひどい物忘れ(ChosaAnser16.toValue(entity.getResearchItem()).getコード());
        } else if (setteiThree.get独り言_独り笑い(entity.getKoroshoIfShikibetsuCode().value()) == entity.getRemban()) {
            item.set前回結果_独り言_独り笑い(ChosaAnser16.toValue(entity.getResearchItem()).get名称());
            itemHensyu.set前回結果_独り言_独り笑い(ChosaAnser16.toValue(entity.getResearchItem()).getコード());
        } else if (setteiThree.get自分勝手に行動する(entity.getKoroshoIfShikibetsuCode().value()) == entity.getRemban()) {
            item.set前回結果_自分勝手に行動する(ChosaAnser16.toValue(entity.getResearchItem()).get名称());
            itemHensyu.set前回結果_自分勝手に行動する(ChosaAnser16.toValue(entity.getResearchItem()).getコード());
        } else if (setteiThree.get話がまとまらない(entity.getKoroshoIfShikibetsuCode().value()) == entity.getRemban()) {
            item.set前回結果_話がまとまらない(ChosaAnser16.toValue(entity.getResearchItem()).get名称());
            itemHensyu.set前回結果_話がまとまらない(ChosaAnser16.toValue(entity.getResearchItem()).getコード());
        } else if (setteiThree.get薬の内服(entity.getKoroshoIfShikibetsuCode().value()) == entity.getRemban()) {
            item.set前回結果_薬の内服(ChosaAnser12.toValue(entity.getResearchItem()).get名称());
            itemHensyu.set前回結果_薬の内服(ChosaAnser12.toValue(entity.getResearchItem()).getコード());
        } else if (setteiThree.get金銭の管理(entity.getKoroshoIfShikibetsuCode().value()) == entity.getRemban()) {
            item.set前回結果_金銭の管理(ChosaAnser12.toValue(entity.getResearchItem()).get名称());
            itemHensyu.set前回結果_金銭の管理(ChosaAnser12.toValue(entity.getResearchItem()).getコード());
        } else if (setteiThree.get日常の意思決定(entity.getKoroshoIfShikibetsuCode().value()) == entity.getRemban()) {
            item.set前回結果_日常の意思決定(ChosaAnser17.toValue(entity.getResearchItem()).get名称());
            itemHensyu.set前回結果_日常の意思決定(ChosaAnser17.toValue(entity.getResearchItem()).getコード());
        } else if (setteiThree.get集団への不適応(entity.getKoroshoIfShikibetsuCode().value()) == entity.getRemban()) {
            item.set前回結果_集団への不適応(ChosaAnser16.toValue(entity.getResearchItem()).get名称());
            itemHensyu.set前回結果_集団への不適応(ChosaAnser16.toValue(entity.getResearchItem()).getコード());
        } else if (setteiThree.get買い物(entity.getKoroshoIfShikibetsuCode().value()) == entity.getRemban()) {
            item.set前回結果_買い物(ChosaAnser10.toValue(entity.getResearchItem()).get名称());
            itemHensyu.set前回結果_買い物(ChosaAnser10.toValue(entity.getResearchItem()).getコード());
        } else if (setteiThree.get簡単な調理(entity.getKoroshoIfShikibetsuCode().value()) == entity.getRemban()) {
            item.set前回結果_簡単な調理(ChosaAnser10.toValue(entity.getResearchItem()).get名称());
            itemHensyu.set前回結果_簡単な調理(ChosaAnser10.toValue(entity.getResearchItem()).getコード());
        } else {
            set前回結果4(entity, itemHensyu, item);
        }
        return item;
    }

    private IchijihanteikekkahyoEntity set前回結果4(DbT5211NinteichosahyoChosaItemEntity entity, IchijihanteikekkahyoItemHensyu itemHensyu,
            IchijihanteikekkahyoEntity item) {
        IchijihanteikekkahyoItemSetteiThree setteiThree = new IchijihanteikekkahyoItemSetteiThree();
        if (setteiThree.get点滴の管理(entity.getKoroshoIfShikibetsuCode().value()) == entity.getRemban()) {
            itemHensyu.set前回結果_点滴の管理(ChosaAnser10.toValue(entity.getResearchItem()).getコード());
        } else if (setteiThree.get中心静脈栄養(entity.getKoroshoIfShikibetsuCode().value()) == entity.getRemban()) {
            itemHensyu.set前回結果_中心静脈栄養(ChosaAnser10.toValue(entity.getResearchItem()).getコード());
        } else if (setteiThree.get透析(entity.getKoroshoIfShikibetsuCode().value()) == entity.getRemban()) {
            itemHensyu.set前回結果_透析(ChosaAnser10.toValue(entity.getResearchItem()).getコード());
        } else if (setteiThree.getストーマの処置(entity.getKoroshoIfShikibetsuCode().value()) == entity.getRemban()) {
            itemHensyu.set前回結果_ストーマの処置(ChosaAnser10.toValue(entity.getResearchItem()).getコード());
        } else if (setteiThree.get酸素療法(entity.getKoroshoIfShikibetsuCode().value()) == entity.getRemban()) {
            itemHensyu.set前回結果_酸素療法(ChosaAnser10.toValue(entity.getResearchItem()).getコード());
        } else if (setteiThree.getレスピレーター(entity.getKoroshoIfShikibetsuCode().value()) == entity.getRemban()) {
            itemHensyu.set前回結果_レスピレーター(ChosaAnser10.toValue(entity.getResearchItem()).getコード());
        } else if (setteiThree.get気管切開の処置(entity.getKoroshoIfShikibetsuCode().value()) == entity.getRemban()) {
            itemHensyu.set前回結果_気管切開の処置(ChosaAnser10.toValue(entity.getResearchItem()).getコード());
        } else if (setteiThree.get疼痛の看護(entity.getKoroshoIfShikibetsuCode().value()) == entity.getRemban()) {
            itemHensyu.set前回結果_疼痛の看護(ChosaAnser10.toValue(entity.getResearchItem()).getコード());
        } else if (setteiThree.get経管栄養(entity.getKoroshoIfShikibetsuCode().value()) == entity.getRemban()) {
            itemHensyu.set前回結果_経管栄養(ChosaAnser10.toValue(entity.getResearchItem()).getコード());
        } else if (setteiThree.getモニター測定(entity.getKoroshoIfShikibetsuCode().value()) == entity.getRemban()) {
            itemHensyu.set前回結果_モニター測定(ChosaAnser10.toValue(entity.getResearchItem()).getコード());
        } else if (setteiThree.getじょくそうの処置(entity.getKoroshoIfShikibetsuCode().value()) == entity.getRemban()) {
            itemHensyu.set前回結果_じょくそうの処置(ChosaAnser10.toValue(entity.getResearchItem()).getコード());
        } else if (setteiThree.getカテーテル(entity.getKoroshoIfShikibetsuCode().value()) == entity.getRemban()) {
            itemHensyu.set前回結果_カテーテル(ChosaAnser10.toValue(entity.getResearchItem()).getコード());
        }
        return item;
    }

    private IchijihanteikekkahyoEntity set結果比較1(IchijihanteikekkahyoEntity item,
            RString 厚労省IF識別コード, RString dbT5211厚労省IF識別コード, ItiziHanteiEntity itiziHanteiEntity) {
        RString 認定調査右_下肢コード = RString.EMPTY;
        RString 医意見書右_下肢コード = RString.EMPTY;
        if (!RString.isNullOrEmpty(getコード(厚労省IF識別コード, itiziHanteiEntity.getDbt5211_remban()))
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5211_koroshoIfShikibetsuCode().value())) {
            認定調査右_下肢コード = ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード();
        }
        if (get主治医右_下肢コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5304_remban()
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5304_koroshoIfShikibetsuCode().value())) {
            医意見書右_下肢コード = IkenKomoku01.toValue(itiziHanteiEntity.getDbt5304_ikenItem()).getコード();
        }
        if (医意見書右_下肢コード.compareTo(認定調査右_下肢コード) > 0) {
            item.set結果比較_麻痺_右_下肢(結果比較有);
        } else if (認定調査右_下肢コード.compareTo(医意見書右_下肢コード) > 0) {
            item.set結果比較_麻痺_右_下肢(結果比較無);
        }
        RString 認定調査その他 = RString.EMPTY;
        RString 医意見書その他 = RString.EMPTY;
        if (!RString.isNullOrEmpty(getコード(厚労省IF識別コード, itiziHanteiEntity.getDbt5211_remban()))
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5211_koroshoIfShikibetsuCode().value())) {
            認定調査その他 = ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード();
        }
        if (get主治医その他コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5304_remban()
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5304_koroshoIfShikibetsuCode().value())) {
            医意見書その他 = IkenKomoku01.toValue(itiziHanteiEntity.getDbt5304_ikenItem()).getコード();
        }
        if (医意見書その他.compareTo(認定調査その他) > 0) {
            item.set結果比較_麻痺_その他(結果比較有);
        } else if (認定調査その他.compareTo(医意見書その他) > 0) {
            item.set結果比較_麻痺_その他(結果比較無);
        }
        RString 認定調査拘縮_肩関節 = RString.EMPTY;
        RString 医意見書拘縮_肩関節 = RString.EMPTY;
        if (!RString.isNullOrEmpty(getコード(厚労省IF識別コード, itiziHanteiEntity.getDbt5211_remban()))
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5211_koroshoIfShikibetsuCode().value())) {
            認定調査拘縮_肩関節 = ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード();
        }
        if (get主治医拘縮_肩関節コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5304_remban()
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5304_koroshoIfShikibetsuCode().value())) {
            医意見書拘縮_肩関節 = IkenKomoku01.toValue(itiziHanteiEntity.getDbt5304_ikenItem()).getコード();
        }
        if (医意見書拘縮_肩関節.compareTo(認定調査拘縮_肩関節) > 0) {
            item.set結果比較_拘縮_肩関節(結果比較有);
        } else if (認定調査拘縮_肩関節.compareTo(医意見書拘縮_肩関節) > 0) {
            item.set結果比較_拘縮_肩関節(結果比較無);
        }
        return item;
    }

    private IchijihanteikekkahyoEntity set結果比較_食事摂取(IchijihanteikekkahyoEntity item,
            RString 厚労省IF識別コード, RString dbT5211厚労省IF識別コード, ItiziHanteiEntity itiziHanteiEntity) {
        RString 認定調査食事摂取 = RString.EMPTY;
        RString 医意見書食事摂取 = RString.EMPTY;
        if (!RString.isNullOrEmpty(getコード(厚労省IF識別コード, itiziHanteiEntity.getDbt5211_remban()))
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5211_koroshoIfShikibetsuCode().value())) {
            認定調査食事摂取 = ChosaAnser20.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード();
        }
        if (get主治医食事摂取コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5304_remban()
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5304_koroshoIfShikibetsuCode().value())) {
            医意見書食事摂取 = IkenKomoku14.toValue(itiziHanteiEntity.getDbt5304_ikenItem()).getコード();
        }
        if (!IkenKomoku14.記載なし.getコード().equals(医意見書食事摂取) && IkenKomoku14.全面介助.getコード().equals(医意見書食事摂取)
                && !ChosaAnser20.全介助.getコード().equals(認定調査食事摂取)) {
            item.set結果比較_食事摂取(結果比較有);
        } else if (!IkenKomoku14.記載なし.getコード().equals(医意見書食事摂取)
                && IkenKomoku14.自立ないし何とか自分で食べられる.getコード().equals(医意見書食事摂取)
                && !ChosaAnser20.自立.getコード().equals(認定調査食事摂取)) {
            item.set結果比較_食事摂取(結果比較無);
        } else if (!RString.isNullOrEmpty(認定調査食事摂取) && RString.isNullOrEmpty(医意見書食事摂取)) {
            item.set結果比較_食事摂取(結果比較_未);
        }
        return item;
    }

    private IchijihanteikekkahyoEntity set結果比較2(IchijihanteikekkahyoEntity item,
            RString 厚労省IF識別コード, RString dbT5211厚労省IF識別コード, ItiziHanteiEntity itiziHanteiEntity) {
        IchijihanteikekkahyoItemSetteiThree setteiThree = new IchijihanteikekkahyoItemSetteiThree();
        set結果比較_食事摂取(item, 厚労省IF識別コード, dbT5211厚労省IF識別コード, itiziHanteiEntity);
        RString 認定調査意思の伝達 = RString.EMPTY;
        RString 医意見書意思の伝達 = RString.EMPTY;
        if (get意思の伝達コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5211_koroshoIfShikibetsuCode().value())) {
            認定調査意思の伝達 = ChosaAnser14.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード();
        }
        if (get主治医意思の伝達コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5304_remban()
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5304_koroshoIfShikibetsuCode().value())) {
            医意見書意思の伝達 = IkenKomoku06.toValue(itiziHanteiEntity.getDbt5304_ikenItem()).getコード();
        }
        if (!IkenKomoku06.記載なし.getコード().equals(医意見書意思の伝達) && 医意見書意思の伝達.compareTo(認定調査意思の伝達) > 0) {
            item.set結果比較_意思の伝達(結果比較有);
        } else if (!IkenKomoku06.記載なし.getコード().equals(医意見書意思の伝達) && 認定調査意思の伝達.compareTo(医意見書意思の伝達) > 0) {
            item.set結果比較_意思の伝達(結果比較無);
        } else if (!RString.isNullOrEmpty(認定調査意思の伝達) && RString.isNullOrEmpty(医意見書意思の伝達)) {
            item.set結果比較_意思の伝達(結果比較_未);
        }
        RString 認定調査徘徊 = RString.EMPTY;
        RString 医意見書徘徊 = RString.EMPTY;
        if (setteiThree.get徘徊(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5211_koroshoIfShikibetsuCode().value())) {
            認定調査徘徊 = ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード();
        }
        if (get主治医徘徊コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5304_remban()
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5304_koroshoIfShikibetsuCode().value())) {
            医意見書徘徊 = IkenKomoku01.toValue(itiziHanteiEntity.getDbt5304_ikenItem()).getコード();
        }
        if (医意見書徘徊.compareTo(認定調査徘徊) > 0) {
            item.set結果比較_徘徊(結果比較有);
        } else if (認定調査徘徊.compareTo(医意見書徘徊) > 0) {
            item.set結果比較_徘徊(結果比較無);
        }
        return item;
    }

    private IchijihanteikekkahyoEntity set結果比較3(IchijihanteikekkahyoEntity item,
            RString 厚労省IF識別コード, RString dbT5211厚労省IF識別コード, ItiziHanteiEntity itiziHanteiEntity) {
        IchijihanteikekkahyoItemSetteiThree setteiThree = new IchijihanteikekkahyoItemSetteiThree();
        RString 認定調査短期記憶 = RString.EMPTY;
        RString 医意見書短期記憶 = RString.EMPTY;
        if (get短期記憶コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5211_koroshoIfShikibetsuCode().value())) {
            認定調査短期記憶 = ChosaAnser15.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード();
        }
        if (get主治医短期記憶コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5304_remban()
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5304_koroshoIfShikibetsuCode().value())) {
            医意見書短期記憶 = IkenKomoku04.toValue(itiziHanteiEntity.getDbt5304_ikenItem()).getコード();
        }
        if (!IkenKomoku04.記載なし.getコード().equals(医意見書短期記憶) && 医意見書短期記憶.compareTo(認定調査短期記憶) > 0) {
            item.set結果比較_短期記憶(結果比較有);
        } else if (!IkenKomoku04.記載なし.getコード().equals(医意見書短期記憶) && 認定調査短期記憶.compareTo(医意見書短期記憶) > 0) {
            item.set結果比較_短期記憶(結果比較無);
        } else if (!RString.isNullOrEmpty(認定調査短期記憶) && RString.isNullOrEmpty(医意見書短期記憶)) {
            item.set結果比較_短期記憶(結果比較_未);
        }
        RString 認定調査被害的 = RString.EMPTY;
        RString 医意見書被害的 = RString.EMPTY;
        if (setteiThree.get被害的(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5211_koroshoIfShikibetsuCode().value())) {
            認定調査被害的 = ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード();
        }
        if (get主治医被害的コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5304_remban()
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5304_koroshoIfShikibetsuCode().value())) {
            医意見書被害的 = IkenKomoku01.toValue(itiziHanteiEntity.getDbt5304_ikenItem()).getコード();
        }
        if (医意見書被害的.compareTo(認定調査被害的) > 0) {
            item.set結果比較_被害的(結果比較有);
        } else if (認定調査被害的.compareTo(医意見書被害的) > 0) {
            item.set結果比較_被害的(結果比較無);
        }
        return item;
    }

    private IchijihanteikekkahyoEntity set結果比較4(IchijihanteikekkahyoEntity item,
            RString 厚労省IF識別コード, RString dbT5211厚労省IF識別コード, ItiziHanteiEntity itiziHanteiEntity) {
        RString 認定調査昼夜逆転 = RString.EMPTY;
        RString 医意見書昼夜逆転 = RString.EMPTY;
        if (get昼夜逆転コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5211_koroshoIfShikibetsuCode().value())) {
            認定調査昼夜逆転 = ChosaAnser16.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード();
        }
        if (get主治医昼夜逆転コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5304_remban()
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5304_koroshoIfShikibetsuCode().value())) {
            医意見書昼夜逆転 = IkenKomoku01.toValue(itiziHanteiEntity.getDbt5304_ikenItem()).getコード();
        }
        if ((ChosaAnser16.ある.getコード().equals(認定調査昼夜逆転) || ChosaAnser16.ときどきある.getコード().equals(認定調査昼夜逆転))
                && IkenKomoku01.無.getコード().equals(医意見書昼夜逆転)) {
            item.set結果比較_昼夜逆転(結果比較無);
        } else if (ChosaAnser16.ない.getコード().equals(認定調査昼夜逆転) && IkenKomoku01.有.getコード().equals(医意見書昼夜逆転)) {
            item.set結果比較_昼夜逆転(結果比較有);
        }
        RString 認定調査介護に抵抗 = RString.EMPTY;
        RString 医意見書介護に抵抗 = RString.EMPTY;
        if (get介護に抵抗コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5211_koroshoIfShikibetsuCode().value())) {
            認定調査介護に抵抗 = ChosaAnser16.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード();
        }
        if (get主治医介護に抵抗コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5304_remban()
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5304_koroshoIfShikibetsuCode().value())) {
            医意見書介護に抵抗 = IkenKomoku01.toValue(itiziHanteiEntity.getDbt5304_ikenItem()).getコード();
        }
        if (IkenKomoku01.有.getコード().equals(医意見書介護に抵抗) && ChosaAnser16.ない.getコード().equals(認定調査介護に抵抗)) {
            item.set結果比較_介護に抵抗(結果比較有);
        } else if ((ChosaAnser16.ある.getコード().equals(認定調査介護に抵抗) || ChosaAnser16.ときどきある.getコード().equals(認定調査介護に抵抗))
                && IkenKomoku01.無.getコード().equals(医意見書介護に抵抗)) {
            item.set結果比較_介護に抵抗(結果比較無);
        }
        set結果比較_日常の意思決定(item, 厚労省IF識別コード, dbT5211厚労省IF識別コード, itiziHanteiEntity);
        return item;
    }

    private IchijihanteikekkahyoEntity set結果比較_日常の意思決定(IchijihanteikekkahyoEntity item,
            RString 厚労省IF識別コード, RString dbT5211厚労省IF識別コード, ItiziHanteiEntity itiziHanteiEntity) {
        RString 認定調査日常の意思決定 = RString.EMPTY;
        RString 医意見書日常の意思決定 = RString.EMPTY;
        if (get日常の意思決定コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5211_koroshoIfShikibetsuCode().value())) {
            認定調査日常の意思決定 = ChosaAnser17.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード();
        }
        if (get主治医日常の意思決定コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5304_remban()
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5304_koroshoIfShikibetsuCode().value())) {
            医意見書日常の意思決定 = IkenKomoku05.toValue(itiziHanteiEntity.getDbt5304_ikenItem()).getコード();
        }
        if (!IkenKomoku05.記載なし.getコード().equals(医意見書日常の意思決定) && 医意見書日常の意思決定.compareTo(認定調査日常の意思決定) > 0) {
            item.set結果比較_日常の意思決定(結果比較有);
        } else if (!IkenKomoku05.記載なし.getコード().equals(医意見書日常の意思決定)
                && 認定調査日常の意思決定.compareTo(医意見書日常の意思決定) > 0) {
            item.set結果比較_日常の意思決定(結果比較無);
        } else if (!RString.isNullOrEmpty(認定調査日常の意思決定) && RString.isNullOrEmpty(医意見書日常の意思決定)) {
            item.set結果比較_日常の意思決定(結果比較_未);
        }
        return item;
    }

    private IchijihanteikekkahyoEntity set結果比較5(IchijihanteikekkahyoEntity item,
            RString 厚労省IF識別コード, RString dbT5211厚労省IF識別コード, ItiziHanteiEntity itiziHanteiEntity) {
        RString 認定調査点滴の管理 = RString.EMPTY;
        RString 医意見書点滴の管理 = RString.EMPTY;
        if (!RString.isNullOrEmpty(getコード(厚労省IF識別コード, itiziHanteiEntity.getDbt5211_remban()))
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5211_koroshoIfShikibetsuCode().value())) {
            認定調査点滴の管理 = ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード();
        }
        if (get主治医点滴の管理コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5304_remban()
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5304_koroshoIfShikibetsuCode().value())) {
            医意見書点滴の管理 = IkenKomoku01.toValue(itiziHanteiEntity.getDbt5304_ikenItem()).getコード();
        }
        if (医意見書点滴の管理.compareTo(認定調査点滴の管理) > 0) {
            item.set結果比較_点滴の管理(結果比較有);
        } else {
            item.set結果比較_点滴の管理(結果比較無);
        }
        RString 認定調査中心静脈栄養 = RString.EMPTY;
        RString 医意見書中心静脈栄養 = RString.EMPTY;
        if (!RString.isNullOrEmpty(getコード(厚労省IF識別コード, itiziHanteiEntity.getDbt5211_remban()))
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5211_koroshoIfShikibetsuCode().value())) {
            認定調査中心静脈栄養 = ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード();
        }
        if (get主治医中心静脈栄養コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5304_remban()
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5304_koroshoIfShikibetsuCode().value())) {
            医意見書中心静脈栄養 = IkenKomoku01.toValue(itiziHanteiEntity.getDbt5304_ikenItem()).getコード();
        }
        if (医意見書中心静脈栄養.compareTo(認定調査中心静脈栄養) > 0) {
            item.set結果比較_中心静脈栄養(結果比較有);
        } else {
            item.set結果比較_中心静脈栄養(結果比較無);
        }
        RString 認定調査透析 = RString.EMPTY;
        RString 医意見書透析 = RString.EMPTY;
        if (!RString.isNullOrEmpty(getコード(厚労省IF識別コード, itiziHanteiEntity.getDbt5211_remban()))
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5211_koroshoIfShikibetsuCode().value())) {
            認定調査透析 = ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード();
        }
        if (get主治医透析コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5304_remban()
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5304_koroshoIfShikibetsuCode().value())) {
            医意見書透析 = IkenKomoku01.toValue(itiziHanteiEntity.getDbt5304_ikenItem()).getコード();
        }
        if (医意見書透析.compareTo(認定調査透析) > 0) {
            item.set結果比較_透析(結果比較有);
        } else {
            item.set結果比較_透析(結果比較無);
        }
        return item;
    }

    private IchijihanteikekkahyoEntity set結果比較6(IchijihanteikekkahyoEntity item,
            RString 厚労省IF識別コード, RString dbT5211厚労省IF識別コード, ItiziHanteiEntity itiziHanteiEntity) {
        RString 認定調査ストーマの処置 = RString.EMPTY;
        RString 医意見書ストーマの処置 = RString.EMPTY;
        if (!RString.isNullOrEmpty(getコード(厚労省IF識別コード, itiziHanteiEntity.getDbt5211_remban()))
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5211_koroshoIfShikibetsuCode().value())) {
            認定調査ストーマの処置 = ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード();
        }
        if (get主治医ストーマの処置コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5304_remban()
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5304_koroshoIfShikibetsuCode().value())) {
            医意見書ストーマの処置 = IkenKomoku01.toValue(itiziHanteiEntity.getDbt5304_ikenItem()).getコード();
        }
        if (医意見書ストーマの処置.compareTo(認定調査ストーマの処置) > 0) {
            item.set結果比較_ストーマの処置(結果比較有);
        } else {
            item.set結果比較_ストーマの処置(結果比較無);
        }
        RString 認定調査酸素療法 = RString.EMPTY;
        RString 医意見書酸素療法 = RString.EMPTY;
        if (!RString.isNullOrEmpty(getコード(厚労省IF識別コード, itiziHanteiEntity.getDbt5211_remban()))
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5211_koroshoIfShikibetsuCode().value())) {
            認定調査酸素療法 = ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード();
        }
        if (get主治医酸素療法コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5304_remban()
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5304_koroshoIfShikibetsuCode().value())) {
            医意見書酸素療法 = IkenKomoku01.toValue(itiziHanteiEntity.getDbt5304_ikenItem()).getコード();
        }
        if (医意見書酸素療法.compareTo(認定調査酸素療法) > 0) {
            item.set結果比較_酸素療法(結果比較有);
        } else {
            item.set結果比較_酸素療法(結果比較無);
        }
        RString 認定調査レスピレーター = RString.EMPTY;
        RString 医意見書レスピレーター = RString.EMPTY;
        if (!RString.isNullOrEmpty(getコード(厚労省IF識別コード, itiziHanteiEntity.getDbt5211_remban()))
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5211_koroshoIfShikibetsuCode().value())) {
            認定調査レスピレーター = ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード();
        }
        if (get主治医レスピレーターコード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5304_remban()
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5304_koroshoIfShikibetsuCode().value())) {
            医意見書レスピレーター = IkenKomoku01.toValue(itiziHanteiEntity.getDbt5304_ikenItem()).getコード();
        }
        if (医意見書レスピレーター.compareTo(認定調査レスピレーター) > 0) {
            item.set結果比較_レスピレーター(結果比較有);
        } else if (認定調査レスピレーター.compareTo(医意見書レスピレーター) > 0) {
            item.set結果比較_レスピレーター(結果比較無);
        }
        return item;
    }

    private IchijihanteikekkahyoEntity set結果比較7(IchijihanteikekkahyoEntity item,
            RString 厚労省IF識別コード, RString dbT5211厚労省IF識別コード, ItiziHanteiEntity itiziHanteiEntity) {
        RString 認定調査気管切開の処置 = RString.EMPTY;
        RString 医意見書気管切開の処置 = RString.EMPTY;
        if (get気管切開の処置コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5211_koroshoIfShikibetsuCode().value())) {
            認定調査気管切開の処置 = ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード();
        }
        if (get主治医気管切開の処置コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5304_remban()
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5304_koroshoIfShikibetsuCode().value())) {
            医意見書気管切開の処置 = IkenKomoku01.toValue(itiziHanteiEntity.getDbt5304_ikenItem()).getコード();
        }
        if (医意見書気管切開の処置.compareTo(認定調査気管切開の処置) > 0) {
            item.set結果比較_気管切開の処置(結果比較有);
        } else if (認定調査気管切開の処置.compareTo(医意見書気管切開の処置) > 0) {
            item.set結果比較_気管切開の処置(結果比較無);
        }
        RString 認定調査疼痛の看護 = RString.EMPTY;
        RString 医意見書疼痛の看護 = RString.EMPTY;
        if (!RString.isNullOrEmpty(getコード(厚労省IF識別コード, itiziHanteiEntity.getDbt5211_remban()))
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5211_koroshoIfShikibetsuCode().value())) {
            認定調査疼痛の看護 = ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード();
        }
        if (get主治医疼痛の看護コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5304_remban()
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5304_koroshoIfShikibetsuCode().value())) {
            医意見書疼痛の看護 = IkenKomoku01.toValue(itiziHanteiEntity.getDbt5304_ikenItem()).getコード();
        }
        if (医意見書疼痛の看護.compareTo(認定調査疼痛の看護) > 0) {
            item.set結果比較_疼痛の看護(結果比較有);
        } else if (認定調査疼痛の看護.compareTo(医意見書疼痛の看護) > 0) {
            item.set結果比較_疼痛の看護(結果比較無);
        }
        RString 認定調査経管栄養 = RString.EMPTY;
        RString 医意見書経管栄養 = RString.EMPTY;
        if (!RString.isNullOrEmpty(getコード(厚労省IF識別コード, itiziHanteiEntity.getDbt5211_remban()))
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5211_koroshoIfShikibetsuCode().value())) {
            認定調査経管栄養 = ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード();
        }
        if (get主治医経管栄養コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5304_remban()
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5304_koroshoIfShikibetsuCode().value())) {
            医意見書経管栄養 = IkenKomoku01.toValue(itiziHanteiEntity.getDbt5304_ikenItem()).getコード();
        }
        if (医意見書経管栄養.compareTo(認定調査経管栄養) > 0) {
            item.set結果比較_経管栄養(結果比較有);
        } else if (認定調査経管栄養.compareTo(医意見書経管栄養) > 0) {
            item.set結果比較_経管栄養(結果比較無);
        }
        return item;
    }

    private IchijihanteikekkahyoEntity set結果比較8(IchijihanteikekkahyoEntity item,
            RString 厚労省IF識別コード, RString dbT5211厚労省IF識別コード, ItiziHanteiEntity itiziHanteiEntity) {
        RString 認定調査モニター測定 = RString.EMPTY;
        RString 医意見書モニター測定 = RString.EMPTY;
        if (getモニター測定コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5211_koroshoIfShikibetsuCode().value())) {
            認定調査モニター測定 = ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード();
        }
        if (get主治医モニター測定コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5304_remban()
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5304_koroshoIfShikibetsuCode().value())) {
            医意見書モニター測定 = IkenKomoku01.toValue(itiziHanteiEntity.getDbt5304_ikenItem()).getコード();
        }
        if (医意見書モニター測定.compareTo(認定調査モニター測定) > 0) {
            item.set結果比較_モニター測定(結果比較有);
        } else if (認定調査モニター測定.compareTo(医意見書モニター測定) > 0) {
            item.set結果比較_モニター測定(結果比較無);
        }
        RString 認定調査じょくそうの処置 = RString.EMPTY;
        RString 医意見書じょくそうの処置 = RString.EMPTY;
        if (getじょくそうの処置コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5211_koroshoIfShikibetsuCode().value())) {
            認定調査じょくそうの処置 = ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード();
        }
        if (get主治医じょくそうの処置コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5304_remban()
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5304_koroshoIfShikibetsuCode().value())) {
            医意見書じょくそうの処置 = IkenKomoku01.toValue(itiziHanteiEntity.getDbt5304_ikenItem()).getコード();
        }
        if (医意見書じょくそうの処置.compareTo(認定調査じょくそうの処置) > 0) {
            item.set結果比較_じょくそうの処置(結果比較有);
        } else if (認定調査じょくそうの処置.compareTo(医意見書じょくそうの処置) > 0) {
            item.set結果比較_じょくそうの処置(結果比較無);
        }

        RString 認定調査カテーテル = RString.EMPTY;
        RString 医意見書カテーテル = RString.EMPTY;
        if (getカテーテルコード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5211_koroshoIfShikibetsuCode().value())) {
            認定調査カテーテル = ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード();
        }
        if (get主治医カテーテルコード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5304_remban()
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5304_koroshoIfShikibetsuCode().value())) {
            医意見書カテーテル = IkenKomoku01.toValue(itiziHanteiEntity.getDbt5304_ikenItem()).getコード();
        }
        if (医意見書カテーテル.compareTo(認定調査カテーテル) > 0) {
            item.set結果比較_カテーテル(結果比較有);
        } else if (認定調査カテーテル.compareTo(医意見書カテーテル) > 0) {
            item.set結果比較_カテーテル(結果比較無);
        }
        return item;
    }

    private int get主治医カテーテルコード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping99A.カテーテル.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping02A.カテーテル.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping06A.カテーテル.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09A.カテーテル.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09B.カテーテル.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private int get主治医じょくそうの処置コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping99A.じょくそうの処置.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping02A.じょくそうの処置.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping06A.じょくそうの処置.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09A.じょくそうの処置.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09B.じょくそうの処置.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private int get主治医モニター測定コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping99A.モニター測定.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping02A.モニター測定.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping06A.モニター測定.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09A.モニター測定.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09B.モニター測定.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private int get主治医経管栄養コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping99A.経管栄養.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping02A.経管栄養.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping06A.経管栄養.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09A.経管栄養.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09B.経管栄養.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private int get主治医疼痛の看護コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping99A.疼痛の看護.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping02A.疼痛の看護.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping06A.疼痛の看護.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09A.疼痛の看護.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09B.疼痛の看護.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private int get主治医気管切開の処置コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping99A.気管切開の処置.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping02A.気管切開の処置.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping06A.気管切開の処置.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09A.気管切開の処置.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09B.気管切開の処置.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private int get主治医レスピレーターコード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping99A.レスピレーター.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping02A.レスピレーター.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping06A.レスピレーター.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09A.レスピレーター.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09B.レスピレーター.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private int get主治医酸素療法コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping99A.酸素療法.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping02A.酸素療法.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping06A.酸素療法.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09A.酸素療法.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09B.酸素療法.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private int get主治医ストーマの処置コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping99A.ストーマの処置.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping02A.ストーマの処置.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping06A.ストーマの処置.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09A.ストーマの処置.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09B.ストーマの処置.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private int get主治医透析コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping99A.透析.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping02A.透析.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping06A.透析.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09A.透析.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09B.透析.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private int get主治医中心静脈栄養コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping99A.中心静脈栄養.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping02A.中心静脈栄養.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping06A.中心静脈栄養.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09A.中心静脈栄養.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09B.中心静脈栄養.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private int get主治医点滴の管理コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping99A.点滴の管理.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping02A.点滴の管理.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping06A.点滴の管理.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09A.点滴の管理.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09B.点滴の管理.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private int get主治医日常の意思決定コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping99A.認知能力.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping02A.認知能力.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping06A.認知能力.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09A.認知能力.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09B.認知能力.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private int get主治医介護に抵抗コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping99A.介護への抵抗.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping02A.介護への抵抗.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping06A.介護への抵抗.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09A.介護への抵抗.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09B.介護への抵抗.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private int get主治医昼夜逆転コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping99A.昼夜逆転.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping02A.昼夜逆転.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping06A.昼夜逆転.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09A.昼夜逆転.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09B.昼夜逆転.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private int get主治医被害的コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping99A.妄想.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping02A.妄想.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping06A.妄想.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09A.妄想.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09B.妄想.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private int get主治医徘徊コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping99A.徘徊_問題行動.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping02A.徘徊_問題行動.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping06A.徘徊_可能性が高い病態.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09A.徘徊_認知症の周辺症状.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09B.徘徊_認知症の周辺症状.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private int get主治医短期記憶コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping99A.短期記憶.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping02A.短期記憶.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping06A.短期記憶.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09A.短期記憶.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09B.短期記憶.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private int get主治医意思の伝達コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping99A.伝達能力.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping02A.伝達能力.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping06A.伝達能力.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09A.伝達能力.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09B.伝達能力.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private int get主治医食事摂取コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.MAX_VALUE;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.MAX_VALUE;
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping06A.食事行為.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09A.食事行為.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09B.食事行為.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private int get主治医拘縮_肩関節コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping99A.関節の拘縮.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping02A.関節の拘縮.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping06A.関節の拘縮.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09A.関節の拘縮.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09B.関節の拘縮.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private int get主治医その他コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.MAX_VALUE;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.MAX_VALUE;
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping06A.麻痺_その他.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09A.麻痺_その他.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09B.麻痺_その他.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private int get主治医右_下肢コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.MAX_VALUE;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.MAX_VALUE;
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping06A.麻痺_右下肢.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09A.麻痺_右下肢.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09B.麻痺_右下肢.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private int get主治医左_下肢コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.MAX_VALUE;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.MAX_VALUE;
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping06A.麻痺_左下肢.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09A.麻痺_左下肢.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09B.麻痺_左下肢.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private int get主治医右_上肢コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.MAX_VALUE;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.MAX_VALUE;
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping06A.麻痺_右上肢.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09A.麻痺_右上肢.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09B.麻痺_右上肢.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private int get主治医意見書コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.MAX_VALUE;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.MAX_VALUE;
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping06A.麻痺_左上肢.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09A.麻痺_左上肢.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09B.麻痺_左上肢.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private int get昼夜逆転コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.昼夜逆転.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.昼夜逆転.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.昼夜逆転.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.昼夜逆転.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.昼夜逆転.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private int get短期記憶コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.短期記憶.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.短期記憶.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.短期記憶.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.短期記憶.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.短期記憶.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private int get意思の伝達コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.意思の伝達.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.意思の伝達.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.意思の伝達.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.意思の伝達.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.意思の伝達.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private int get介護に抵抗コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.介護に抵抗.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.介護に抵抗.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.介護に抵抗.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.介護に抵抗.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.介護に抵抗.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private int get日常の意思決定コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.MAX_VALUE;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.日常の意思決定.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.日常の意思決定.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.日常の意思決定.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.日常の意思決定.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private int get気管切開の処置コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.気管切開の処置.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.気管切開の処置.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.気管切開の処置.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.気管切開の処置.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.気管切開の処置.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private int getモニター測定コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.モニター測定.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.モニター測定.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.モニター測定.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.モニター測定.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.モニター測定.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private int getじょくそうの処置コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.じょくそうの処置.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.じょくそうの処置.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.じょくそうの処置.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.じょくそうの処置.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.じょくそうの処置.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private int getカテーテルコード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.カテーテル.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.カテーテル.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.カテーテル.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.カテーテル.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.カテーテル.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private RString getコード(RString 厚労省IF識別コード, int コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return getNinteichosaKomokuMapping99A(new RString(コード));
        } else if (A_02.equals(厚労省IF識別コード)) {
            return getNinteichosaKomokuMapping02A(new RString(コード));
        } else if (A_06.equals(厚労省IF識別コード)) {
            return getNinteichosaKomokuMapping06A(new RString(コード));
        } else if (A_09.equals(厚労省IF識別コード)) {
            return getNinteichosaKomokuMapping09A(new RString(コード));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return getNinteichosaKomokuMapping09B(new RString(コード));
        }
        return RString.EMPTY;
    }

    private RString getNinteichosaKomokuMapping99A(RString コード) {
        try {
            return NinteichosaKomokuMapping99A.toValue(コード).getコード();
        } catch (IllegalArgumentException e) {
            return RString.EMPTY;
        }
    }

    private RString getNinteichosaKomokuMapping02A(RString コード) {
        try {
            return NinteichosaKomokuMapping02A.toValue(コード).getコード();
        } catch (IllegalArgumentException e) {
            return RString.EMPTY;
        }
    }

    private RString getNinteichosaKomokuMapping06A(RString コード) {
        try {
            return NinteichosaKomokuMapping06A.toValue(コード).getコード();
        } catch (IllegalArgumentException e) {
            return RString.EMPTY;
        }
    }

    private RString getNinteichosaKomokuMapping09A(RString コード) {
        try {
            return NinteichosaKomokuMapping09A.toValue(コード).getコード();
        } catch (IllegalArgumentException e) {
            return RString.EMPTY;
        }
    }

    private RString getNinteichosaKomokuMapping09B(RString コード) {
        try {
            return NinteichosaKomokuMapping09B.toValue(コード).getコード();
        } catch (IllegalArgumentException e) {
            return RString.EMPTY;
        }
    }

    /**
     * 現在の状況の設定処理です。
     *
     * @param 連番 連番
     * @param dbt5210_厚労省IF識別コード dbt5210_厚労省IF識別コード
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 現在の状況
     */
    public RString get現在の状況(RString 連番, RString dbt5210_厚労省IF識別コード, RString 厚労省IF識別コード) {
        if (dbt5210_厚労省IF識別コード.equals(厚労省IF識別コード)) {
            if (A_99.equals(厚労省IF識別コード)) {
                return GaikyoChosahyouNiteichosahyouSisetuRiy99A.toValue(連番).get名称();
            } else if (A_02.equals(厚労省IF識別コード)) {
                return GaikyoChosahyouNiteichosahyouSisetuRiy02A.toValue(連番).get名称();
            } else if (A_06.equals(厚労省IF識別コード)) {
                return GaikyoChosahyouNiteichosahyouSisetuRiy06A.toValue(連番).get名称();
            } else if (A_09.equals(厚労省IF識別コード)) {
                return GaikyoChosahyouNiteichosahyouSisetuRiy09A.toValue(連番).get名称();
            } else if (B_09.equals(厚労省IF識別コード)) {
                return GaikyoChosahyouNiteichosahyouSisetuRiy09B.toValue(連番).get名称();
            }
        }
        return RString.EMPTY;
    }
}
