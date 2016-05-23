/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shinsakaishukeihyoshinsei;

import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 介護認定審査会集計表（申請区分別）のパラメータクラスです。
 *
 * @reamsid_L DBE-1450-080 dongyabin
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShinsakaiShukeihyoShinsei {

    private RString タイトル;
    private RString 市町村名称;
    private RString 抽出期間;
    private RDateTime 発行日時;
    private RString 申_新規申請_受付数;
    private RString 申_新規申請_調査数;
    private RString 申_新規申請_意見書数;
    private RString 申_新規申請_審査会数;
    private RString 申_新規申請_二次判定数;
    private RString 申_更新申請_受付数;
    private RString 申_更新申請_調査数;
    private RString 申_更新申請_意見書数;
    private RString 申_更新申請_審査会数;
    private RString 申_更新申請_二次判定数;
    private RString 申_区分変更申請_受付数;
    private RString 申_区分変更申請_調査数;
    private RString 申_区分変更申請_意見書数;
    private RString 申_区分変更申請_審査会数;
    private RString 申_区分変更申請_二次判定数;
    private RString 申_転入_受付数;
    private RString 申_転入_調査数;
    private RString 申_転入_意見書数;
    private RString 申_転入_審査会数;
    private RString 申_転入_二次判定数;
    private RString 申_合計_受付数;
    private RString 申_合計_調査数;
    private RString 申_合計_意見書数;
    private RString 申_合計_審査会数;
    private RString 申_合計_二次判定数;
    private RString 法_新規申請_受付数;
    private RString 法_新規申請_調査数;
    private RString 法_新規申請_意見書数;
    private RString 法_新規申請_審査会数;
    private RString 法_新規申請_二次判定数;
    private RString 法_更新申請_受付数;
    private RString 法_更新申請_調査数;
    private RString 法_更新申請_意見書数;
    private RString 法_更新申請_審査会数;
    private RString 法_更新申請_二次判定数;
    private RString 法_区分変更申請_受付数;
    private RString 法_区分変更申請_調査数;
    private RString 法_区分変更申請_意見書数;
    private RString 法_区分変更申請_審査会数;
    private RString 法_区分変更申請_二次判定数;
    private RString 法_転入_受付数;
    private RString 法_転入_調査数;
    private RString 法_転入_意見書数;
    private RString 法_転入_審査会数;
    private RString 法_転入_二次判定数;
    private RString 法_合計_受付数;
    private RString 法_合計_調査数;
    private RString 法_合計_意見書数;
    private RString 法_合計_審査会数;
    private RString 法_合計_二次判定数;
    private RString 法_新規申請_申_新規申請;
    private RString 法_新規申請_申_更新申請;
    private RString 法_新規申請_申_区分変更申請;
    private RString 法_更新申請_申_新規申請;
    private RString 法_更新申請_申_更新申請;
    private RString 法_更新申請_申_区分変更申請;
    private RString 法_区分変更申請_申_新規申請;
    private RString 法_区分変更申請_申_更新申請;
    private RString 法_区分変更申請_申_区分変更申請;
    private RString 法_区変却下_申_新規申請;
    private RString 法_区変却下_申_更新申請;
    private RString 法_区変却下_申_区分変更申請;

}
