/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2240001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyochosaitem.NinteichosahyoChosaItem;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyokihonchosa.NinteichosahyoKihonChosa;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyokihonchosa.NinteichosahyoKihonChosaBuilder;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2240001.NinteiTorokuData;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping09A;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査結果取込み（OCR）のコントローラクラスです。
 *
 * @reamsid_L DBE-1540-010 dongyabin
 */
public class NinteiOcrDbT5211Handler {

    private List<RString> 調査項目;

    /**
     * 調査項目を設定します。
     *
     * @param joho NinteichosahyoKihonChosa
     * @param data NinteiTorokuData
     * @return NinteichosahyoKihonChosa
     */
    public NinteichosahyoKihonChosa set_調査項目(NinteichosahyoKihonChosa joho, NinteiTorokuData data) {
        List<NinteichosahyoChosaItem> 調査項目List = joho.getNinteichosahyoChosaItemList();
        NinteichosahyoKihonChosaBuilder builder = joho.createBuilderForEdit();
        調査項目 = new ArrayList<>();
        for (NinteichosahyoChosaItem item : 調査項目List) {
            item = set調査項目1(item, data);
            item = set調査項目2(item, data);
            item = set調査項目3(item, data);
            item = set調査項目4(item, data);
            item = set調査項目5(item, data);
            builder.setTodokedesha(item.modifiedModel());
        }
        set新規調査項目1(builder, data);
        set新規調査項目2(builder, data);
        set新規調査項目3(builder, data);
        set新規調査項目4(builder, data);
        set新規調査項目5(builder, data);
        return joho;
    }

    private NinteichosahyoChosaItem set調査項目1(NinteichosahyoChosaItem item, NinteiTorokuData data) {
        if (NinteichosaKomokuMapping09A.麻痺等_左上肢.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set調査項目(data.get麻痺_左上肢()).build();
            調査項目.add(NinteichosaKomokuMapping09A.麻痺等_左上肢.getコード());
        }
        if (NinteichosaKomokuMapping09A.麻痺等_右上肢.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set調査項目(data.get麻痺_右上肢()).build();
            調査項目.add(NinteichosaKomokuMapping09A.麻痺等_右上肢.getコード());
        }
        if (NinteichosaKomokuMapping09A.麻痺等_左下肢.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set調査項目(data.get麻痺_左下肢()).build();
            調査項目.add(NinteichosaKomokuMapping09A.麻痺等_左下肢.getコード());
        }
        if (NinteichosaKomokuMapping09A.麻痺等_右下肢.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set調査項目(data.get麻痺_右下肢()).build();
            調査項目.add(NinteichosaKomokuMapping09A.麻痺等_右下肢.getコード());
        }
        if (NinteichosaKomokuMapping09A.麻痺等_その他.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set調査項目(data.get麻痺_その他()).build();
            調査項目.add(NinteichosaKomokuMapping09A.麻痺等_その他.getコード());
        }
        if (NinteichosaKomokuMapping09A.拘縮_肩関節.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set調査項目(data.get拘縮_肩関節()).build();
            調査項目.add(NinteichosaKomokuMapping09A.拘縮_肩関節.getコード());
        }
        if (NinteichosaKomokuMapping09A.拘縮_股関節.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set調査項目(data.get拘縮_股関節()).build();
            調査項目.add(NinteichosaKomokuMapping09A.拘縮_股関節.getコード());
        }
        if (NinteichosaKomokuMapping09A.拘縮_膝関節.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set調査項目(data.get麻痺_左上肢()).build();
            調査項目.add(NinteichosaKomokuMapping09A.拘縮_膝関節.getコード());
        }
        if (NinteichosaKomokuMapping09A.拘縮_その他.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set調査項目(data.get拘縮_その他()).build();
            調査項目.add(NinteichosaKomokuMapping09A.拘縮_その他.getコード());
        }
        if (NinteichosaKomokuMapping09A.寝返り.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set調査項目(data.get寝返り()).build();
            調査項目.add(NinteichosaKomokuMapping09A.寝返り.getコード());
        }
        if (NinteichosaKomokuMapping09A.起き上がり.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set調査項目(data.get起き上がり()).build();
            調査項目.add(NinteichosaKomokuMapping09A.起き上がり.getコード());
        }
        if (NinteichosaKomokuMapping09A.座位保持.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set調査項目(data.get座位保持()).build();
            調査項目.add(NinteichosaKomokuMapping09A.座位保持.getコード());
        }
        if (NinteichosaKomokuMapping09A.両足での立位.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set調査項目(data.get両足での立位()).build();
            調査項目.add(NinteichosaKomokuMapping09A.両足での立位.getコード());
        }
        if (NinteichosaKomokuMapping09A.歩行.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set調査項目(data.get歩行()).build();
            調査項目.add(NinteichosaKomokuMapping09A.歩行.getコード());
        }
        if (NinteichosaKomokuMapping09A.立ち上がり.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set調査項目(data.get立ち上がり()).build();
            調査項目.add(NinteichosaKomokuMapping09A.立ち上がり.getコード());
        }
        if (NinteichosaKomokuMapping09A.片足での立位.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set調査項目(data.get片足での立位()).build();
            調査項目.add(NinteichosaKomokuMapping09A.片足での立位.getコード());
        }
        if (NinteichosaKomokuMapping09A.洗身.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set調査項目(data.get洗身()).build();
            調査項目.add(NinteichosaKomokuMapping09A.洗身.getコード());
        }
        return item;
    }

    private NinteichosahyoChosaItem set調査項目2(NinteichosahyoChosaItem item, NinteiTorokuData data) {
        if (NinteichosaKomokuMapping09A.聴力.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set調査項目(data.get聴力()).build();
            調査項目.add(NinteichosaKomokuMapping09A.聴力.getコード());
        }
        if (NinteichosaKomokuMapping09A.移乗.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set調査項目(data.get移乗()).build();
            調査項目.add(NinteichosaKomokuMapping09A.移乗.getコード());
        }
        if (NinteichosaKomokuMapping09A.移動.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set調査項目(data.get移動()).build();
            調査項目.add(NinteichosaKomokuMapping09A.移動.getコード());
        }
        if (NinteichosaKomokuMapping09A.えん下.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set調査項目(data.getえん下()).build();
            調査項目.add(NinteichosaKomokuMapping09A.えん下.getコード());
        }
        if (NinteichosaKomokuMapping09A.食事摂取.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set調査項目(data.get食事摂取()).build();
            調査項目.add(NinteichosaKomokuMapping09A.食事摂取.getコード());
        }
        if (NinteichosaKomokuMapping09A.排尿.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set調査項目(data.get排尿()).build();
            調査項目.add(NinteichosaKomokuMapping09A.排尿.getコード());
        }
        if (NinteichosaKomokuMapping09A.排便.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set調査項目(data.get排便()).build();
            調査項目.add(NinteichosaKomokuMapping09A.排便.getコード());
        }
        if (NinteichosaKomokuMapping09A.口腔清潔.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set調査項目(data.get口腔清潔()).build();
            調査項目.add(NinteichosaKomokuMapping09A.口腔清潔.getコード());
        }
        if (NinteichosaKomokuMapping09A.洗顔.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set調査項目(data.get洗顔()).build();
            調査項目.add(NinteichosaKomokuMapping09A.洗顔.getコード());
        }
        if (NinteichosaKomokuMapping09A.整髪.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set調査項目(data.get整髪()).build();
            調査項目.add(NinteichosaKomokuMapping09A.整髪.getコード());
        }
        if (NinteichosaKomokuMapping09A.上衣の着脱.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set調査項目(data.get上衣の着脱()).build();
            調査項目.add(NinteichosaKomokuMapping09A.上衣の着脱.getコード());
        }
        if (NinteichosaKomokuMapping09A.ズボン等の着脱.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set調査項目(data.getズボン等の着脱()).build();
            調査項目.add(NinteichosaKomokuMapping09A.ズボン等の着脱.getコード());
        }
        if (NinteichosaKomokuMapping09A.外出頻度.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set調査項目(data.get外出頻度()).build();
            調査項目.add(NinteichosaKomokuMapping09A.外出頻度.getコード());
        }
        if (NinteichosaKomokuMapping09A.意思の伝達.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set調査項目(data.get意思の疎通()).build();
            調査項目.add(NinteichosaKomokuMapping09A.意思の伝達.getコード());
        }
        if (NinteichosaKomokuMapping09A.毎日の日課を理解.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set調査項目(data.get毎日の日課を理解()).build();
            調査項目.add(NinteichosaKomokuMapping09A.毎日の日課を理解.getコード());
        }
        if (NinteichosaKomokuMapping09A.生年月日をいう.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set調査項目(data.get生年月日をいう()).build();
            調査項目.add(NinteichosaKomokuMapping09A.生年月日をいう.getコード());
        }
        if (NinteichosaKomokuMapping09A.短期記憶.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set調査項目(data.get短期記憶()).build();
            調査項目.add(NinteichosaKomokuMapping09A.短期記憶.getコード());
        }
        if (NinteichosaKomokuMapping09A.自分の名前をいう.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set調査項目(data.get自分の名前をいう()).build();
            調査項目.add(NinteichosaKomokuMapping09A.自分の名前をいう.getコード());
        }
        return item;
    }

    private NinteichosahyoChosaItem set調査項目3(NinteichosahyoChosaItem item, NinteiTorokuData data) {
        if (NinteichosaKomokuMapping09A.常時の徘徊.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set調査項目(data.get徘徊()).build();
            調査項目.add(NinteichosaKomokuMapping09A.常時の徘徊.getコード());
        }
        if (NinteichosaKomokuMapping09A.外出して戻れない.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set調査項目(data.get外出して戻れない()).build();
            調査項目.add(NinteichosaKomokuMapping09A.外出して戻れない.getコード());
        }
        if (NinteichosaKomokuMapping09A.被害的.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set調査項目(data.get被害的()).build();
            調査項目.add(NinteichosaKomokuMapping09A.被害的.getコード());
        }
        if (NinteichosaKomokuMapping09A.作話.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set調査項目(data.get作話()).build();
            調査項目.add(NinteichosaKomokuMapping09A.作話.getコード());
        }
        if (NinteichosaKomokuMapping09A.感情が不安定.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set調査項目(data.get感情が不安定()).build();
            調査項目.add(NinteichosaKomokuMapping09A.感情が不安定.getコード());
        }
        if (NinteichosaKomokuMapping09A.昼夜逆転.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set調査項目(data.get昼夜逆転()).build();
            調査項目.add(NinteichosaKomokuMapping09A.昼夜逆転.getコード());
        }
        if (NinteichosaKomokuMapping09A.同じ話をする.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set調査項目(data.get同じ話をする()).build();
            調査項目.add(NinteichosaKomokuMapping09A.同じ話をする.getコード());
        }
        if (NinteichosaKomokuMapping09A.大声を出す.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set調査項目(data.get大声を出す()).build();
            調査項目.add(NinteichosaKomokuMapping09A.大声を出す.getコード());
        }
        if (NinteichosaKomokuMapping09A.介護に抵抗.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set調査項目(data.get介護に抵抗()).build();
            調査項目.add(NinteichosaKomokuMapping09A.介護に抵抗.getコード());
        }
        if (NinteichosaKomokuMapping09A.落ち着きなし.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set調査項目(data.get落ち着きなし()).build();
            調査項目.add(NinteichosaKomokuMapping09A.落ち着きなし.getコード());
        }
        if (NinteichosaKomokuMapping09A.一人で出たがる.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set調査項目(data.get一人で出たがる()).build();
            調査項目.add(NinteichosaKomokuMapping09A.一人で出たがる.getコード());
        }
        if (NinteichosaKomokuMapping09A.収集癖.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set調査項目(data.get収集癖()).build();
            調査項目.add(NinteichosaKomokuMapping09A.収集癖.getコード());
        }
        if (NinteichosaKomokuMapping09A.物や衣類を壊す.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set調査項目(data.get物や衣類を壊す()).build();
            調査項目.add(NinteichosaKomokuMapping09A.物や衣類を壊す.getコード());
        }
        if (NinteichosaKomokuMapping09A.ひどい物忘れ.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set調査項目(data.getひどい物忘れ()).build();
            調査項目.add(NinteichosaKomokuMapping09A.ひどい物忘れ.getコード());
        }
        if (NinteichosaKomokuMapping09A.独り言_独り笑い.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set調査項目(data.get独り言_独り笑い()).build();
            調査項目.add(NinteichosaKomokuMapping09A.独り言_独り笑い.getコード());
        }
        if (NinteichosaKomokuMapping09A.自分勝手に行動する.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set調査項目(data.get自分勝手に行動する()).build();
            調査項目.add(NinteichosaKomokuMapping09A.自分勝手に行動する.getコード());
        }
        if (NinteichosaKomokuMapping09A.話がまとまらない.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set調査項目(data.get話がまとまらない()).build();
            調査項目.add(NinteichosaKomokuMapping09A.話がまとまらない.getコード());
        }
        if (NinteichosaKomokuMapping09A.薬の内服.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set調査項目(data.get薬の内服()).build();
            調査項目.add(NinteichosaKomokuMapping09A.薬の内服.getコード());
        }
        return item;
    }

    private NinteichosahyoChosaItem set調査項目4(NinteichosahyoChosaItem item, NinteiTorokuData data) {
        if (NinteichosaKomokuMapping09A.今の季節を理解.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set調査項目(data.get今の季節を理解()).build();
            調査項目.add(NinteichosaKomokuMapping09A.今の季節を理解.getコード());
        }
        if (NinteichosaKomokuMapping09A.場所の理解.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set調査項目(data.get場所の理解()).build();
            調査項目.add(NinteichosaKomokuMapping09A.場所の理解.getコード());
        }
        if (NinteichosaKomokuMapping09A.金銭の管理.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set調査項目(data.get金銭の管理()).build();
            調査項目.add(NinteichosaKomokuMapping09A.金銭の管理.getコード());
        }
        if (NinteichosaKomokuMapping09A.日常の意思決定.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set調査項目(data.get日常の意思決定()).build();
            調査項目.add(NinteichosaKomokuMapping09A.日常の意思決定.getコード());
        }
        if (NinteichosaKomokuMapping09A.つめ切り.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set調査項目(data.getつめ切り()).build();
            調査項目.add(NinteichosaKomokuMapping09A.つめ切り.getコード());
        }
        if (NinteichosaKomokuMapping09A.視力.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set調査項目(data.get視力()).build();
            調査項目.add(NinteichosaKomokuMapping09A.視力.getコード());
        }
        if (NinteichosaKomokuMapping09A.集団への不適応.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set調査項目(data.get集団への不適応()).build();
            調査項目.add(NinteichosaKomokuMapping09A.集団への不適応.getコード());
        }
        if (NinteichosaKomokuMapping09A.買い物.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set調査項目(data.get買い物()).build();
            調査項目.add(NinteichosaKomokuMapping09A.買い物.getコード());
        }
        if (NinteichosaKomokuMapping09A.簡単な調理.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set調査項目(data.get簡単な調理()).build();
            調査項目.add(NinteichosaKomokuMapping09A.簡単な調理.getコード());
        }
        if (NinteichosaKomokuMapping09A.点滴の管理.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set調査項目(data.get過去14日間に受けた治療_点滴の管理()).build();
            調査項目.add(NinteichosaKomokuMapping09A.点滴の管理.getコード());
        }
        if (NinteichosaKomokuMapping09A.透析.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set調査項目(data.get過去14日間に受けた治療_透折()).build();
            調査項目.add(NinteichosaKomokuMapping09A.透析.getコード());
        }
        if (NinteichosaKomokuMapping09A.ストーマの処置.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set調査項目(data.get過去14日間に受けた治療_ストーマの処理()).build();
            調査項目.add(NinteichosaKomokuMapping09A.ストーマの処置.getコード());
        }
        if (NinteichosaKomokuMapping09A.酸素療法.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set調査項目(data.get過去14日間に受けた治療_酸素療法()).build();
            調査項目.add(NinteichosaKomokuMapping09A.酸素療法.getコード());
        }
        if (NinteichosaKomokuMapping09A.レスピレーター.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set調査項目(data.get過去14日間に受けた治療_レスピレーター()).build();
            調査項目.add(NinteichosaKomokuMapping09A.レスピレーター.getコード());
        }
        if (NinteichosaKomokuMapping09A.気管切開の処置.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set調査項目(data.get過去14日間に受けた治療_気管切開の処理()).build();
            調査項目.add(NinteichosaKomokuMapping09A.気管切開の処置.getコード());
        }
        if (NinteichosaKomokuMapping09A.疼痛の看護.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set調査項目(data.get過去14日間に受けた治療_疼痛()).build();
            調査項目.add(NinteichosaKomokuMapping09A.疼痛の看護.getコード());
        }
        if (NinteichosaKomokuMapping09A.経管栄養.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set調査項目(data.get過去14日間に受けた治療_経管栄養()).build();
            調査項目.add(NinteichosaKomokuMapping09A.経管栄養.getコード());
        }
        if (NinteichosaKomokuMapping09A.モニター測定.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set調査項目(data.get過去14日間に受けた治療_モニター測定()).build();
            調査項目.add(NinteichosaKomokuMapping09A.モニター測定.getコード());
        }
        return item;
    }

    private NinteichosahyoChosaItem set調査項目5(NinteichosahyoChosaItem item, NinteiTorokuData data) {
        if (NinteichosaKomokuMapping09A.じょくそうの処置.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set調査項目(data.get過去14日間に受けた治療_じょくそうの処置()).build();
            調査項目.add(NinteichosaKomokuMapping09A.じょくそうの処置.getコード());
        }
        if (NinteichosaKomokuMapping09A.カテーテル.getコード().equals(new RString(item.get連番()))) {
            item = item.createBuilderForEdit().set調査項目(data.get過去14日間に受けた治療_カテーテル()).build();
            調査項目.add(NinteichosaKomokuMapping09A.カテーテル.getコード());
        }
        return item;
    }

    private void set新規調査項目1(NinteichosahyoKihonChosaBuilder builder, NinteiTorokuData data) {
        if (!調査項目.contains(NinteichosaKomokuMapping09A.麻痺等_左上肢.getコード())) {
            NinteichosahyoChosaItem item = new NinteichosahyoChosaItem(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    rStringToInt(NinteichosaKomokuMapping09A.麻痺等_左上肢.getコード()));
            item = item.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            item = item.createBuilderForEdit().set調査項目(data.get麻痺_左上肢()).build();
            builder.setTodokedesha(item);
        }
        if (!調査項目.contains(NinteichosaKomokuMapping09A.麻痺等_右上肢.getコード())) {
            NinteichosahyoChosaItem item = new NinteichosahyoChosaItem(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    rStringToInt(NinteichosaKomokuMapping09A.麻痺等_右上肢.getコード()));
            item = item.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            item = item.createBuilderForEdit().set調査項目(data.get麻痺_右上肢()).build();
            builder.setTodokedesha(item);
        }
        if (!調査項目.contains(NinteichosaKomokuMapping09A.麻痺等_左下肢.getコード())) {
            NinteichosahyoChosaItem item = new NinteichosahyoChosaItem(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    rStringToInt(NinteichosaKomokuMapping09A.麻痺等_左下肢.getコード()));
            item = item.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            item = item.createBuilderForEdit().set調査項目(data.get麻痺_左下肢()).build();
            builder.setTodokedesha(item);
        }
        if (!調査項目.contains(NinteichosaKomokuMapping09A.麻痺等_右下肢.getコード())) {
            NinteichosahyoChosaItem item = new NinteichosahyoChosaItem(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    rStringToInt(NinteichosaKomokuMapping09A.麻痺等_右下肢.getコード()));
            item = item.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            item = item.createBuilderForEdit().set調査項目(data.get麻痺_右下肢()).build();
            builder.setTodokedesha(item);
        }
        if (!調査項目.contains(NinteichosaKomokuMapping09A.麻痺等_その他.getコード())) {
            NinteichosahyoChosaItem item = new NinteichosahyoChosaItem(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    rStringToInt(NinteichosaKomokuMapping09A.麻痺等_その他.getコード()));
            item = item.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            item = item.createBuilderForEdit().set調査項目(data.get麻痺_その他()).build();
            builder.setTodokedesha(item);
        }
        if (!調査項目.contains(NinteichosaKomokuMapping09A.拘縮_肩関節.getコード())) {
            NinteichosahyoChosaItem item = new NinteichosahyoChosaItem(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    rStringToInt(NinteichosaKomokuMapping09A.拘縮_肩関節.getコード()));
            item = item.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            item = item.createBuilderForEdit().set調査項目(data.get拘縮_肩関節()).build();
            builder.setTodokedesha(item);
        }
        if (!調査項目.contains(NinteichosaKomokuMapping09A.拘縮_股関節.getコード())) {
            NinteichosahyoChosaItem item = new NinteichosahyoChosaItem(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    rStringToInt(NinteichosaKomokuMapping09A.拘縮_股関節.getコード()));
            item = item.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            item = item.createBuilderForEdit().set調査項目(data.get拘縮_股関節()).build();
            builder.setTodokedesha(item);
        }
        if (!調査項目.contains(NinteichosaKomokuMapping09A.拘縮_膝関節.getコード())) {
            NinteichosahyoChosaItem item = new NinteichosahyoChosaItem(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    rStringToInt(NinteichosaKomokuMapping09A.拘縮_膝関節.getコード()));
            item = item.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            item = item.createBuilderForEdit().set調査項目(data.get拘縮_膝関節()).build();
            builder.setTodokedesha(item);
        }
        if (!調査項目.contains(NinteichosaKomokuMapping09A.拘縮_その他.getコード())) {
            NinteichosahyoChosaItem item = new NinteichosahyoChosaItem(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    rStringToInt(NinteichosaKomokuMapping09A.拘縮_その他.getコード()));
            item = item.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            item = item.createBuilderForEdit().set調査項目(data.get拘縮_その他()).build();
            builder.setTodokedesha(item);
        }
        if (!調査項目.contains(NinteichosaKomokuMapping09A.寝返り.getコード())) {
            NinteichosahyoChosaItem item = new NinteichosahyoChosaItem(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    rStringToInt(NinteichosaKomokuMapping09A.寝返り.getコード()));
            item = item.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            item = item.createBuilderForEdit().set調査項目(data.get寝返り()).build();
            builder.setTodokedesha(item);
        }
        if (!調査項目.contains(NinteichosaKomokuMapping09A.起き上がり.getコード())) {
            NinteichosahyoChosaItem item = new NinteichosahyoChosaItem(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    rStringToInt(NinteichosaKomokuMapping09A.起き上がり.getコード()));
            item = item.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            item = item.createBuilderForEdit().set調査項目(data.get起き上がり()).build();
            builder.setTodokedesha(item);
        }
        if (!調査項目.contains(NinteichosaKomokuMapping09A.座位保持.getコード())) {
            NinteichosahyoChosaItem item = new NinteichosahyoChosaItem(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    rStringToInt(NinteichosaKomokuMapping09A.座位保持.getコード()));
            item = item.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            item = item.createBuilderForEdit().set調査項目(data.get座位保持()).build();
            builder.setTodokedesha(item);
        }
        if (!調査項目.contains(NinteichosaKomokuMapping09A.両足での立位.getコード())) {
            NinteichosahyoChosaItem item = new NinteichosahyoChosaItem(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    rStringToInt(NinteichosaKomokuMapping09A.両足での立位.getコード()));
            item = item.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            item = item.createBuilderForEdit().set調査項目(data.get両足での立位()).build();
            builder.setTodokedesha(item);
        }
        if (!調査項目.contains(NinteichosaKomokuMapping09A.歩行.getコード())) {
            NinteichosahyoChosaItem item = new NinteichosahyoChosaItem(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    rStringToInt(NinteichosaKomokuMapping09A.歩行.getコード()));
            item = item.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            item = item.createBuilderForEdit().set調査項目(data.get歩行()).build();
            builder.setTodokedesha(item);
        }
        if (!調査項目.contains(NinteichosaKomokuMapping09A.立ち上がり.getコード())) {
            NinteichosahyoChosaItem item = new NinteichosahyoChosaItem(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    rStringToInt(NinteichosaKomokuMapping09A.立ち上がり.getコード()));
            item = item.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            item = item.createBuilderForEdit().set調査項目(data.get立ち上がり()).build();
            builder.setTodokedesha(item);
        }
        if (!調査項目.contains(NinteichosaKomokuMapping09A.片足での立位.getコード())) {
            NinteichosahyoChosaItem item = new NinteichosahyoChosaItem(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    rStringToInt(NinteichosaKomokuMapping09A.片足での立位.getコード()));
            item = item.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            item = item.createBuilderForEdit().set調査項目(data.get片足での立位()).build();
            builder.setTodokedesha(item);
        }
        if (!調査項目.contains(NinteichosaKomokuMapping09A.洗身.getコード())) {
            NinteichosahyoChosaItem item = new NinteichosahyoChosaItem(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    rStringToInt(NinteichosaKomokuMapping09A.洗身.getコード()));
            item = item.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            item = item.createBuilderForEdit().set調査項目(data.get洗身()).build();
            builder.setTodokedesha(item);
        }
    }

    private void set新規調査項目2(NinteichosahyoKihonChosaBuilder builder, NinteiTorokuData data) {
        if (!調査項目.contains(NinteichosaKomokuMapping09A.聴力.getコード())) {
            NinteichosahyoChosaItem item = new NinteichosahyoChosaItem(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    rStringToInt(NinteichosaKomokuMapping09A.聴力.getコード()));
            item = item.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            item = item.createBuilderForEdit().set調査項目(data.get聴力()).build();
            builder.setTodokedesha(item);
        }
        if (!調査項目.contains(NinteichosaKomokuMapping09A.移乗.getコード())) {
            NinteichosahyoChosaItem item = new NinteichosahyoChosaItem(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    rStringToInt(NinteichosaKomokuMapping09A.移乗.getコード()));
            item = item.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            item = item.createBuilderForEdit().set調査項目(data.get移乗()).build();
            builder.setTodokedesha(item);
        }
        if (!調査項目.contains(NinteichosaKomokuMapping09A.移動.getコード())) {
            NinteichosahyoChosaItem item = new NinteichosahyoChosaItem(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    rStringToInt(NinteichosaKomokuMapping09A.移動.getコード()));
            item = item.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            item = item.createBuilderForEdit().set調査項目(data.get移動()).build();
            builder.setTodokedesha(item);
        }
        if (!調査項目.contains(NinteichosaKomokuMapping09A.えん下.getコード())) {
            NinteichosahyoChosaItem item = new NinteichosahyoChosaItem(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    rStringToInt(NinteichosaKomokuMapping09A.えん下.getコード()));
            item = item.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            item = item.createBuilderForEdit().set調査項目(data.getえん下()).build();
            builder.setTodokedesha(item);
        }
        if (!調査項目.contains(NinteichosaKomokuMapping09A.食事摂取.getコード())) {
            NinteichosahyoChosaItem item = new NinteichosahyoChosaItem(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    rStringToInt(NinteichosaKomokuMapping09A.食事摂取.getコード()));
            item = item.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            item = item.createBuilderForEdit().set調査項目(data.get食事摂取()).build();
            builder.setTodokedesha(item);
        }
        if (!調査項目.contains(NinteichosaKomokuMapping09A.排尿.getコード())) {
            NinteichosahyoChosaItem item = new NinteichosahyoChosaItem(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    rStringToInt(NinteichosaKomokuMapping09A.排尿.getコード()));
            item = item.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            item = item.createBuilderForEdit().set調査項目(data.get排尿()).build();
            builder.setTodokedesha(item);
        }
        if (!調査項目.contains(NinteichosaKomokuMapping09A.排便.getコード())) {
            NinteichosahyoChosaItem item = new NinteichosahyoChosaItem(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    rStringToInt(NinteichosaKomokuMapping09A.排便.getコード()));
            item = item.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            item = item.createBuilderForEdit().set調査項目(data.get排便()).build();
            builder.setTodokedesha(item);
        }
        if (!調査項目.contains(NinteichosaKomokuMapping09A.口腔清潔.getコード())) {
            NinteichosahyoChosaItem item = new NinteichosahyoChosaItem(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    rStringToInt(NinteichosaKomokuMapping09A.口腔清潔.getコード()));
            item = item.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            item = item.createBuilderForEdit().set調査項目(data.get口腔清潔()).build();
            builder.setTodokedesha(item);
        }
        if (!調査項目.contains(NinteichosaKomokuMapping09A.洗顔.getコード())) {
            NinteichosahyoChosaItem item = new NinteichosahyoChosaItem(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    rStringToInt(NinteichosaKomokuMapping09A.洗顔.getコード()));
            item = item.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            item = item.createBuilderForEdit().set調査項目(data.get洗顔()).build();
            builder.setTodokedesha(item);
        }
        if (!調査項目.contains(NinteichosaKomokuMapping09A.整髪.getコード())) {
            NinteichosahyoChosaItem item = new NinteichosahyoChosaItem(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    rStringToInt(NinteichosaKomokuMapping09A.整髪.getコード()));
            item = item.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            item = item.createBuilderForEdit().set調査項目(data.get整髪()).build();
            builder.setTodokedesha(item);
        }
        if (!調査項目.contains(NinteichosaKomokuMapping09A.上衣の着脱.getコード())) {
            NinteichosahyoChosaItem item = new NinteichosahyoChosaItem(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    rStringToInt(NinteichosaKomokuMapping09A.上衣の着脱.getコード()));
            item = item.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            item = item.createBuilderForEdit().set調査項目(data.get上衣の着脱()).build();
            builder.setTodokedesha(item);
        }
        if (!調査項目.contains(NinteichosaKomokuMapping09A.ズボン等の着脱.getコード())) {
            NinteichosahyoChosaItem item = new NinteichosahyoChosaItem(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    rStringToInt(NinteichosaKomokuMapping09A.ズボン等の着脱.getコード()));
            item = item.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            item = item.createBuilderForEdit().set調査項目(data.getズボン等の着脱()).build();
            builder.setTodokedesha(item);
        }
        if (!調査項目.contains(NinteichosaKomokuMapping09A.外出頻度.getコード())) {
            NinteichosahyoChosaItem item = new NinteichosahyoChosaItem(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    rStringToInt(NinteichosaKomokuMapping09A.外出頻度.getコード()));
            item = item.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            item = item.createBuilderForEdit().set調査項目(data.get外出頻度()).build();
            builder.setTodokedesha(item);
        }
        if (!調査項目.contains(NinteichosaKomokuMapping09A.意思の伝達.getコード())) {
            NinteichosahyoChosaItem item = new NinteichosahyoChosaItem(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    rStringToInt(NinteichosaKomokuMapping09A.意思の伝達.getコード()));
            item = item.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            item = item.createBuilderForEdit().set調査項目(data.get意思の疎通()).build();
            builder.setTodokedesha(item);
        }
        if (!調査項目.contains(NinteichosaKomokuMapping09A.毎日の日課を理解.getコード())) {
            NinteichosahyoChosaItem item = new NinteichosahyoChosaItem(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    rStringToInt(NinteichosaKomokuMapping09A.毎日の日課を理解.getコード()));
            item = item.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            item = item.createBuilderForEdit().set調査項目(data.get毎日の日課を理解()).build();
            builder.setTodokedesha(item);
        }
        if (!調査項目.contains(NinteichosaKomokuMapping09A.生年月日をいう.getコード())) {
            NinteichosahyoChosaItem item = new NinteichosahyoChosaItem(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    rStringToInt(NinteichosaKomokuMapping09A.生年月日をいう.getコード()));
            item = item.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            item = item.createBuilderForEdit().set調査項目(data.get生年月日をいう()).build();
            builder.setTodokedesha(item);
        }
        if (!調査項目.contains(NinteichosaKomokuMapping09A.短期記憶.getコード())) {
            NinteichosahyoChosaItem item = new NinteichosahyoChosaItem(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    rStringToInt(NinteichosaKomokuMapping09A.短期記憶.getコード()));
            item = item.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            item = item.createBuilderForEdit().set調査項目(data.get短期記憶()).build();
            builder.setTodokedesha(item);
        }
        if (!調査項目.contains(NinteichosaKomokuMapping09A.自分の名前をいう.getコード())) {
            NinteichosahyoChosaItem item = new NinteichosahyoChosaItem(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    rStringToInt(NinteichosaKomokuMapping09A.自分の名前をいう.getコード()));
            item = item.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            item = item.createBuilderForEdit().set調査項目(data.get自分の名前をいう()).build();
            builder.setTodokedesha(item);
        }
    }

    private void set新規調査項目3(NinteichosahyoKihonChosaBuilder builder, NinteiTorokuData data) {
        if (!調査項目.contains(NinteichosaKomokuMapping09A.常時の徘徊.getコード())) {
            NinteichosahyoChosaItem item = new NinteichosahyoChosaItem(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    rStringToInt(NinteichosaKomokuMapping09A.常時の徘徊.getコード()));
            item = item.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            item = item.createBuilderForEdit().set調査項目(data.get徘徊()).build();
            builder.setTodokedesha(item);
        }
        if (!調査項目.contains(NinteichosaKomokuMapping09A.外出して戻れない.getコード())) {
            NinteichosahyoChosaItem item = new NinteichosahyoChosaItem(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    rStringToInt(NinteichosaKomokuMapping09A.外出して戻れない.getコード()));
            item = item.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            item = item.createBuilderForEdit().set調査項目(data.get外出して戻れない()).build();
            builder.setTodokedesha(item);
        }
        if (!調査項目.contains(NinteichosaKomokuMapping09A.被害的.getコード())) {
            NinteichosahyoChosaItem item = new NinteichosahyoChosaItem(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    rStringToInt(NinteichosaKomokuMapping09A.被害的.getコード()));
            item = item.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            item = item.createBuilderForEdit().set調査項目(data.get被害的()).build();
            builder.setTodokedesha(item);
        }
        if (!調査項目.contains(NinteichosaKomokuMapping09A.作話.getコード())) {
            NinteichosahyoChosaItem item = new NinteichosahyoChosaItem(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    rStringToInt(NinteichosaKomokuMapping09A.作話.getコード()));
            item = item.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            item = item.createBuilderForEdit().set調査項目(data.get作話()).build();
            builder.setTodokedesha(item);
        }
        if (!調査項目.contains(NinteichosaKomokuMapping09A.感情が不安定.getコード())) {
            NinteichosahyoChosaItem item = new NinteichosahyoChosaItem(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    rStringToInt(NinteichosaKomokuMapping09A.感情が不安定.getコード()));
            item = item.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            item = item.createBuilderForEdit().set調査項目(data.get感情が不安定()).build();
            builder.setTodokedesha(item);
        }
        if (!調査項目.contains(NinteichosaKomokuMapping09A.昼夜逆転.getコード())) {
            NinteichosahyoChosaItem item = new NinteichosahyoChosaItem(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    rStringToInt(NinteichosaKomokuMapping09A.昼夜逆転.getコード()));
            item = item.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            item = item.createBuilderForEdit().set調査項目(data.get昼夜逆転()).build();
            builder.setTodokedesha(item);
        }
        if (!調査項目.contains(NinteichosaKomokuMapping09A.同じ話をする.getコード())) {
            NinteichosahyoChosaItem item = new NinteichosahyoChosaItem(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    rStringToInt(NinteichosaKomokuMapping09A.同じ話をする.getコード()));
            item = item.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            item = item.createBuilderForEdit().set調査項目(data.get同じ話をする()).build();
            builder.setTodokedesha(item);
        }
        if (!調査項目.contains(NinteichosaKomokuMapping09A.大声を出す.getコード())) {
            NinteichosahyoChosaItem item = new NinteichosahyoChosaItem(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    rStringToInt(NinteichosaKomokuMapping09A.大声を出す.getコード()));
            item = item.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            item = item.createBuilderForEdit().set調査項目(data.get大声を出す()).build();
            builder.setTodokedesha(item);
        }
        if (!調査項目.contains(NinteichosaKomokuMapping09A.介護に抵抗.getコード())) {
            NinteichosahyoChosaItem item = new NinteichosahyoChosaItem(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    rStringToInt(NinteichosaKomokuMapping09A.介護に抵抗.getコード()));
            item = item.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            item = item.createBuilderForEdit().set調査項目(data.get介護に抵抗()).build();
            builder.setTodokedesha(item);
        }
        if (!調査項目.contains(NinteichosaKomokuMapping09A.落ち着きなし.getコード())) {
            NinteichosahyoChosaItem item = new NinteichosahyoChosaItem(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    rStringToInt(NinteichosaKomokuMapping09A.落ち着きなし.getコード()));
            item = item.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            item = item.createBuilderForEdit().set調査項目(data.get落ち着きなし()).build();
            builder.setTodokedesha(item);
        }
        if (!調査項目.contains(NinteichosaKomokuMapping09A.一人で出たがる.getコード())) {
            NinteichosahyoChosaItem item = new NinteichosahyoChosaItem(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    rStringToInt(NinteichosaKomokuMapping09A.一人で出たがる.getコード()));
            item = item.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            item = item.createBuilderForEdit().set調査項目(data.get一人で出たがる()).build();
            builder.setTodokedesha(item);
        }
        if (!調査項目.contains(NinteichosaKomokuMapping09A.収集癖.getコード())) {
            NinteichosahyoChosaItem item = new NinteichosahyoChosaItem(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    rStringToInt(NinteichosaKomokuMapping09A.収集癖.getコード()));
            item = item.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            item = item.createBuilderForEdit().set調査項目(data.get収集癖()).build();
            builder.setTodokedesha(item);
        }
        if (!調査項目.contains(NinteichosaKomokuMapping09A.物や衣類を壊す.getコード())) {
            NinteichosahyoChosaItem item = new NinteichosahyoChosaItem(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    rStringToInt(NinteichosaKomokuMapping09A.物や衣類を壊す.getコード()));
            item = item.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            item = item.createBuilderForEdit().set調査項目(data.get物や衣類を壊す()).build();
            builder.setTodokedesha(item);
        }
        if (!調査項目.contains(NinteichosaKomokuMapping09A.ひどい物忘れ.getコード())) {
            NinteichosahyoChosaItem item = new NinteichosahyoChosaItem(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    rStringToInt(NinteichosaKomokuMapping09A.ひどい物忘れ.getコード()));
            item = item.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            item = item.createBuilderForEdit().set調査項目(data.getひどい物忘れ()).build();
            builder.setTodokedesha(item);
        }
        if (!調査項目.contains(NinteichosaKomokuMapping09A.独り言_独り笑い.getコード())) {
            NinteichosahyoChosaItem item = new NinteichosahyoChosaItem(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    rStringToInt(NinteichosaKomokuMapping09A.独り言_独り笑い.getコード()));
            item = item.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            item = item.createBuilderForEdit().set調査項目(data.get独り言_独り笑い()).build();
            builder.setTodokedesha(item);
        }
        if (!調査項目.contains(NinteichosaKomokuMapping09A.自分勝手に行動する.getコード())) {
            NinteichosahyoChosaItem item = new NinteichosahyoChosaItem(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    rStringToInt(NinteichosaKomokuMapping09A.自分勝手に行動する.getコード()));
            item = item.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            item = item.createBuilderForEdit().set調査項目(data.get自分勝手に行動する()).build();
            builder.setTodokedesha(item);
        }
        if (!調査項目.contains(NinteichosaKomokuMapping09A.話がまとまらない.getコード())) {
            NinteichosahyoChosaItem item = new NinteichosahyoChosaItem(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    rStringToInt(NinteichosaKomokuMapping09A.話がまとまらない.getコード()));
            item = item.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            item = item.createBuilderForEdit().set調査項目(data.get話がまとまらない()).build();
            builder.setTodokedesha(item);
        }
        if (!調査項目.contains(NinteichosaKomokuMapping09A.薬の内服.getコード())) {
            NinteichosahyoChosaItem item = new NinteichosahyoChosaItem(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    rStringToInt(NinteichosaKomokuMapping09A.薬の内服.getコード()));
            item = item.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            item = item.createBuilderForEdit().set調査項目(data.get薬の内服()).build();
            builder.setTodokedesha(item);
        }
    }

    private void set新規調査項目4(NinteichosahyoKihonChosaBuilder builder, NinteiTorokuData data) {
        if (!調査項目.contains(NinteichosaKomokuMapping09A.今の季節を理解.getコード())) {
            NinteichosahyoChosaItem item = new NinteichosahyoChosaItem(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    rStringToInt(NinteichosaKomokuMapping09A.今の季節を理解.getコード()));
            item = item.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            item = item.createBuilderForEdit().set調査項目(data.get今の季節を理解()).build();
            builder.setTodokedesha(item);
        }
        if (!調査項目.contains(NinteichosaKomokuMapping09A.場所の理解.getコード())) {
            NinteichosahyoChosaItem item = new NinteichosahyoChosaItem(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    rStringToInt(NinteichosaKomokuMapping09A.場所の理解.getコード()));
            item = item.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            item = item.createBuilderForEdit().set調査項目(data.get場所の理解()).build();
            builder.setTodokedesha(item);
        }
        if (!調査項目.contains(NinteichosaKomokuMapping09A.金銭の管理.getコード())) {
            NinteichosahyoChosaItem item = new NinteichosahyoChosaItem(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    rStringToInt(NinteichosaKomokuMapping09A.金銭の管理.getコード()));
            item = item.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            item = item.createBuilderForEdit().set調査項目(data.get金銭の管理()).build();
            builder.setTodokedesha(item);
        }
        if (!調査項目.contains(NinteichosaKomokuMapping09A.日常の意思決定.getコード())) {
            NinteichosahyoChosaItem item = new NinteichosahyoChosaItem(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    rStringToInt(NinteichosaKomokuMapping09A.日常の意思決定.getコード()));
            item = item.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            item = item.createBuilderForEdit().set調査項目(data.get日常の意思決定()).build();
            builder.setTodokedesha(item);
        }
        if (!調査項目.contains(NinteichosaKomokuMapping09A.つめ切り.getコード())) {
            NinteichosahyoChosaItem item = new NinteichosahyoChosaItem(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    rStringToInt(NinteichosaKomokuMapping09A.つめ切り.getコード()));
            item = item.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            item = item.createBuilderForEdit().set調査項目(data.getつめ切り()).build();
            builder.setTodokedesha(item);
        }
        if (!調査項目.contains(NinteichosaKomokuMapping09A.視力.getコード())) {
            NinteichosahyoChosaItem item = new NinteichosahyoChosaItem(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    rStringToInt(NinteichosaKomokuMapping09A.視力.getコード()));
            item = item.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            item = item.createBuilderForEdit().set調査項目(data.get視力()).build();
            builder.setTodokedesha(item);
        }
        if (!調査項目.contains(NinteichosaKomokuMapping09A.集団への不適応.getコード())) {
            NinteichosahyoChosaItem item = new NinteichosahyoChosaItem(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    rStringToInt(NinteichosaKomokuMapping09A.集団への不適応.getコード()));
            item = item.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            item = item.createBuilderForEdit().set調査項目(data.get集団への不適応()).build();
            builder.setTodokedesha(item);
        }
        if (!調査項目.contains(NinteichosaKomokuMapping09A.買い物.getコード())) {
            NinteichosahyoChosaItem item = new NinteichosahyoChosaItem(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    rStringToInt(NinteichosaKomokuMapping09A.買い物.getコード()));
            item = item.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            item = item.createBuilderForEdit().set調査項目(data.get買い物()).build();
            builder.setTodokedesha(item);
        }
        if (!調査項目.contains(NinteichosaKomokuMapping09A.簡単な調理.getコード())) {
            NinteichosahyoChosaItem item = new NinteichosahyoChosaItem(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    rStringToInt(NinteichosaKomokuMapping09A.簡単な調理.getコード()));
            item = item.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            item = item.createBuilderForEdit().set調査項目(data.get簡単な調理()).build();
            builder.setTodokedesha(item);
        }
        if (!調査項目.contains(NinteichosaKomokuMapping09A.点滴の管理.getコード())) {
            NinteichosahyoChosaItem item = new NinteichosahyoChosaItem(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    rStringToInt(NinteichosaKomokuMapping09A.点滴の管理.getコード()));
            item = item.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            item = item.createBuilderForEdit().set調査項目(data.get過去14日間に受けた治療_点滴の管理()).build();
            builder.setTodokedesha(item);
        }
        if (!調査項目.contains(NinteichosaKomokuMapping09A.透析.getコード())) {
            NinteichosahyoChosaItem item = new NinteichosahyoChosaItem(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    rStringToInt(NinteichosaKomokuMapping09A.透析.getコード()));
            item = item.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            item = item.createBuilderForEdit().set調査項目(data.get過去14日間に受けた治療_透折()).build();
            builder.setTodokedesha(item);
        }
        if (!調査項目.contains(NinteichosaKomokuMapping09A.ストーマの処置.getコード())) {
            NinteichosahyoChosaItem item = new NinteichosahyoChosaItem(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    rStringToInt(NinteichosaKomokuMapping09A.ストーマの処置.getコード()));
            item = item.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            item = item.createBuilderForEdit().set調査項目(data.get過去14日間に受けた治療_ストーマの処理()).build();
            builder.setTodokedesha(item);
        }
        if (!調査項目.contains(NinteichosaKomokuMapping09A.酸素療法.getコード())) {
            NinteichosahyoChosaItem item = new NinteichosahyoChosaItem(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    rStringToInt(NinteichosaKomokuMapping09A.酸素療法.getコード()));
            item = item.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            item = item.createBuilderForEdit().set調査項目(data.get過去14日間に受けた治療_酸素療法()).build();
            builder.setTodokedesha(item);
        }
        if (!調査項目.contains(NinteichosaKomokuMapping09A.レスピレーター.getコード())) {
            NinteichosahyoChosaItem item = new NinteichosahyoChosaItem(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    rStringToInt(NinteichosaKomokuMapping09A.レスピレーター.getコード()));
            item = item.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            item = item.createBuilderForEdit().set調査項目(data.get過去14日間に受けた治療_レスピレーター()).build();
            builder.setTodokedesha(item);
        }
        if (!調査項目.contains(NinteichosaKomokuMapping09A.気管切開の処置.getコード())) {
            NinteichosahyoChosaItem item = new NinteichosahyoChosaItem(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    rStringToInt(NinteichosaKomokuMapping09A.気管切開の処置.getコード()));
            item = item.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            item = item.createBuilderForEdit().set調査項目(data.get過去14日間に受けた治療_気管切開の処理()).build();
            builder.setTodokedesha(item);
        }
        if (!調査項目.contains(NinteichosaKomokuMapping09A.疼痛の看護.getコード())) {
            NinteichosahyoChosaItem item = new NinteichosahyoChosaItem(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    rStringToInt(NinteichosaKomokuMapping09A.疼痛の看護.getコード()));
            item = item.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            item = item.createBuilderForEdit().set調査項目(data.get過去14日間に受けた治療_疼痛()).build();
            builder.setTodokedesha(item);
        }
        if (!調査項目.contains(NinteichosaKomokuMapping09A.経管栄養.getコード())) {
            NinteichosahyoChosaItem item = new NinteichosahyoChosaItem(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    rStringToInt(NinteichosaKomokuMapping09A.経管栄養.getコード()));
            item = item.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            item = item.createBuilderForEdit().set調査項目(data.get過去14日間に受けた治療_経管栄養()).build();
            builder.setTodokedesha(item);
        }
        if (!調査項目.contains(NinteichosaKomokuMapping09A.モニター測定.getコード())) {
            NinteichosahyoChosaItem item = new NinteichosahyoChosaItem(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    rStringToInt(NinteichosaKomokuMapping09A.モニター測定.getコード()));
            item = item.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            item = item.createBuilderForEdit().set調査項目(data.get過去14日間に受けた治療_モニター測定()).build();
            builder.setTodokedesha(item);
        }
    }

    private void set新規調査項目5(NinteichosahyoKihonChosaBuilder builder, NinteiTorokuData data) {
        if (!調査項目.contains(NinteichosaKomokuMapping09A.じょくそうの処置.getコード())) {
            NinteichosahyoChosaItem item = new NinteichosahyoChosaItem(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    rStringToInt(NinteichosaKomokuMapping09A.じょくそうの処置.getコード()));
            item = item.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            item = item.createBuilderForEdit().set調査項目(data.get過去14日間に受けた治療_じょくそうの処置()).build();
            builder.setTodokedesha(item);
        }
        if (!調査項目.contains(NinteichosaKomokuMapping09A.カテーテル.getコード())) {
            NinteichosahyoChosaItem item = new NinteichosahyoChosaItem(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(),
                    rStringToInt(NinteichosaKomokuMapping09A.カテーテル.getコード()));
            item = item.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            item = item.createBuilderForEdit().set調査項目(data.get過去14日間に受けた治療_カテーテル()).build();
            builder.setTodokedesha(item);
        }
    }

    private int rStringToInt(RString サービスの状況_TMP) {
        return Integer.parseInt(サービスの状況_TMP.toString());
    }

}
